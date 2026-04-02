package trabalho;

public class SimulacaoServico {

    private final Mundo mundo = new Mundo();
    private int ciclo;
    private boolean emExecucao = true;

    public SimulacaoServico() {
        reiniciar();
    }

    public synchronized EstadoSimulacao obterEstado() {
        return mundo.criarEstado(ciclo, emExecucao);
    }

    public synchronized EstadoSimulacao avancarPasso() {
        mundo.avancarSimulacao();
        ciclo++;
        return obterEstado();
    }

    public synchronized EstadoSimulacao reiniciar() {
        ciclo = 0;
        emExecucao = true;
        mundo.limparVeiculosParaTeste();
        mundo.geraVeiculos();
        return obterEstado();
    }

    public synchronized EstadoSimulacao pausar() {
        emExecucao = false;
        return obterEstado();
    }

    public synchronized EstadoSimulacao retomar() {
        emExecucao = true;
        return obterEstado();
    }

    public synchronized boolean isEmExecucao() {
        return emExecucao;
    }
}
