/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.ArrayList;

public class Mundo {
    
    
    Veiculo v = new Veiculo();
    
        ArrayList <Carro> car = new ArrayList<>();
	ArrayList <Caminhao> cao = new ArrayList<>();
	ArrayList <Moto> moto = new ArrayList<>();
    
    
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
    
    
    
   public void geraVeiculos() {
		for(int i = 0; i < 10; i++) {
			car.add(new Carro((v.setX()+1), (v.setY()+1), 2, "verde", false));
			while (mapa[car.get(i).getX()][car.get(i).getY()] == 2) { 
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
		
		for(int a  = 0; a < cao.size(); a++) {
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
    
    public void desenhaMundo() {
		String fabrica = "\u001B[35m" ;
                String limite = "\u001B[36m" ; 
		String carroVermelho = "\u001B[31m";
                String camiAmarelo = "\u001B[33m";
                String motoAzul = "\u001B[34m";
		int carros = 0;
		int motos = 0;
		int caminhoes = 0;
		
			for(int i = 0; i<30; i++) {
				for(int j = 0; j < 60; j++) {
					
					
					if(mapa[i][j] == 1) {
						System.out.print("\u001b[42m \033[0m");
					}
					else if(mapa[i][j] == 0) {
						System.out.print(" ");
					}
					
					else if(mapa[i][j] == 2) {
						System.out.print("\u001b[42m \033[0m");
					}
					else if(mapa[i][j] == 3){
						System.out.print("\u001b[44m \033[0m");
					}
					else if(mapa[i][j] == 4){
						System.out.print("\u001b[43;1m \033[0m");
					}
					else if(mapa[i][j] == 5){
						System.out.print("\u001b[41m \033[0m");
					}
					
				}
				
				System.out.println("");
			}	
			
			
			System.out.print(carroVermelho + "█");
			System.out.print(" Carros   ");
			System.out.print(camiAmarelo + "█");
			System.out.print(" Motos   ");
			System.out.print(motoAzul + "█");
			System.out.println(" Caminhoes");
			
			
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
	
	
	public void atualizaMundo() {
		for(int i = 0; i < car.size(); i++) {
			car.get(i).moveCarro(car.get(i));
		}
		
		for (int i = 0; i < cao.size(); i ++) {
			moto.get(i).moveCaminhao(cao.get(i));
		}
		
		for (int i = 0; i < moto.size(); i ++) {
			moto.get(i).moveMoto(moto.get(i));
		}
		
		geraVeiculo();
		detectaColisao();
		zeraMapa();
		desenhaMundo();
	}
	
	
	public void detectaColisao() {
		
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
	
	
	public void geraVeiculo() {
		for(int a = 0; a < car.size(); a++) {
			int x = car.get(a).getX();
			int y = car.get(a).getY();
				for(int i = 0; i < 30; i ++) {
					for(int j = 0; j < 60; j++) {
						if(i == x && j == y) {
							if(mapa[i][j] == 2 && car.get(a).isFabrica() == false) {
								car.get(a).setFabrica(true); 
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
    
    

