package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class clienteGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clienteGui frame = new clienteGui();
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
	public clienteGui() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1300, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Habitat = new JPanel();
		Habitat.setBackground(Color.RED);
		Habitat.setBounds(217, 34, 740, 378);
		contentPane.add(Habitat);
		
		JLabel lblHabitadjuego = new JLabel("Habitat(Juego)");
		lblHabitadjuego.setForeground(Color.BLACK);
		lblHabitadjuego.setBackground(Color.WHITE);
		Habitat.add(lblHabitadjuego);
		
		JLabel lblNewLabel = new JLabel("Chat");
		lblNewLabel.setBounds(1111, 53, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMensajeserrores = new JLabel("Mensajes (Errores)");
		lblMensajeserrores.setBounds(595, 428, 96, 14);
		contentPane.add(lblMensajeserrores);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.ORANGE);
		textPane.setBounds(997, 53, 277, 283);
		contentPane.add(textPane);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(1090, 377, 89, 23);
		contentPane.add(btnEnviar);
		
		textField = new JTextField();
		textField.setBounds(997, 347, 277, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox Animales = new JComboBox();
		Animales.setBounds(27, 53, 148, 20);
		contentPane.add(Animales);
		
		JButton btnAgregarAni = new JButton("Agregar");
		btnAgregarAni.setBounds(59, 83, 89, 23);
		contentPane.add(btnAgregarAni);
		
		JComboBox Plantas = new JComboBox();
		Plantas.setBounds(27, 148, 148, 20);
		contentPane.add(Plantas);
		
		JButton btnAgregarPlan = new JButton("Agregar");
		btnAgregarPlan.setBounds(59, 190, 89, 23);
		contentPane.add(btnAgregarPlan);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(217, 423, 740, 61);
		contentPane.add(textPane_1);
	}
}
