/**
 * @author Filipi de Luca Valim dos Santos RA:22216027-7
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
