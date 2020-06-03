package perceptron;

public class Rede {

    int qntLinha = 10;
    int qntColuna = 3;
    int qntEntrada = 16;
    int qntNeuronio = 3;

    int[][] entrada = {
    {0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
    {0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1},
    {0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1},
    {1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
    {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1},
    {1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
    {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1},
    {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};

    int[][] target = {
    {1,1,1},
    {1,1,0},
    {1,0,-1},
    {0,0,1},
    {0,-1,0},
    {0,-1,-1},
    {-1,0,-1},
    {-1,1,0},
    {-1,1,-1},
    {1,0,1}};



    int[][] f = new int[qntLinha][qntColuna];
    Neuronio neuronio[] = new Neuronio[qntNeuronio];
    int limiar, taxaAprendizado, epocas = 0;

    public Rede(int limiar, int taxaAprendizado) {
        this.limiar = limiar;
        this.taxaAprendizado = taxaAprendizado;
        for (int i = 0; i < qntNeuronio; i++) {
            neuronio[i] = new Neuronio(entrada, 2, 1, qntLinha, qntColuna, qntEntrada);
        }
    }

    public void treinar() {

        boolean varia;
        do {
            varia = false;
            System.out.println("Epoca: " + epocas);
            for (int i = 0; i < qntLinha; i++) {
                for (int j = 0; j < qntNeuronio; j++) {
                    neuronio[j].somatorio(i);
                }
                for (int j = 0; j < qntNeuronio; j++) {
                    f[i][j] = neuronio[j].limiar();
                }
                for (int k = 0; k < qntColuna; k++) {
                    if (f[i][k] != target[i][k]) {
                        varia = true;
                    }
                }
                if (varia) {
                    for (int j = 0; j < qntNeuronio; j++) {
                        neuronio[j].atualizaPesos(i, target[i][j], f[i][j]);
                    }
                }
                
                for (int j = 0; j < qntColuna; j++) {
                    System.out.print(f[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            epocas++;
        } while (varia);
    }

    public int[] teste(int entrada[]) {
        for (int i = 0; i < qntNeuronio; i++) {
            neuronio[i].somatorio(entrada);
        }
        int[] res = new int[qntNeuronio];
        System.out.print("Saida: ");
        for (int i = 0; i < qntNeuronio; i++) {
            res[i] = neuronio[i].limiar();
            System.out.print(res[i]);
        }
        System.out.println("");
        return res;
    }
}
