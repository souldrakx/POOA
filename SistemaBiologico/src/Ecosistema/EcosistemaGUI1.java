package Ecosistema;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JButton;



import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class EcosistemaGUI1 {

	private JFrame frmSistemaecologico;
	private JTextField tf;
	private JComboBox comboBox;
	private Fondo JContentPane=null;
	private JTextField txtImagen;
	private JTextField txtImagen_1;
	private JTextField txtImagen_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcosistemaGUI1 window = new EcosistemaGUI1();
					window.frmSistemaecologico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EcosistemaGUI1() {
		initialize();
	}
 
	
	public void MenuComboBox()
	{
		// Creacion del JTextField
		tf = new JTextField(20);
		// Creacion del JComboBox y añadir los items.
		comboBox = new JComboBox();
		frmSistemaecologico.getContentPane().add(comboBox);
		comboBox.addItem("Terrestre");
		comboBox.addItem("Acuatico");
		comboBox.addItem("Naturales");
		
		// Accion a realizar cuando el JComboBox cambia de item seleccionado.
				comboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						tf.setText(comboBox.getSelectedItem().toString());
					}
				});
	}
	
	private void initialize() {
		frmSistemaecologico = new JFrame();
		frmSistemaecologico.getContentPane().setBackground(Color.GREEN);
		frmSistemaecologico.setTitle("SistemaEcologico");
		frmSistemaecologico.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\karen\\Pictures\\Especiales\\FondosEscritorio\\Abstract(4).jpg"));
		frmSistemaecologico.setBounds(100, 100, 450, 300);
		frmSistemaecologico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaecologico.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u00BFCual de las imagenes pertenece al ecosistema?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmSistemaecologico.getContentPane().add(lblNewLabel);
			

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setPreferredSize(new Dimension(123, 190));
		panel.setLayout(null);
		frmSistemaecologico.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtImagen = new JTextField();
		txtImagen.setText("imagen");
		panel.add(txtImagen);
		txtImagen.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setPreferredSize(new Dimension(123, 190));
		panel_2.setLayout(null);
		frmSistemaecologico.getContentPane().add(panel_2);
		
		txtImagen_1 = new JTextField();
		txtImagen_1.setText("imagen");
		txtImagen_1.setBounds(10, 11, 86, 20);
		panel_2.add(txtImagen_1);
		txtImagen_1.setColumns(10);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(123, 190));
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(20,20, 20));
		panel_1.setBackground(Color.PINK);
		frmSistemaecologico.getContentPane().add(panel_1);
		
		txtImagen_2 = new JTextField();
		txtImagen_2.setText("imagen");
		txtImagen_2.setBounds(10, 37, 86, 20);
		panel_1.add(txtImagen_2);
		txtImagen_2.setColumns(10);
		
		 MenuComboBox();
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	
		
		tf = new JTextField();
		frmSistemaecologico.getContentPane().add(tf);
		tf.setColumns(10);
		
		
	
	}
	


}
