package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class PanelPrincipal extends JPanel{
	public PanelPrincipal() {
		setBackground(Color.GREEN);
		setLayout(new BorderLayout(0, 0));
		
		String mensaje = "<html><center>Universidad Autonoma <br> de Baja California</center></htlm>";
		
		JLabel Presentacion = new JLabel(mensaje);
		Presentacion.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/img/uabc.png")));
		
		Presentacion.setHorizontalAlignment(SwingConstants.CENTER);
		Presentacion.setVerticalAlignment(SwingConstants.CENTER);
		
		
		Presentacion.setHorizontalTextPosition(SwingConstants.CENTER);
		Presentacion.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(Presentacion,BorderLayout.CENTER);
	}

}
