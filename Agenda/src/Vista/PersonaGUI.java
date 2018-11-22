package Vista;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Modelo.Genero;
import Modelo.Persona;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

public class PersonaGUI extends JPanel {
	private JTextField txtNombre;
	
	public PersonaGUI() throws ParseException {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 10), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		add(lblNombre);
		
		txtNombre = new JTextField();
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		add(lblEdad);
		
		NumberFormat formatoNumero = NumberFormat.getIntegerInstance();
		formatoNumero.setMinimumFractionDigits(1);
		formatoNumero.setMaximumIntegerDigits(3);
		
		JFormattedTextField txtEdad = new JFormattedTextField(formatoNumero);
		add(txtEdad);
		

		
		JLabel lblGenero = new JLabel("Genero:");
		add(lblGenero);
		
		JPanel pnlGenero = new JPanel();
		add(pnlGenero);
		pnlGenero.setLayout(new GridLayout(0, 2, 0, 0));
		
		ButtonGroup grupoGenero = new ButtonGroup();
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		pnlGenero.add(rdbtnFemenino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		pnlGenero.add(rdbtnMasculino);
		
		grupoGenero.add(rdbtnFemenino);
		grupoGenero.add(rdbtnMasculino);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		add(lblTelefono);
		
		MaskFormatter formatoTelefono = new MaskFormatter("(###)###-###");
		
		JFormattedTextField txtTelefono = new JFormattedTextField(formatoTelefono);
		add(txtTelefono);
		}
	
	public void setPersona(Persona p) {
		txtNombre.setText(p.getNombre());
		//txtTelefono.setText(p.getTelefono());
	}
	
	public Persona getDatos() {
		String nombre = txtNombre.getText();
		String telefono = txtTelefono.getText();
		int edad = Integer.parseInt(txt.Edad.getText());
		String correo=txtCorreo.getText();
		Genero g = (rdbtnMasculino.isSelect())?Genero.MASCULINO:Genero.FEMENINO;
		return new Persona(nombre, edad, telefono, correo, 0);
	}
	
	public void Limpiar() {
		txtNombre.setText(" ");
		txtTelefono.setText(" ");
		txtEdad.setText(" ");
		txtCorreo.setText(" ");
		rdbtnFemenino.setSelected(false);
		rdbtnFemenino.setSelected(false);
	}

}
