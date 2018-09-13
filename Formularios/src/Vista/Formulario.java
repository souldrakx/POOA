package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorBtn;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class Formulario extends JFrame implements Interfaz{

	private JPanel contentPane;
	private JTextField textNombre;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelbtn = new JPanel();
		contentPane.add(panelbtn, BorderLayout.SOUTH);
		
		JButton btnEnviar = new JButton("Enviar");
		panelbtn.add(btnEnviar);
		
		JButton btnSalir = new JButton("Salir");
		panelbtn.add(btnSalir);
		
		JPanel pnlprincipal = new JPanel();
		contentPane.add(pnlprincipal, BorderLayout.CENTER);
		pnlprincipal.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		pnlprincipal.add(lblNombre);
		
		textNombre = new JTextField();
		pnlprincipal.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero");
		pnlprincipal.add(lblGenero);
		
		JPanel pnlGenero = new JPanel();
		pnlprincipal.add(pnlGenero);
		
		ButtonGroup grupo = new ButtonGroup();
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		pnlGenero.add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		pnlGenero.add(rdbtnFemenino);
		
		grupo.add(rdbtnMasculino);
		grupo.add(rdbtnFemenino);
		
		JLabel lblPassword = new JLabel("Password");
		pnlprincipal.add(lblPassword);
		
		textPassword = new JPasswordField();
		textPassword.setEchoChar('*');
		pnlprincipal.add(textPassword);
		
		JLabel lblAceptarTerminosY = new JLabel("Aceptar Terminos y condiciones");
		pnlprincipal.add(lblAceptarTerminosY);
		
		JCheckBox chckbxAcuerdo = new JCheckBox("Acuerdo");
		pnlprincipal.add(chckbxAcuerdo);
		
		ControladorBtn controlador = new ControladorBtn(this);
		btnSalir.setActionCommand("SALIR");
		btnSalir.addActionListener(controlador);
		
		btnEnviar.setActionCommand("ENVIAR");
		btnEnviar.addActionListener(controlador);
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return textNombre.getText();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return new String(textPassword.getPassword());
	}

}
