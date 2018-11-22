package vista.paneles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import modelo.Cuadrado;

public class PanelMundo extends JPanel{

	private CopyOnWriteArrayList<Cuadrado> lista;
	
	// Atributo para guardar una imagen, por si quieren sustituir el cuadro por una imagen.
	//private BufferedImage imagen;
	
	public PanelMundo() {
		lista=new CopyOnWriteArrayList<Cuadrado>();
		
		// CARGAMOS LA IMAGEN
		/*
		try {
			imagen=ImageIO.read(PanelMundo.class.getResource("/img/persona60.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}	
	
	public void addCuadrado(Cuadrado c) {
		lista.add(c);
	}
	
	public void removeAll() {
		
		lista.clear();

		System.out.println(lista.size());
	}
	
	
	public CopyOnWriteArrayList<Cuadrado> getLista(){
		return lista;
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		intersectar();
		for(int i=0;i<lista.size();i++){
			Cuadrado item=lista.get(i);
			g.setColor(item.getColor());
			g.fillRect(item.getX(),item.getY(),item.getSize(),item.getSize());
			
			// METODOS PARA DIBUJAR UNA IMAGEN
			// FORMA MAS SENCILLA DE DIBUJAR IMAGEN, SE DIBUJA DEL TAMANO COMPLETO DE LA IMAGEN.
			//g.drawImage(imagen, item.getX(), item.getY(), this);
			 /*
			  * DIBUJA UNA IMAGEN DE TAMANO ESPECIFICO, SI EL TAMANO ES MAS PEQUENO O GRANDE 
			  * QUE LA IMAGEN REAL, JAVA LA ESCALA AL TAMANO ESPECIFICADO.
			 * */
			//g.drawImage(imagen,item.getX(), item.getY(),item.getSize(),item.getSize(),this);
			/*
			 * LO MISMO QUE EL ANTERIOR , EN ESTE SE ESPECIFICA TAMANO Y COLOR.
			 * EL COLOR ESPECIFICA EL COLOR DE FONDO DE LA IMAGEN.
			 * */
			//g.drawImage(imagen,item.getX(), item.getY(),item.getSize(),item.getSize(),item.getColor(),this);
			
			
			
		}
	}

	public void intersectar() {
		for(Cuadrado item:lista){
			for(Cuadrado item2:lista) {
				if(!item.equals(item2) && item.getBounds().intersects(item2.getBounds())) {
					int x=(item.getX()+item2.getX())/2;
					int y=(item.getY()+item2.getY())/2;
					int color=(item.getColor().getRGB()+item2.getColor().getRGB())/2;
					int size=(item.getSize()+item2.getSize())/2;
					Cuadrado c=new Cuadrado(x, y, new Color(color), size,10,10,item.getPnlDibujo());
					Thread hilo=new Thread(c);
					hilo.start();
					
					lista.remove(item);
					lista.remove(item2);
					lista.add(c);
					break;
					
				}
			}
		}
	}

}
