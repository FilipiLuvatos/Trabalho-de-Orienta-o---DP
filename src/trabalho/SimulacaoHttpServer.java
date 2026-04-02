package trabalho;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulacaoHttpServer {

    private static final int PORTA_PADRAO = 8080;
    private static final int INTERVALO_MS = 300;

    private final int porta;
    private final SimulacaoServico simulacaoServico;
    private final ScheduledExecutorService executor;
    private final HttpServer server;

    public SimulacaoHttpServer(int porta) throws IOException {
        this.porta = porta;
        simulacaoServico = new SimulacaoServico();
        executor = Executors.newSingleThreadScheduledExecutor();
        server = HttpServer.create(new InetSocketAddress(porta), 0);

        server.createContext("/api/state", exchange -> responderEstado(exchange, simulacaoServico.obterEstado()));
        server.createContext("/api/step", novoHandlerPost(exchange -> responderEstado(exchange, simulacaoServico.avancarPasso())));
        server.createContext("/api/pause", novoHandlerPost(exchange -> responderEstado(exchange, simulacaoServico.pausar())));
        server.createContext("/api/resume", novoHandlerPost(exchange -> responderEstado(exchange, simulacaoServico.retomar())));
        server.createContext("/api/reset", novoHandlerPost(exchange -> responderEstado(exchange, simulacaoServico.reiniciar())));
        server.setExecutor(Executors.newCachedThreadPool());
    }

    public void iniciar() {
        executor.scheduleAtFixedRate(() -> {
            if (simulacaoServico.isEmExecucao()) {
                simulacaoServico.avancarPasso();
            }
        }, INTERVALO_MS, INTERVALO_MS, TimeUnit.MILLISECONDS);

        server.start();
        System.out.println("Servidor da simulacao disponivel em http://localhost:" + porta);
    }

    public static void main(String[] args) throws IOException {
        new SimulacaoHttpServer(PORTA_PADRAO).iniciar();
    }

    private HttpHandler novoHandlerPost(HttpHandler handler) {
        return exchange -> {
            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                responderSemCorpo(exchange, 204);
                return;
            }

            if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                responderSemCorpo(exchange, 405);
                return;
            }

            handler.handle(exchange);
        };
    }

    private void responderEstado(HttpExchange exchange, EstadoSimulacao estado) throws IOException {
        if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
            responderSemCorpo(exchange, 204);
            return;
        }

        if (!"GET".equalsIgnoreCase(exchange.getRequestMethod()) && !"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            responderSemCorpo(exchange, 405);
            return;
        }

        byte[] corpo = JsonUtil.paraJson(estado).getBytes(StandardCharsets.UTF_8);
        adicionarCabecalhos(exchange);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.sendResponseHeaders(200, corpo.length);

        try (OutputStream output = exchange.getResponseBody()) {
            output.write(corpo);
        }
    }

    private void responderSemCorpo(HttpExchange exchange, int status) throws IOException {
        adicionarCabecalhos(exchange);
        exchange.sendResponseHeaders(status, -1);
        exchange.close();
    }

    private void adicionarCabecalhos(HttpExchange exchange) {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
    }
}
