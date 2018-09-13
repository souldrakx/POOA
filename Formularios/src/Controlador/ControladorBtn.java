package Controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vista.Interfaz;
import modelo.Persona;

public class ControladorBtn implements ActionListener{
	
	private Interfaz vista;
	private Persona modelo;
	
	public ControladorBtn(Interfaz vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String comando= arg0.getActionCommand();
		switch(comando) {
		
		case "SALIR":
			int opcion = JOptionPane.showConfirmDialog((Component) vista, "Desea Salir?", "SALIR", JOptionPane.YES_NO_OPTION);
			
			if(opcion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			break;
			
		case "ENVIAR":
			
			modelo = new Persona(vista.getNombre(), vista.getPassword());
			
			JOptionPane.showMessageDialog((Component)vista, modelo.toString(), "Datos", JOptionPane.ERROR_MESSAGE);
			break;
		}
		
		
	}
	

}
