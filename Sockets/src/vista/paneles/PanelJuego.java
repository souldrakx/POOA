package vista.paneles;

import javax.swing.JPanel;

import Controlador.ControladorBoton;
import vista.interfaces.VistaInterface;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class PanelJuego extends JPanel {
	
	private PanelMundo pnlDibujo;
	
	public PanelJuego(VistaInterface vista) {
		
		setLayout(new BorderLayout(0, 0));
		pnlDibujo=new PanelMundo();
		add(pnlDibujo,BorderLayout.CENTER);
		
		JPanel pnlBotones = new JPanel();
		add(pnlBotones, BorderLayout.SOUTH);
		
		JButton btnAgregar = new JButton("Agregar");
		pnlBotones.add(btnAgregar);
		
		btnAgregar.addActionListener(new ControladorBoton(vista));
	}

	public PanelMundo getDibujo() {
		return pnlDibujo;
	}

}
