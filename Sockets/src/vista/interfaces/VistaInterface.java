package vista.interfaces;

import java.net.Socket;

import vista.paneles.PanelMundo;

public interface VistaInterface {
	public PanelMundo getDibujo();
	public Socket getCliente();
}
