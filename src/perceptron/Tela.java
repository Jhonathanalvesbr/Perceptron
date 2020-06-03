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

    public Tela() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                entrada[i][j] = 0;
            }
        }
        ;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 400, 400);
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
                    g2.setColor(Color.BLACK);
                    g2.fill(new Rectangle2D.Double(j * yy, i * xx, yy, xx));
                } else {
                    g2.setColor(Color.WHITE);
                    g2.fill(new Rectangle2D.Double(1 - (j * yy), 1 - (i * xx), 1 - yy, 1 - xx));

                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int linha;
        int coluna;
        if (e.getButton() != 2) {
            if (e.getY() < 102) {
                linha = 0;
            } else if (e.getY() >= 102 && e.getY() <= 183) {
                linha = 1;
            } else if (e.getY() > 183 && e.getY() < 262) {
                linha = 2;
            } else if (e.getY() >= 262 && e.getY() <= 342) {
                linha = 3;
            } else {
                linha = 4;
            }

            if (e.getX() < 136) {
                coluna = 0;
            } else if (e.getX() > 269) {
                coluna = 2;
            } else {
                coluna = 1;
            }

            if (e.getButton() == 3) {
                entrada[linha][coluna] = 0;
            } else {
                entrada[linha][coluna] = 1;
            }
        }
        int ent[] = new int[16];
        ent[15] = 1;
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (entrada[i][j] != 0) {
                    ent[k++] = entrada[i][j];
                } else {
                    ent[k++] = 0;
                }
            }
        }
        if (e.getButton() == 2) {
            int res[] = rede.teste(ent);

            for (int i = 0; i < rede.qntLinha; i++) {
                boolean v = false;
                for (int j = 0; j < rede.qntColuna; j++) {
                    if (res[j] == rede.target[i][j]) {
                        v = true;
                    } else {
                        v = false;
                        break;
                    }
                }
                if (v == true) {
                    System.out.println("Numero: "+i);
                    break;
                }
            }
        }
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
