package trabalho;

public class SimulacaoTest {

    public static void main(String[] args) {
        testarColisaoCaminhaoRemoveCarroEMoto();
        testarColisaoMesmoTipoRemoveDuplicados();
        testarGeracaoEmFabricaCriaNovoVeiculoUmaVez();
        testarGeracaoInicialNaoColocaVeiculoEmFabricaOuPosicaoOcupada();

        System.out.println("Todos os testes passaram.");
    }

    private static void testarColisaoCaminhaoRemoveCarroEMoto() {
        Mundo mundo = new Mundo();
        mundo.limparVeiculosParaTeste();

        mundo.adicionarVeiculoParaTeste(new Caminhao(10, 10, 1, "amarelo", false));
        mundo.adicionarVeiculoParaTeste(new Carro(10, 10, 2, "verde", false));
        mundo.adicionarVeiculoParaTeste(new Moto(10, 10, 3, "vermelho", false));

        mundo.detectaColisao();

        assertEquals(1, mundo.quantidadeVeiculos(), "Deveria sobrar apenas o caminhao");
        assertEquals(1, mundo.quantidadeVeiculos(Caminhao.class), "O caminhao deveria sobreviver");
        assertEquals(0, mundo.quantidadeVeiculos(Carro.class), "O carro deveria ser removido");
        assertEquals(0, mundo.quantidadeVeiculos(Moto.class), "A moto deveria ser removida");
    }

    private static void testarColisaoMesmoTipoRemoveDuplicados() {
        Mundo mundo = new Mundo();
        mundo.limparVeiculosParaTeste();

        mundo.adicionarVeiculoParaTeste(new Carro(8, 8, 2, "verde", false));
        mundo.adicionarVeiculoParaTeste(new Carro(8, 8, 2, "verde", false));

        mundo.detectaColisao();

        assertEquals(0, mundo.quantidadeVeiculos(), "Dois carros na mesma posicao devem ser removidos");
    }

    private static void testarGeracaoEmFabricaCriaNovoVeiculoUmaVez() {
        Mundo mundo = new Mundo();
        mundo.limparVeiculosParaTeste();

        mundo.adicionarVeiculoParaTeste(new Carro(4, 5, 2, "verde", false));

        mundo.geraVeiculo();
        int aposPrimeiraGeracao = mundo.quantidadeVeiculos(Carro.class);
        mundo.geraVeiculo();
        int aposSegundaGeracao = mundo.quantidadeVeiculos(Carro.class);

        assertEquals(2, aposPrimeiraGeracao, "Entrar na fabrica deveria gerar um novo carro");
        assertEquals(2, aposSegundaGeracao, "O mesmo carro nao deve gerar mais de uma vez");
    }

    private static void testarGeracaoInicialNaoColocaVeiculoEmFabricaOuPosicaoOcupada() {
        Mundo mundo = new Mundo();
        mundo.geraVeiculos();

        assertEquals(30, mundo.quantidadeVeiculos(), "A geracao inicial deveria criar 30 veiculos");
        assertFalse(mundo.existeVeiculoEmFabricaParaTeste(), "Nenhum veiculo inicial deveria nascer em fabrica");
        assertEquals(
            30,
            mundo.quantidadePosicoesOcupadasParaTeste(),
            "A geracao inicial nao deveria sobrepor veiculos"
        );
    }

    private static void assertEquals(int esperado, int atual, String mensagem) {
        if (esperado != atual) {
            throw new IllegalStateException(mensagem + " Esperado=" + esperado + ", atual=" + atual);
        }
    }

    private static void assertFalse(boolean valor, String mensagem) {
        if (valor) {
            throw new IllegalStateException(mensagem);
        }
    }
}
