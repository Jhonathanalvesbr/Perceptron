package perceptron;

import javax.swing.*;

public class Temp {

    public static void main(String[] args) {

        double taxa, limiar, yent, f, x1, x2, x3, b;
        double x[][] = {{0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
    {0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1},
    {0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1},
    {1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
    {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1},
    {1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
    {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1},
    {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1}};  // entradas binárias
        double t[] = {1, 0, -1,1, 0, -1,1, 0, -1,1};   // saídas bipolares
        double ff[] = new double[10];
        double w[] = {0, 0, 0,0, 0, 0,0, 0, 0,0, 0, 0,0, 0, 0,0};   // os pesos devem ser zerados inicialmente conforme o algoritmo determina
        int epocas = 0;
        boolean variou;

        limiar = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do limiar:"));
        taxa = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da taxa de aprendizado:"));

// ESTA É A FASE DE TREINAMENTO    
        do {
            variou = false;
            for (int i = 0; i < 10; i++) {
                yent = 0;
                for (int j = 0; j < 16; j++) {
                    yent = yent + (x[i][j]*w[j]);
                }
                if (yent > limiar) {
                    f = 1;
                } else if (yent < -limiar) {
                    f = -1;
                } else {
                    f = 0;
                }
                ff[i] = f;
                if (f != t[i]) {
                    for (int j = 0; j < 16; j++) {
                        w[j] = w[j] + taxa * (t[i] - f) * x[i][j];
                    }
                    variou = true;
                }
            }
            epocas++;
        } while (variou == true);

// ESTA É A FASE DE VALIDAÇÃO
        //JOptionPane.showMessageDialog(null, "Os pesos encontrados foram:\n\nW1 = " + w[0] + "\nW2 = " + w[1] + "\nW3 = " + w[2] + "\nb =  " + w[3] + "\n\nForam necessárias " + epocas + " épocas", "RESULTADO", 1);
        for (int i = 0; i < 10; i++) {
                System.out.print(t[i]+" ");
            }
        System.out.println("");
                for (int i = 0; i < 10; i++) {
                System.out.print(ff[i]+" ");
            }
        System.out.println("");
                for (int i = 0; i < 10; i++) {
                System.out.print(w[i]+" ");
            }
        System.out.println("");
        /*while (true) {
            x1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de X1:"));
            x2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de X2:"));
            x3 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de X3:"));
            yent = x1 * w[0] + x2 * w[1] + x3 * w[2] + 1 * w[3];
            if (yent > limiar) {
                f = 1;
            } else if (yent < -limiar) {
                f = -1;
            } else {
                f = 0;
            }
            JOptionPane.showMessageDialog(null, "A função AND para      X1= " + (int) x1 + "      X2 = " + (int) x2 + "       X3 = " + (int) x3 + "\n\né igual a:    " + (int) f, "RESULTADO", 1);
        }
*/
    }
}
