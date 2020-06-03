package perceptron;

import javax.swing.*;

/* É importante destacar que devido ao fato da atualização dos pesos usar a equação
 w = w + taxa * (t - f) * x  , os valores usados para as saídas desejadas foram bipolares (1 e -1)
 e não binários (1 e 0). Isto se deve ao fato de que atribuir 0 para a saída faz com que (t - f) 
 sempre seja (0 - f) e isto dificulta o algoritmo de parar o ciclo de aprendizado.
 */
public class Perceptron {

    public static void main(String[] args) {
        Rede r = new Rede(1, 2);
        r.treinar();
        JOptionPane.showMessageDialog(null, "Os pesos foram encontrados!\nForam necessarios "+r.epocas+" epocas!");
        
        JFrame frame = new JFrame("Ia");
        frame.setSize(400, 425);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        Tela tela = new Tela();
        frame.add(tela);
        frame.addMouseListener(tela);
        
        tela.repaint();
        tela.rede = r;
    }
}
