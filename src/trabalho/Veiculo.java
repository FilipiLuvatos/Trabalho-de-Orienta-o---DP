/**
 * Veiculo
 * Classe base usada por carro, moto e caminhao.
 *
 * @author Filipi de Luca Valim dos Santos
 */
package trabalho;

import java.util.Random;

public class Veiculo {

    private static final int LIMITE_MIN_X = 1;
    private static final int LIMITE_MAX_X = 28;
    private static final int LIMITE_MIN_Y = 1;
    private static final int LIMITE_MAX_Y = 58;

    private final Random random = new Random();

    private int x;
    private int y;
    private int velocidade;
    private boolean fabrica;
    private String cor;

    public Veiculo() {
        this(0, 0, 0, null, false);
    }

    public Veiculo(int x, int y, int velocidade, String cor, boolean fabrica) {
        this.x = x;
        this.y = y;
        this.velocidade = velocidade;
        this.cor = cor;
        this.fabrica = fabrica;
    }

    public int sortearX() {
        x = random.nextInt(LIMITE_MAX_X);
        return x;
    }

    public int sortearY() {
        y = random.nextInt(LIMITE_MAX_Y);
        return y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moverParaX(int x) {
        this.x = x;
    }

    public void moverParaY(int y) {
        this.y = y;
    }

    public boolean isFabrica() {
        return fabrica;
    }

    public void setFabrica(boolean fabrica) {
        this.fabrica = fabrica;
    }

    public String getCor() {
        return cor;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void moveCarro(Carro carro) {
        moverAleatoriamente(carro);
    }

    public void moveCaminhao(Caminhao caminhao) {
        moverAleatoriamente(caminhao);
    }

    public void moveMoto(Moto moto) {
        moverAleatoriamente(moto);
    }

    private void moverAleatoriamente(Veiculo veiculo) {
        int movimento = random.nextInt(4);
        int passo = veiculo.getVelocidade();

        if (movimento == 0) {
            veiculo.moverParaX(verificaX(veiculo.getX() + passo));
        } else if (movimento == 1) {
            veiculo.moverParaX(verificaX(veiculo.getX() - passo));
        } else if (movimento == 2) {
            veiculo.moverParaY(verificaY(veiculo.getY() + passo));
        } else {
            veiculo.moverParaY(verificaY(veiculo.getY() - passo));
        }
    }

    public int verificaX(int x) {
        if (x > LIMITE_MAX_X) {
            return LIMITE_MIN_X;
        }
        if (x < LIMITE_MIN_X) {
            return LIMITE_MAX_X;
        }
        return x;
    }

    public int verificaY(int y) {
        if (y > LIMITE_MAX_Y) {
            return LIMITE_MIN_Y;
        }
        if (y < LIMITE_MIN_Y) {
            return LIMITE_MAX_Y;
        }
        return y;
    }
}
