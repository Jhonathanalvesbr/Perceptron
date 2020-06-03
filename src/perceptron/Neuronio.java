package perceptron;

public class Neuronio {

    double somatorio;
    double[] peso;
    int[][] entrada;
    double limiar;
    int taxaAprendizado;
    boolean varia = false;
    int qntLinha;
    int qntColuna;
    int qntEntrada;

    public Neuronio(int[][] entrada, double limiar, int taxaAprendizado, int qntLinha, int qntColuna, int qntEntrada) {
        peso = new double[qntEntrada];
        this.entrada = entrada;
        this.limiar = limiar;
        this.taxaAprendizado = taxaAprendizado;
        int target[] = new int[qntLinha];
        this.qntLinha = qntLinha;
        this.qntColuna = qntColuna;
        this.qntEntrada = qntEntrada;
    }

    public void somatorio(int i) {
        somatorio = 0;
        for (int j = 0; j < qntEntrada; j++) {
            somatorio = somatorio + (entrada[i][j] * peso[j]);
        }
    }

    public void somatorio(int[] vetEntrada) {
        somatorio = 0;
        for (int j = 0; j < qntEntrada; j++) {
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
        for (int j = 0; j < qntEntrada; j++) {
            peso[j] = peso[j] + taxaAprendizado * (target - f) * entrada[i][j];
        }
    }

}
