/**
 * Mundo
 * Classe que gera o mundo da simulacao.
 *
 * @author Filipi de Luca Valim dos Santos
 */
package trabalho;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Mundo {

    private static final int LINHAS = 30;
    private static final int COLUNAS = 60;
    private static final int LIMITE = 1;
    private static final int VAZIO = 0;
    private static final int FABRICA = 2;
    private static final int CODIGO_CARRO = 3;
    private static final int CODIGO_CAMINHAO = 4;
    private static final int CODIGO_MOTO = 5;

    private static final String SIMBOLO_LIMITE = "#";
    private static final String SIMBOLO_VAZIO = ".";
    private static final String SIMBOLO_FABRICA = "F";
    private static final String SIMBOLO_CARRO = "C";
    private static final String SIMBOLO_CAMINHAO = "T";
    private static final String SIMBOLO_MOTO = "M";

    private final Veiculo geradorPosicao = new Veiculo();
    private final ArrayList<Veiculo> veiculos = new ArrayList<>();

    public int mapa[][] = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public void geraVeiculos() {
        for (int i = 0; i < 10; i++) {
            veiculos.add(criarVeiculoAleatorio(Carro.class));
            veiculos.add(criarVeiculoAleatorio(Caminhao.class));
            veiculos.add(criarVeiculoAleatorio(Moto.class));
        }
        zeraMapa();
    }

    public void zeraMapa() {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (mapa[i][j] != LIMITE && mapa[i][j] != FABRICA) {
                    mapa[i][j] = VAZIO;
                }
            }
        }

        for (int i = 0; i < veiculos.size(); i++) {
            posicionaVeiculoNoMapa(veiculos.get(i));
        }
    }

    public void desenhaMundo() {
        limpaTela();

        String map = "\u001B[37m";
        String fabrica = "\u001B[35m";
        String limite = "\u001B[36m";
        String carroVermelho = "\u001B[31m";
        String camiAmarelo = "\u001B[33m";
        String motoAzul = "\u001B[34m";

        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (mapa[i][j] == LIMITE) {
                    System.out.print(limite + SIMBOLO_LIMITE);
                } else if (mapa[i][j] == VAZIO) {
                    System.out.print(map + SIMBOLO_VAZIO);
                } else if (mapa[i][j] == FABRICA) {
                    System.out.print(fabrica + SIMBOLO_FABRICA);
                } else if (mapa[i][j] == CODIGO_CARRO) {
                    System.out.print(carroVermelho + SIMBOLO_CARRO);
                } else if (mapa[i][j] == CODIGO_CAMINHAO) {
                    System.out.print(camiAmarelo + SIMBOLO_CAMINHAO);
                } else if (mapa[i][j] == CODIGO_MOTO) {
                    System.out.print(motoAzul + SIMBOLO_MOTO);
                }
            }
            System.out.println("");
        }

        System.out.print(carroVermelho + SIMBOLO_CARRO);
        System.out.print(" Carros   ");
        System.out.print(camiAmarelo + SIMBOLO_CAMINHAO);
        System.out.print(" Caminhao   ");
        System.out.print(motoAzul + SIMBOLO_MOTO);
        System.out.println(" Motos");
        System.out.print(fabrica + SIMBOLO_FABRICA);
        System.out.print(" Fabricas   ");
        System.out.print(limite + SIMBOLO_LIMITE);
        System.out.println(" Limites");

        System.out.println("Numero de Carros: " + contarPorTipo(Carro.class));
        System.out.println("Numero de Caminhoes: " + contarPorTipo(Caminhao.class));
        System.out.println("Numero de Motos: " + contarPorTipo(Moto.class));
        System.out.print("\u001B[0m");
    }

    public void atualizaMundo() {
        for (int i = 0; i < veiculos.size(); i++) {
            moverVeiculo(veiculos.get(i));
        }

        geraVeiculo();
        detectaColisao();
        zeraMapa();
        desenhaMundo();
    }

    public void detectaColisao() {
        Set<String> posicoesComCarros = coletarPosicoes(Carro.class);
        Set<String> posicoesComCaminhoes = coletarPosicoes(Caminhao.class);
        Set<String> posicoesComMotos = coletarPosicoes(Moto.class);

        Set<String> carrosRemovidos = coletarDuplicados(Carro.class);
        Set<String> caminhoesRemovidos = coletarDuplicados(Caminhao.class);
        Set<String> motosRemovidas = coletarDuplicados(Moto.class);

        for (String posicao : posicoesComCaminhoes) {
            if (!caminhoesRemovidos.contains(posicao)) {
                carrosRemovidos.add(posicao);
                motosRemovidas.add(posicao);
            }
        }

        for (String posicao : posicoesComCarros) {
            if (!carrosRemovidos.contains(posicao)) {
                motosRemovidas.add(posicao);
            }
        }

        Set<String> posicoesRemovidas = new HashSet<>();
        posicoesRemovidas.addAll(carrosRemovidos);
        posicoesRemovidas.addAll(caminhoesRemovidos);
        posicoesRemovidas.addAll(motosRemovidas);

        for (int i = veiculos.size() - 1; i >= 0; i--) {
            Veiculo veiculo = veiculos.get(i);
            if (deveRemover(veiculo, carrosRemovidos, caminhoesRemovidos, motosRemovidas, posicoesRemovidas)) {
                veiculos.remove(i);
            }
        }
    }

    public void geraVeiculo() {
        ArrayList<Veiculo> novosVeiculos = new ArrayList<>();

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            if (ehFabrica(veiculo.getX(), veiculo.getY()) && !veiculo.isFabrica()) {
                veiculo.setFabrica(true);
                novosVeiculos.add(criarVeiculoAleatorio(veiculo.getClass()));
            }
        }

        veiculos.addAll(novosVeiculos);
    }

    private void moverVeiculo(Veiculo veiculo) {
        if (veiculo instanceof Carro) {
            veiculo.moveCarro((Carro) veiculo);
        } else if (veiculo instanceof Caminhao) {
            veiculo.moveCaminhao((Caminhao) veiculo);
        } else if (veiculo instanceof Moto) {
            veiculo.moveMoto((Moto) veiculo);
        }
    }

    private Veiculo criarVeiculoAleatorio(Class<? extends Veiculo> tipo) {
        int[] posicao = sorteiaPosicaoLivre();

        if (tipo == Carro.class) {
            return new Carro(posicao[0], posicao[1], 2, "verde", false);
        }
        if (tipo == Caminhao.class) {
            return new Caminhao(posicao[0], posicao[1], 1, "amarelo", false);
        }
        return new Moto(posicao[0], posicao[1], 3, "vermelho", false);
    }

    private int[] sorteiaPosicaoLivre() {
        int x;
        int y;

        do {
            x = geradorPosicao.sortearX() + 1;
            y = geradorPosicao.sortearY() + 1;
        } while (ehFabrica(x, y) || existeVeiculoNaPosicao(x, y));

        return new int[]{x, y};
    }

    private boolean ehFabrica(int x, int y) {
        return mapa[x][y] == FABRICA;
    }

    private boolean existeVeiculoNaPosicao(int x, int y) {
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            if (veiculo.getX() == x && veiculo.getY() == y) {
                return true;
            }
        }
        return false;
    }

    private void posicionaVeiculoNoMapa(Veiculo veiculo) {
        if (!ehFabrica(veiculo.getX(), veiculo.getY())) {
            mapa[veiculo.getX()][veiculo.getY()] = codigoDoVeiculo(veiculo);
        }
    }

    private int codigoDoVeiculo(Veiculo veiculo) {
        if (veiculo instanceof Carro) {
            return CODIGO_CARRO;
        }
        if (veiculo instanceof Caminhao) {
            return CODIGO_CAMINHAO;
        }
        return CODIGO_MOTO;
    }

    private int contarPorTipo(Class<? extends Veiculo> tipo) {
        int quantidade = 0;

        for (int i = 0; i < veiculos.size(); i++) {
            if (tipo.isInstance(veiculos.get(i))) {
                quantidade++;
            }
        }

        return quantidade;
    }

    private Set<String> coletarPosicoes(Class<? extends Veiculo> tipo) {
        Set<String> posicoes = new HashSet<>();

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            if (tipo.isInstance(veiculo)) {
                posicoes.add(chavePosicao(veiculo.getX(), veiculo.getY()));
            }
        }

        return posicoes;
    }

    private Set<String> coletarDuplicados(Class<? extends Veiculo> tipo) {
        Set<String> posicoes = new HashSet<>();
        Set<String> duplicados = new HashSet<>();

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            if (tipo.isInstance(veiculo)) {
                String posicao = chavePosicao(veiculo.getX(), veiculo.getY());
                if (!posicoes.add(posicao)) {
                    duplicados.add(posicao);
                }
            }
        }

        return duplicados;
    }

    private boolean deveRemover(
        Veiculo veiculo,
        Set<String> carrosRemovidos,
        Set<String> caminhoesRemovidos,
        Set<String> motosRemovidas,
        Set<String> posicoesRemovidas
    ) {
        String posicao = chavePosicao(veiculo.getX(), veiculo.getY());

        if (veiculo instanceof Carro) {
            return carrosRemovidos.contains(posicao);
        }
        if (veiculo instanceof Caminhao) {
            return caminhoesRemovidos.contains(posicao);
        }
        if (veiculo instanceof Moto) {
            return motosRemovidas.contains(posicao);
        }

        return posicoesRemovidas.contains(posicao);
    }

    private String chavePosicao(int x, int y) {
        return x + ":" + y;
    }

    private void limpaTela() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    void limparVeiculosParaTeste() {
        veiculos.clear();
        zeraMapa();
    }

    void adicionarVeiculoParaTeste(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    int quantidadeVeiculos() {
        return veiculos.size();
    }

    int quantidadeVeiculos(Class<? extends Veiculo> tipo) {
        return contarPorTipo(tipo);
    }

    boolean posicaoLivreParaTeste(int x, int y) {
        return !ehFabrica(x, y) && !existeVeiculoNaPosicao(x, y);
    }

    boolean existeVeiculoEmFabricaParaTeste() {
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            if (ehFabrica(veiculo.getX(), veiculo.getY())) {
                return true;
            }
        }
        return false;
    }

    int quantidadePosicoesOcupadasParaTeste() {
        Set<String> posicoes = new HashSet<>();

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            posicoes.add(chavePosicao(veiculo.getX(), veiculo.getY()));
        }

        return posicoes.size();
    }
}
