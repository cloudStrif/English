import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panneau extends JPanel {
        private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}
	String TEXTE ="" ;
	boolean ecrire = false; 
        public void paintComponent(Graphics g){
                g.setColor(Color.BLACK);
                g.fillRect(0,0,this.getWidth(),this.getHeight());
                
                if (ecrire) {
				g.setColor(Color.GREEN);
				g.setFont(new Font("TimesRoman", Font.BOLD, 10));
				Graphics2D g2 = (Graphics2D) g;
				drawString(g2, TEXTE, 10, 10);
			}
        }
}
