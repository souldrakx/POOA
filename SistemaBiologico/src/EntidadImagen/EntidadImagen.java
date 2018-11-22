package EntidadImagen;


import java.io.File;

import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class EntidadImagen extends JPanel{
	
	protected Image imagen;
	private boolean repetirImagen = false;
	
	public boolean getRepetirImagen() {
		return repetirImagen;
	}
	public void setRepetirImagen(boolean repetirImagen) {
		this.repetirImagen = repetirImagen;
	}

	public EntidadImagen(){}
	
	public EntidadImagen(String imagePath){
		cargarImagen(imagePath);
	}
	
	//Este método carga la igamen y la pone de fondo
	public void cargarImagen(String imagePath){
		try{
			imagen = ImageIO.read(new File(imagePath));
			System.out.println("Imagen Cargada!");
		}
		catch(Exception ex) {
			System.out.println("Error al cargar imagen: \n" + ex);
			ex.printStackTrace();
		}
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(imagen!=null)
		{
			g.drawImage(imagen,  0,  0,  this);
		}
	}
}