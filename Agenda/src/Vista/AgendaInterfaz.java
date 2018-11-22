package Vista;

import javax.swing.DefaultListModel;

import Modelo.Persona;

public interface AgendaInterfaz {
	
	public void setPersona(Persona p);
	public Persona getPersona(Persona p);
	
	public DefaultListModel<Persona> getModel();
	
	public void Limpiar();
	
	

}
