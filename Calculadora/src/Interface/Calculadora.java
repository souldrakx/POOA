package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField Operador1;
	private JTextField Operador2;
	private JTextField Resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOperador = new JLabel("Operador 1");
		lblOperador.setBounds(10, 11, 197, 64);
		contentPane.add(lblOperador);
		
		Operador1 = new JTextField();
		Operador1.setHorizontalAlignment(SwingConstants.RIGHT);
		Operador1.setBounds(234, 11, 224, 64);
		Operador1.setForeground(Color.BLUE);
		contentPane.add(Operador1);
		Operador1.setColumns(10);
		
		JLabel lblOperador_1 = new JLabel("Operador 2");
		lblOperador_1.setBounds(10, 80, 211, 64);
		contentPane.add(lblOperador_1);
		
		Operador2 = new JTextField();
		Operador2.setHorizontalAlignment(SwingConstants.RIGHT);
		Operador2.setBounds(234, 84, 224, 64);
		Operador2.setForeground(Color.BLUE);
		contentPane.add(Operador2);
		Operador2.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(10, 159, 211, 64);
		contentPane.add(lblResultado);
		
		Resultado = new JTextField();
		Resultado.setHorizontalAlignment(SwingConstants.RIGHT);
		Resultado.setBounds(234, 159, 224, 64);
		Resultado.setEditable(false);
		Resultado.setForeground(Color.RED);
		contentPane.add(Resultado);
		Resultado.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 234, 458, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSuma = new JButton("Suma");
		/*btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double op1 = Double.parseDouble(Operador1.getText());
				double op2 = Double.parseDouble(Operador2.getText());
				double suma = op1 + op2 ;
				Resultado.setText(String.valueOf(suma));
			}
		});*/
		btnSuma.setBounds(52, 13, 70, 23);
		panel.add(btnSuma);
		
		JButton btnResta = new JButton("Resta");
		btnResta.setBounds(132, 13, 74, 23);
		panel.add(btnResta);
		
		JButton btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.setBounds(216, 13, 112, 23);
		panel.add(btnMultiplicar);
		
		JButton btnDividir = new JButton("Dividir");
		btnDividir.setBounds(338, 13, 70, 23);
		panel.add(btnDividir);
		
		JLabel label = new JLabel("");
		label.setBounds(262, 212, 224, 69);
		contentPane.add(label);

	
	
		ControladorBtn control = new ControladorBtn(this);
		btnSuma.setActionCommand("Suma");
		btnSuma.addActionListener(control);
		btnResta.setActionCommand("Resta");
		btnResta.addActionListener(control);
		btnMultiplicar.setActionCommand("Multiplicar");
		btnMultiplicar.addActionListener(control);
		btnDividir.setActionCommand("Dividir");
		btnDividir.addActionListener(control);
	
	
	
	
	}
	

	

	public JTextField getOperador1() {
		return Operador1;
	}

	public JTextField getOperador2() {
		return Operador2;
	}

	public JTextField getResultado() {
		return Resultado;
	}


}
