package Ecosistema;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {
	ImageIcon imagen;
    private static final long serialVersionVID=1L;
    
	public Fondo(String nombre) {
     super();
     initialize();
     imagen=new ImageIcon(getClass().getResource(nombre));
     setSize(imagen.getIconWidth(),imagen.getIconHeight());
	}
   private void initialize() {
		// TODO Auto-generated method stub
	   this.setSize(300,200);
	   this.setLayout(new GridBagLayout());
		
	}
protected void painComponent(Graphics g){
	   Dimension d= getSize();
	   g.drawImage(imagen.getImage(), 0, 0, d.width,d.height,null);
	   this.setOpaque(false);
	   super.paintComponent(g);
   }

 
}
