/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

/**
 *
 * @author Administrador
 */
public class Rede {

    int[][] entrada = {{0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
    {0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1},
    {0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1},
    {1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
    {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1},
    {1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
    {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1},
    {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1}};

    int[][] target = {
        {1, 1, 1},
        {1, 1, 0},
        {1, 1, -1},
        {1, 0, 1},
        {1, 0, 0},
        {1, 0, -1},
        {1, -1, -1},
        {1, -1, 0},
        {1, -1, 1},
        {0, 1, 1}};

    int[][] f = new int[15][3];
    Neuronio neuronio[] = new Neuronio[3];
    int limiar, taxaAprendizado, epocas = 0;

    public Rede(int limiar, int taxaAprendizado) {
        this.limiar = limiar;
        this.taxaAprendizado = taxaAprendizado;
        for (int i = 0; i < 3; i++) {
            neuronio[i] = new Neuronio(entrada, 4, 1);
        }
    }

    public void treinar() {

        boolean varia;
        do {
            varia = false;
            for (int i = 0; i < 10; i++) {
                neuronio[0].somatorio(i);
                neuronio[1].somatorio(i);
                neuronio[2].somatorio(i);
                f[i][0] = neuronio[0].limiar();
                f[i][1] = neuronio[1].limiar();
                f[i][2] = neuronio[2].limiar();
                for (int k = 0; k < 3; k++) {
                    if (f[i][k] != target[i][k]) {
                        //neuronio[k].atualizaPesos(i, target[i][k], f[i][k]);
                        varia = true;
                    }
                }
                if (varia) {
                    neuronio[0].atualizaPesos(i, target[i][0], f[i][0]);
                    neuronio[1].atualizaPesos(i, target[i][1], f[i][1]);
                    neuronio[2].atualizaPesos(i, target[i][2], f[i][2]);
                }
                for (int j = 0; j < 3; j++) {
                    System.out.print(f[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            epocas++;
            //System.out.println(neuronio[0].peso[0]);
        } while (varia);
    }

    public int[] teste(int entrada[]) {
        neuronio[0].somatorio(entrada);
        neuronio[1].somatorio(entrada);
        neuronio[2].somatorio(entrada);
        int[] res = new int[3];
        res[0] = neuronio[0].limiar();
        res[1] = neuronio[1].limiar();
        res[2] = neuronio[2].limiar();
        System.out.print(res[0]);
        System.out.print(res[1]);
        System.out.println(res[2]);
        return res;
    }
}

/*                for (int j = 0; j < 3; j++) {
 neuronio[j].somtorio(i);
 neuronio[j].fEnt[i] = neuronio[j].limiar();
 f[i][j] = neuronio[j].fEnt[i];
 }
 for (int j = 0; j < 3; j++) {
 if(target[i][j] != f[i][j]){
 for (int k = 0; k < 3; k++) {
 neuronio[k].atualizaPesos(i);
 }
 varia = true;
 }
 }
 for (int j = 0; j < 3; j++) {
 System.out.print(f[i][j]);
 }
 System.out.println("");
 }*/
//}
