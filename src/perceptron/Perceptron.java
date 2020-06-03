package perceptron;

import javax.swing.*;

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
