package perceptron;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
public class Tela extends JPanel implements MouseListener {

    int[][] entrada = new int[5][3];
    Rede rede;
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        int x = 80;
        int xx = 80;
        int y = 133;
        int yy = 133;

        g2.setColor(Color.black);

        for (int i = 0; i < 4; i++) {
            g2.drawLine(0, x, 400, x);
            x = x + xx;
        }
        for (int i = 0; i < 2; i++) {
            g2.drawLine(y, 0, y, x);
            y = y + yy;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (entrada[i][j] != 0) {
                    g2.fill(new Rectangle2D.Double(j * yy, i * xx, yy, xx));
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int linha = e.getY() / 80;
        int coluna = e.getX() / 133;
        //System.out.println(linha + " : " + coluna);
        entrada[linha][coluna] = 1;
        int ent[] = new int[16];
        ent[15] = 1;
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if(entrada[i][j] != 0){
                    ent[k++] = entrada[i][j];
                }
                else{
                    ent[k++] = 0;
                }
            }
        }
        if(e.getButton() == 3){
        int res[] = rede.teste(ent);
        
        for (int i = 0; i < 10; i++) {
            boolean v = false;
            for (int j = 0; j < 3; j++) {
                if(res[j] == rede.target[i][j]){
                    v = true;
                }
                else{
                    v = false;
                    break;
                }
            }
            if(v == true){
                System.out.println(i);
                break;
            }
        }
        }
        /*int comparar[] = {1,1,1,1,0,1,1,1,1,0,0,1,1,1,1};
        int t = 0;
        boolean confere = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (comparar[t] == entrada[i][j]) {
                    confere = true;
                }
                else{
                    confere = false;
                    break;
                }
                t++;
            }
        }
        if(confere && t == 15){
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(entrada[i][j]+ " ");
                }
            }
        }*/
        repaint();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
