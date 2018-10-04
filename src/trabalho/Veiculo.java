/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.Random;

public class Veiculo {
    
    	Random r = new Random(); 
    
    public Veiculo() {
        x = 0; 
        y = 0; 
        velocidade = 0; 
        fabrica = false; 
        cor = null; 
	}
    
    public Veiculo(int x, int y, int velocidade, String cor, boolean fabrica) {
        
        
		this.x = x;
		this.y = y;
		this.velocidade = velocidade;
		this.cor = cor;
		this.fabrica = fabrica;
                
	}
    public int setX() {
        
        x =  r.nextInt(28);
        
        return x;
    }
    
    public int setY() {
        
	y = r.nextInt(58);
        
	return y;
    }
    
    public int getX() {
        return x;
    }

    

    public int getY() {
        return y;
    }
    

    public void MoveX(int x) {
        this.x = x;
    }
    
    
    public void MoveY(int y) {
        
	this.y = y;
        
    }
    

    

    public boolean isFabrica() {
        return fabrica;
    }

    public void setFabrica(boolean fabrica) {
        this.fabrica = fabrica;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getVelocidade() {
        return velocidade;
    }
    Random car = new Random();
    
    public void moveCarro(Carro ca){
        int mov;
        
        	mov = car.nextInt(4); 
		
		
		if(mov == 0) {
			int x1 = ca.getX(); 
			x1 = x1 + 2; 
			ca.MoveX(verificaX(x1)); 
		}		
		
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
    
    
    Random truck = new Random();
    
     public void moveCaminhao(Caminhao ca){
         
        int mov;
        
        	mov = truck.nextInt(4); 
		
		
		if(mov == 0) {
			int x1 = ca.getX(); 
			x1 = x1 + 1; 
			ca.MoveX(verificaX(x1)); 
		}		
		
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
     Random moty = new Random();
     
      public void moveMoto(Moto m){///Futuro problema aqui, verificar no fim.
          
          int mov;
        
        	mov = moty.nextInt(4); 
		
		
		if(mov == 0) {
			int x1 = m.getX(); 
			x1 = x1 + 3; 
			m.MoveX(verificaX(x1)); 
		}		
		
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
      public int verificaX(int x) {
		if (x >= 29) {
			x = 1;
		}
		if(x <= 0) {
			x = 28;
		}
		return x;
	}
	
	
	public int verificaY(int y) {
		if (y >= 59) {
			y = 1;
		}
		if(y <= 0) {
			y = 58;
		}
		return y;
	}  
    
    
    
    
    
        
        private int x; 
	private int y; 
	private int velocidade; 
	private boolean fabrica; 
	private String cor; 
    
}
