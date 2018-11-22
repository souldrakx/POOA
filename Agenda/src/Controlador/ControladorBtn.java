package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.AgendaInterfaz;

public class ControladorBtn implements ActionListener{

	private AgendaInterfaz vista;
	
	public ControladorBtn(AgendaIntrefaz vista) {
		this.vista=vista
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String comando  = e.getActionCommand().toUpperCase();
		switch(comando) {
		case "Nuevo":
			vista.Limpiar();
			break;
		case "Agregar":
			vista.getModel().addElemnet(vista.getPersona());
			vista.Limpiar();
			break;
		case "Editar":
			vista.getModelo.set(vista.getIndice(),vista.getPersona());
			vista.Limpiar();
			break;
		
		case "Eliminar":
			vista.getModel().removeElementAt(vista.getIndice());
			vista.Limpiar();
			break;
		}
	}
	
	

}
