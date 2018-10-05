/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;


public class Trabalho {

    
    public static void main(String[] args) throws InterruptedException{
      
        	Mundo m = new Mundo();
		
		m.geraVeiculos(); 
		m.desenhaMundo(); 
		
		int i = 0;
		
		while (i == 0) {
			m.atualizaMundo(); 
			Thread.sleep(300);  
		}
        
    }
    
}
