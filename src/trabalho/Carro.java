package trabalho;

import java.util.Random;

public class Carro extends Veiculo {
    
    Veiculo v = new Veiculo();
    
    public Carro (int x, int y, int velocidade, String cor, boolean fabrica) {
		super(x, y, velocidade, cor, fabrica);
	}
    
}
