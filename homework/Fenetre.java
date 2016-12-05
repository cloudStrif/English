import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Toolkit;


public class Fenetre extends JFrame {
        JTextField jtf ;  JPanel container = new JPanel();
        Panneau pan = new Panneau() ; 
        Memoire m = new Memoire();
        String moment = "" ;
        public Fenetre() {
		this.setTitle("electronic book--Shell created by Patrick Chen");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setResizable(false);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		
		jtf = new JTextField();

		JPanel south = new JPanel();
		south.add(jtf);

		jtf.setPreferredSize(new Dimension(0, 0));
		jtf.addKeyListener(new ClavierListener());
		container.add(south, BorderLayout.SOUTH);
               
               
		this.setContentPane(container);
		this.setVisible(true);
		 moment = m.af("t");
                pan.TEXTE = moment;
		 ecrire(pan.TEXTE) ; 

        }
        public void pause(int a) {
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
        public void ecrire(String f) {
		pan.ecrire = true;
		// Texte a droite

		pan.TEXTE = "";
		String cont = "";
		
		for (int i = 0; i < f.length(); i++) {
			cont += f.charAt(i);
			pan.TEXTE = cont;
			pan.repaint();
			Toolkit.getDefaultToolkit().sync();

			pause(10);
		}
		pan.ecrire = false;
		//pan.repaint();
		
	}
	class PD implements Runnable{
	       String t ; 
	        public PD(String t){
	        this.t=t;
	        }
	        
	        public void run(){
	                ecrire(t);
	        }
	}
	
        class ClavierListener implements KeyListener {
		int posx = 0;
		int posy = 0;
                String [] tab = {"t","t2"};
                int inc = 1 ;
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

			if(arg0.getKeyCode() == 10){
			      String tmp =   new Memoire().af("t2");
			     Thread t = new Thread(new PD(tmp));
			     t.start();
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
        public static void main(String [] args){
                new Fenetre() ;
        }
}
