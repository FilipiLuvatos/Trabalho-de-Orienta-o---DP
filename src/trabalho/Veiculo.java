/**
 * Veículo
 * Classe que gera um veículo que sera usado por carro,moto e caminhão
 * 
 * @author Filipi de Luca Valim dos Santos
 * 
 * @see Veiculo
 */

package trabalho;

import java.util.Random;

public class Veiculo {
    
    	Random r = new Random();/// Função random, utilizada para gerar posições aleatórias 
        
        /**
	 * Construtor da classe Veículo
	 * Incializa as váriaveis de veículo
	 */
    
    public Veiculo() {
        x = 0; 
        y = 0; 
        velocidade = 0; 
        fabrica = false; 
        cor = null; 
	}
    
    	/**
	 * Construtor da classe Veículo
	 * Cria veículos com variáveis que são recebidas na chamada das funções de cada veículo específico
	 * 
	 * @param x 
	 * @param y
	 * @param velocidade
	 * @param cor
	 * @param fabrica
	 */
    
    public Veiculo(int x, int y, int velocidade, String cor, boolean fabrica) {
        
        
		this.x = x;
		this.y = y;
		this.velocidade = velocidade;
		this.cor = cor;
		this.fabrica = fabrica;
                
	}
    /**
	 * Cria um valor aleatório para o X do veículo
	 * 
	 * @return O valor gerado para X
	 */
    public int setX() {
        
        x =  r.nextInt(28);
        
        return x;
    }
    /**
	 * Cria um valor aleatório para o Y do veículo
	 * 
	 * @return O valor gerado para Y
	 */
    
    public int setY() {
        
	y = r.nextInt(58);
        
	return y;
    }
    /**
	 * @return O valor de X do veículo
	 */
    public int getX() {
        return x;
    }

    /**
	 * @return O valor de Y do veículo
	 */

    public int getY() {
        return y;
    }
    /**
	 * Altera o valor de X de um veículo com base no que será passado dentro de cada veículo
	 * 
	 * @param x
	 */

    public void MoveX(int x) {
        this.x = x;
    }
    /**
	 * Altera o valor de Y de um veículo com base no que será passado dentro de cada veículo 
	 * 
	 * @param y
	 */
    
    public void MoveY(int y) {
        
	this.y = y;
        
    }
    

    /**
	 * @return Se um veículo está ou não em uma fábrica
	 */

    public boolean isFabrica() {
        return fabrica;
    }
    /**
	 * Define se um veiculo está ou não dentro de uma fábrica, com base no que é recebido em status
	 * 
	 * @param ´fabrica 
	 */

    public void setFabrica(boolean fabrica) {
        this.fabrica = fabrica;
    }

    
    /**
	 * @return A cor do veículo
	 */

    public String getCor() {
        return cor;
    }

    
    /**
	 * @return A velocidade do veículo
	 */

    public int getVelocidade() {
        return velocidade;
    }
        /**
	 * Random utilizado para gerar movimentos aleatórios
	 */
    Random car = new Random();
    
        /**
	 * Função que movimenta o carro, recebendo um objeto da classe carro como parâmetro
	 * @param ca
	 */
    
    public void moveCarro(Carro ca){
        int mov;///"mov" recebe o número aleatório
        
        	mov = car.nextInt(4); ///< Gerando um número aleatório para movimentação do veículo em 4 direções possíveis(cima,baixo,esquerda,direta)
		
		/**
		 * Ifs para verificar o resultado obtido no random e 
                 * poder decidir em qual direção o carro irá se movimentar
		 */
                
		if(mov == 0) {
			int x1 = ca.getX(); ///< Obtendo o valor atual de X
			x1 = x1 + 2;///< Somando 2 (velocidade do carro) no valor atual de X 
			ca.MoveX(verificaX(x1));///< Chamando a função moveX da classe Veículo para realizar a movimentação 
		}	
                /**
		 * O if a cima se repete no restante da função, só muda a direção 
		 */
		
		if(mov == 1) {
			int x2 = ca.getX();
			x2 = x2 - 2;
			ca.MoveX(verificaX(x2));
		}
		
		if(mov == 2) {
			int y1 = ca.getY();
			y1 = y1 + 2;
			ca.MoveY(verificaY(y1));
		}
		
		if(mov == 3) {
			int y2 = ca.getY();
			y2 = y2 - 2;
			ca.MoveY(verificaY(y2));
		}          
             
               
    }
    
        /**
	 * Random utilizado para gerar movimentos aleatórios
	 */
    Random truck = new Random();
    
    /**
	 * Função que movimenta o caminhão, recebendo um objeto da classe caminhão como parâmetro
	 * @param ca
	 */
    
     public void moveCaminhao(Caminhao ca){
         
        int mov;///"mov" recebe o número aleatório
        
        	mov = truck.nextInt(4);///< Gerando um número aleatório para movimentação do veículo em 4 direções possíveis(cima,baixo,esquerda,direta) 
		
                /**
		 * Ifs para verificar o resultado obtido no random e 
                 * poder decidir em qual direção o carro irá se movimentar
		 */
		
		if(mov == 0) {
			int x1 = ca.getX(); ///< Obtendo o valor atual de X
			x1 = x1 + 1;///< Somando 1 (velocidade do caminhão) no valor atual de X 
			ca.MoveX(verificaX(x1)); ///< Chamando a função moveX da classe Veículo para realizar a movimentação
		}		
		
                /**
		 * O if a cima se repete no restante da função, só muda a direção 
		 */
                
		if(mov == 1) {
			int x2 = ca.getX();
			x2 = x2 - 1;
			ca.MoveX(verificaX(x2));
		}
		
		if(mov == 2) {
			int y1 = ca.getY();
			y1 = y1 + 1;
			ca.MoveY(verificaY(y1));
		}
		
		if(mov == 3) {
			int y2 = ca.getY();
			y2 = y2 - 1;
			ca.MoveY(verificaY(y2));
		}        
        
    }
        /**
	 * Random utilizado para gerar movimentos aleatórios
	 */
     Random moty = new Random();
     
     /**
	 * Função que movimenta a moto, recebendo um objeto da classe moto como parâmetro
	 * @param m
	 */
     
      public void moveMoto(Moto m){
          
          int mov;///"mov" recebe o número aleatório
        
        	mov = moty.nextInt(4);///< Gerando um número aleatório para movimentação do veículo em 4 direções possíveis(cima,baixo,esquerda,direta) 
		
		
		if(mov == 0) {
			int x1 = m.getX(); ///< Obtendo o valor atual de X
			x1 = x1 + 3; ///< Somando 3 (velocidade da moto) no valor atual de X
			m.MoveX(verificaX(x1)); ///< Chamando a função moveX da classe Veículo para realizar a movimentação
		}
                
                /**
		 * O if a cima se repete no restante da função, só muda a direção 
		 */
		
		if(mov == 1) {
			int x2 = m.getX();
			x2 = x2 - 3;
			m.MoveX(verificaX(x2));
		}
		
		if(mov == 2) {
			int y1 = m.getY();
			y1 = y1 + 3;
			m.MoveY(verificaY(y1));
		}
		
		if(mov == 3) {
			int y2 = m.getY();
			y2 = y2 - 3;
			m.MoveY(verificaY(y2));
		}        
        
        
    }
      /**
	 * Função que verifica se o veículo chegou ao limite do mapa em X e reseta a coordenada
	 * @param x
	 * @return
	 */
      public int verificaX(int x) {
		if (x >= 29) {
			x = 1;
		}
		if(x <= 0) {
			x = 28;
		}
		return x;
	}
      
      /**
	 * Função que verifica se o veículo chegou ao limite do mapa em Y e reseta a coordenada
	 * @param y
	 * @return
	 */
	
	
	public int verificaY(int y) {
		if (y >= 59) {
			y = 1;
		}
		if(y <= 0) {
			y = 58;
		}
		return y;
	}  
    
    
    
    
    
        
        private int x; /// Coordenada X do veículo
	private int y; /// Coordenada Y do veículo
	private int velocidade; /// Velocidade do veículo
	private boolean fabrica; /// Informa se o veículo está¡ ou não em uma fábrica
	private String cor; ///Cor dos veículo
    
}
