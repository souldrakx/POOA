package Controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import modelo.Cuadrado;
import modelo.Mensaje;
import vista.interfaces.VistaInterface;

public class ControladorRaton implements MouseListener {
	
	private VistaInterface vista;
	public ControladorRaton(VistaInterface vista) {
		this.vista = vista;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Cuadrado c = new Cuadrado(e.getX(),e.getY(),Color.YELLOW.darker(),10,3,3);
		Mensaje msj = new Mensaje("CUADRADO",c);
		
		try {
			ObjectOutputStream pos =new ObjectOutputStream(vista.getCliente().getOutputStream());
			pos.writeObject(msj);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse entro en el conmponente"+e.getButton());
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse salio del componente"+e.getButton());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse presiono boton"+e.getButton());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse solto boton"+e.getButton());
		
	}

}
