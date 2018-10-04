package trabalho;

public class Carro extends Veiculo {
    
    Veiculo v = new Veiculo();
    
    public Carro (int x, int y, int velocidade, String cor, boolean fabrica) {
		super(x, y, velocidade, cor, fabrica);
	}
    
}
