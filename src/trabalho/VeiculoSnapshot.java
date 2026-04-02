package trabalho;

public record VeiculoSnapshot(
    String tipo,
    int x,
    int y,
    int velocidade,
    String cor,
    boolean gerouEmFabrica
) {
}
