package vista;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import modelo.Cuadrado;

public class PanelProceso extends JPanel{

	private ArrayList<Cuadrado> lista;
	
	public PanelProceso() {
		lista=new ArrayList<Cuadrado>();
	}	
	
	public void addCuadrado(Cuadrado c) {
		lista.add(c);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Cuadrado item:lista) {
			g.setColor(item.getColor());
			g.fillRect(item.getX(),item.getY(),item.getSize(),item.getSize());
		}
	}
}
