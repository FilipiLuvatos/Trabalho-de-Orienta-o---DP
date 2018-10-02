/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;


public class Veiculo {
    
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
    
    

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
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
    
    
    
    
    
    
    
    
        private int x; 
	private int y; 
	private int velocidade; 
	private boolean fabrica; 
	private String cor; 
    
}
