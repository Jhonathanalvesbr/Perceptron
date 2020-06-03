package perceptron;

public class Neuronio {

    double somatorio;
    double[] peso;
    int[][] entrada;
    double limiar;
    int taxaAprendizado;
    int target[] = new int[10];
    boolean varia = false;

    public Neuronio(int[][] entrada, double limiar, int taxaAprendizado) {
        peso = new double[16];
        this.entrada = entrada;
        this.limiar = limiar;
        this.taxaAprendizado = taxaAprendizado;
    }

    public void somatorio(int i) {
        somatorio = 0;
        for (int j = 0; j < 16; j++) {
            somatorio = somatorio + (entrada[i][j] * peso[j]);
        }
    }
    
    public void somatorio(int[] vetEntrada) {
        somatorio = 0;
        for (int j = 0; j < 16; j++) {
            somatorio = somatorio + (vetEntrada[j] * peso[j]);
        }
    }
    
    public int limiar() {
        if (somatorio > limiar) {
            return 1;
        } else if (somatorio < -limiar) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public void atualizaPesos(int i, int target, int f) {
        for (int j = 0; j < 16; j++) {
            peso[j] = peso[j] + taxaAprendizado * (target - f) * entrada[i][j];
        }
    }

}