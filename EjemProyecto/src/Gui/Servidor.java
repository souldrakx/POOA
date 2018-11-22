package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Servidor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
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
	public Servidor() {
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1300, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Habitat = new JPanel();
		Habitat.setBackground(Color.RED);
		Habitat.setBounds(215, 62, 740, 378);
		contentPane.add(Habitat);
		
		JLabel lblHabitadjuego = new JLabel("Habitat(Juego)");
		lblHabitadjuego.setForeground(Color.BLACK);
		lblHabitadjuego.setBackground(Color.WHITE);
		Habitat.add(lblHabitadjuego);
		
		JLabel lblNewLabel = new JLabel("Chat");
		lblNewLabel.setBounds(1109, 92, 46, 14);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.ORANGE);
		textPane.setBounds(997, 92, 277, 283);
		contentPane.add(textPane);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(1091, 417, 89, 23);
		contentPane.add(btnEnviar);
		
		textField = new JTextField();
		textField.setBounds(997, 386, 277, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCrearGru = new JButton("Crear Grupo");
		btnCrearGru.setBounds(28, 83, 120, 23);
		contentPane.add(btnCrearGru);
		
		JComboBox Grupos = new JComboBox();
		Grupos.setBounds(28, 117, 120, 20);
		contentPane.add(Grupos);
	}

}
