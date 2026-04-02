/**
 * @author Filipi de Luca Valim dos Santos RA:22216027-7
 */

package trabalho;

import java.io.IOException;

public class Trabalho {

    
    public static void main(String[] args) throws InterruptedException, IOException{
        if (args.length > 0 && "console".equalsIgnoreCase(args[0])) {
            executarModoConsole();
            return;
        }

        new SimulacaoHttpServer(8080).iniciar();
    }

    private static void executarModoConsole() throws InterruptedException {
        Mundo m = new Mundo();

        m.geraVeiculos();
        m.desenhaMundo();

        while (true) {
            m.atualizaMundo();
            Thread.sleep(300);
        }
        
    }
    
}
