package trabalho;

import java.util.List;

public record EstadoSimulacao(
    int ciclo,
    boolean emExecucao,
    int linhas,
    int colunas,
    String[][] grade,
    EstatisticasSimulacao estatisticas,
    List<VeiculoSnapshot> veiculos
) {
}
