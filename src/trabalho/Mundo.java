/**
 * Mundo
 * Classe que gera mundo
 * 
 * @author Filipi de Luca Valim dos Santos
 * 
 * @see Mundo
 */

package trabalho;

import java.util.ArrayList;

public class Mundo {
    
        /**
	 * Instanciando a classe veículo
	 */
    
    Veiculo v = new Veiculo();
    
        /**
	 * Gerando ArrayList de cada um dos veículos
	 */
    
        ArrayList <Carro> car = new ArrayList<>();///Carro
	ArrayList <Caminhao> cao = new ArrayList<>();///Caminhão
	ArrayList <Moto> moto = new ArrayList<>();///Moto
    
    
    public int mapa[][] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
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
            		   {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    
    
        /**
	 * Função que gera veículos aleatóriamente
	 */
   public void geraVeiculos() {
		for(int i = 0; i < 10; i++) {
			car.add(new Carro((v.setX()+1), (v.setY()+1), 2, "verde", false));
			while (mapa[car.get(i).getX()][car.get(i).getY()] == 2) {/**< Verificando se o carro foi gerado onde há uma fábrica, se sim, trocando-o */ 
				car.get(i).setX();
				car.get(i).setY();
			}

			cao.add(new Caminhao((v.setX()+1), (v.setY()+1), 1, "amarelo", false));
			while (mapa[cao.get(i).getX()][cao.get(i).getY()] == 2) {
				cao.get(i).setX();
				cao.get(i).setY();
			}

			moto.add(new Moto((v.setX()+1), (v.setY()+1), 3, "vermelho", false));
			while (mapa[moto.get(i).getX()][moto.get(i).getY()] == 2) {
				moto.get(i).setX();
				moto.get(i).setY();
			}
		}		
	}
        /**
	 * Função que reinicia o mapa, acabando com o rastro dos veículos
	 */
    
    public void zeraMapa() {
		for(int i = 0; i<30; i++) {
			for(int j = 0; j < 60; j++) {
				if(mapa[i][j] != 1 && mapa[i][j] != 2) {
					mapa[i][j] = 0;
				}
			}
		}
                for (int a = 0; a < car.size(); a++) {
			
			int xcar = car.get(a).getX();                        
			int ycar = car.get(a).getY();
			

			for(int i = 0; i<30; i++) {
				for(int j = 0; j < 60; j++) {
					if(i == xcar && j == ycar) {
						if(mapa[i][j] == 2) {
							mapa[i][j] = 2; 
							
						}
						else {
							mapa[i][j] = 3;
						}
					}
				}
			}
		}
                /**
		 * Adicionando os novos veículos no mapa
		 */
		
		for(int a  = 0; a < cao.size(); a++) {
                    /// Obtendo as corrdenadas do veÃículo
			int xcao = cao.get(a).getX();
			int ycao = cao.get(a).getY();
			
			for(int i = 0; i<30; i++) {
				for(int j = 0; j < 60; j++) {
					if(i == xcao && j == ycao) {
						if(mapa[i][j] == 2) {
							mapa[i][j] = 2;
							
						}
						else {
							mapa[i][j] = 4;
						}
					}
				}
			}
		}
		
		for(int a = 0; a < moto.size(); a ++) {
			int xm = moto.get(a).getX();
			int ym = moto.get(a).getY();
			
			for(int i = 0; i<30; i++) {
				for(int j = 0; j < 60; j++) {
					if(i == xm && j == ym) {
						if(mapa[i][j] == 2) {
							mapa[i][j] = 2;
							
						}
						else {
							mapa[i][j] = 5;
						}
					}
				}
			}	
		}
		
	}
        /**
	 * Função que desenha o mundo
	 */
    
    public void desenhaMundo() {
        
                /**
		 * Variaveís que recebem o código da cor e auxíliam na hora de imprimir na tela
		 */
                String map = "\u001B[37m";///Código referente a cor WHITE
                String fabrica = "\u001B[35m";///Código referente a cor MAGENTA
                String limite = "\u001B[36m" ;///Código referente a cor CYAN 
		String carroVermelho = "\u001B[31m";///Código referente a cor RED
                String camiAmarelo = "\u001B[33m";///Código referente a cor YELLOW
                String motoAzul = "\u001B[34m";///Código referente a cor BLUE
                 /**
		 * Contadores para exibição de veículos na tela
		 */
		int carros = 0;
		int motos = 0;
		int caminhoes = 0;
		
			for(int i = 0; i<30; i++) {
				for(int j = 0; j < 60; j++) {
					
                                        /**
					 * Desenhando o mapa 
					 */
					
					if(mapa[i][j] == 1) {
						System.out.print(limite + "█");
					}
					else if(mapa[i][j] == 0) {
						System.out.print(map + "█");
					}
					
					else if(mapa[i][j] == 2) {
						System.out.print(fabrica + "█");
					}
					else if(mapa[i][j] == 3){
						System.out.print(carroVermelho + "█");
					}
					else if(mapa[i][j] == 4){
						System.out.print(camiAmarelo + "█");
					}
					else if(mapa[i][j] == 5){
						System.out.print(motoAzul + "█");
					}
					
				}
				
				System.out.println("");
			}	
			
                         /**
			 * Imprimindo a legenda
			 */
			
			System.out.print(carroVermelho + "█");
			System.out.print(" Carros   ");
			System.out.print(camiAmarelo + "█");
			System.out.print(" Caminhão   ");
			System.out.print(motoAzul + "█");
			System.out.println(" Motos");
			
                        /**
			 * Contadores de veículos
			 */
			
			for(int a = 0; a < car.size(); a++) {
				carros++;
			}
			for(int a = 0; a < cao.size(); a++) {
				caminhoes++;
			}
			for(int a = 0; a < moto.size(); a++) {
				motos++;
			}
			
		
			System.out.println("Numero de Carros: " + carros);
			System.out.println("Numero de Caminhoes: " + caminhoes);
			System.out.println("Numero de Motos: " + motos);
	}
	
	/**
	 * Função que atualiza o mundo fazendo os veículos se moverem
	 */
	public void atualizaMundo() {
		for(int i = 0; i < car.size(); i++) {
			car.get(i).moveCarro(car.get(i));
		}
		
		for (int i = 0; i < cao.size(); i ++) {
			cao.get(i).moveCaminhao(cao.get(i));
		}
		
		for (int i = 0; i < moto.size(); i ++) {
			moto.get(i).moveMoto(moto.get(i));
		}
		
		geraVeiculo();
		detectaColisao();
		zeraMapa();
		desenhaMundo();
	}
	/**
	 * Função que detecta colisão entre os veículos
	 */
	
	public void detectaColisao() {
		/// Colisão carro com carro
		for (int i = 0; i < car.size(); i ++) {
			for (int j = 0; j < car.size(); j++) {
				if(car.get(j).getX() == car.get(i).getX() && car.get(j).getY() == car.get(i).getY()) {
					if (i == j) { 
						
					}
					else {
						car.remove(car.get(i));
					}	
				}
			}
		}
		/// Colisão caminhão com caminhão
		
		for (int i = 0; i < cao.size(); i ++) {
			for (int j = 0; j < cao.size(); j++) {
				if(cao.get(j).getX() == cao.get(i).getX() && cao.get(j).getY() == cao.get(i).getY()) {
					if(i == j) {
						
					}
					else {
						cao.remove(cao.get(i));
					}	
				}
			}
		}
		
		/// Colisão moto com moto
		for (int i = 0; i < moto.size(); i ++) {
			for (int j = 0; j < moto.size(); j++) {
				if(moto.get(j).getX() == moto.get(i).getX() && moto.get(j).getY() == moto.get(i).getY()) {
					if(i == j) {
						
					}
					else {
						moto.remove(moto.get(i));
					}	
				}
			}
		}
		
		/// Colisão entre caminhão e carro
		for(int i = 0; i < cao.size(); i++) {
			for (int j = 0; j < car.size(); j++) {
				if(car.get(j).getX() == cao.get(i).getX() && car.get(j).getY() == cao.get(i).getY()) {
					if(cao.size() > car.size()) {
						
					}
					else {
						car.remove(car.get(j));
					}
				}
			}
		}
		
		/// Colisão entre caminhão e moto
		for(int i = 0; i < cao.size(); i++) {
			for (int j = 0; j < moto.size(); j++) {
				if(moto.get(j).getX() == cao.get(i).getX() && moto.get(j).getY() == cao.get(i).getY()) {
					if(cao.size() > moto.size()) {
						
					}
					else {
						moto.remove(moto.get(j));
					}
				}
			}
		}
		
		/// Colisão entre moto e carro
		for(int i = 0; i < car.size(); i++) {
			for (int j = 0; j < moto.size(); j++) {
				if(moto.get(j).getX() == car.get(i).getX() && moto.get(j).getY() == car.get(i).getY()) {
					if(car.size()>moto.size()) {
						
					}
					else {
						moto.remove(moto.get(i));
					}
					
				}
			}
		}
	}
	
	/**
	 * Função que gera um veículo na fábricas quando o mesmo entra nela
	 */
	public void geraVeiculo() {
		for(int a = 0; a < car.size(); a++) {
			int x = car.get(a).getX();
			int y = car.get(a).getY();
				for(int i = 0; i < 30; i ++) {
					for(int j = 0; j < 60; j++) {
						if(i == x && j == y) {
							if(mapa[i][j] == 2 && car.get(a).isFabrica() == false) {
								car.get(a).setFabrica(true);///O veículo não gera mais um outro veículo se ele ja foi gerado antes 
								car.add(new Carro((v.setX()+1), (v.setY()+1), 2, "verde", false));
								}
							}
						}
					}
				}
		
		for(int a = 0; a < cao.size(); a++) {
			int x = cao.get(a).getX();
			int y = cao.get(a).getY();
				for(int i = 0; i < 30; i ++) {
					for(int j = 0; j < 60; j++) {
						if(i == x && j == y) {
							if(mapa[i][j] == 2 && cao.get(a).isFabrica() == false) {
								cao.get(a).setFabrica(true);
								cao.add(new Caminhao((v.setX()+1), (v.setY()+1), 1, "verde", false));
								}
							}
						}
					}
				}
		
	
		for(int a = 0; a < moto.size(); a++) {
			int x = moto.get(a).getX();
			int y = moto.get(a).getY();
				for(int i = 0; i < 30; i ++) {
					for(int j = 0; j < 60; j++) {
						if(i == x && j == y) {
							if(mapa[i][j] == 2 && moto.get(a).isFabrica() == false) {
								moto.get(a).setFabrica(true);
								moto.add(new Moto((v.setX()+1), (v.setY()+1), 3, "vermelho", false));
							}
						}
					}
				}
		}
	}

    }
    
    

