/**
 * Carro
 * Classe que gera um veículo do tipo Carro
 * 
 * @author Filipi de Luca Valim dos Santos
 * 
 * @see Veiculo
 */

package trabalho;

public class Carro extends Veiculo {
    
    Veiculo v = new Veiculo();
    /**
	 * Construtor da classe Carro, que usa um super para chamar o construtor da classe Veículo
	 * 
	 * @see Veiculo
	 * @param x
	 * @param y
	 * @param velocidade
	 * @param cor
	 * @param fabrica
	 */
    
    public Carro (int x, int y, int velocidade, String cor, boolean fabrica) {
		super(x, y, velocidade, cor, fabrica);
	}
    
}
