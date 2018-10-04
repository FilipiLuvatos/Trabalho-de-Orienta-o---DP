package trabalho;


public class Caminhao extends Veiculo {
    
    Veiculo v = new Veiculo();
    
    public Caminhao (int x, int y, int velocidade, String cor, boolean fabrica) {
		super(x, y, velocidade, cor, fabrica);
	}
    
}
