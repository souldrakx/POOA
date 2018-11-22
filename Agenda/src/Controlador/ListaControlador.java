package Controlador;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Modelo.Persona;
import Vista.AgendaInterfaz;

public class ListaControlador implements ListSelectionListener{
	
	private AgendaInterfaz vista;
	public ListaControlador(AgendaInterfaz vista) {
		this.vista = vista;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
		JList lista =(JList)e.getSource();
		//int indice = lista.getSelectedIndex();
		Persona p = (Persona) lista.getSelectedValue();
		//System.out.println(Indice);
		//System.out.println(x);
		lista.getSelectedIndex();
		
	}

}
