package vista.paneles;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PanelPresentacion extends JPanel{
	public PanelPresentacion() {
		setBackground(new Color(0, 128, 0));
		setLayout(new BorderLayout(0, 0));
		
		String mensaje="<html> "
				+ "<center> "
				+ "<H4>Universidad Autonoma<br><hr> de Baja California </H4> "
				+ "<br><font color=\"silver\"><b>Autor:</b></font> <i>Josue-Miguel Flores-Parra</i>"
				+"<br><font color=\"silver\"><b>Correo:</b></font>  <i>josue.miguel.flores.parra@uabc.edu.mx</i>"
				+ "</center>"
				+ "</html>";
		
		
		JLabel lblNewLabel = new JLabel(mensaje);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(PanelPresentacion.class.getResource("/img/uabc.png")));
		add(lblNewLabel, BorderLayout.CENTER);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		
	}

}
