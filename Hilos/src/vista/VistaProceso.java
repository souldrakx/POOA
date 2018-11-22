package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBoton;

import javax.swing.JButton;

public class VistaProceso extends JFrame implements VistaInterface{

	private JPanel contentPane;
	private PanelProceso pnlDibujo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaProceso frame = new VistaProceso();
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
	public VistaProceso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlSur = new JPanel();
		contentPane.add(pnlSur, BorderLayout.SOUTH);
		
		JButton btnAgregar = new JButton("Agregar");
		pnlSur.add(btnAgregar);
		
		pnlDibujo = new PanelProceso();
		contentPane.add(pnlDibujo, BorderLayout.CENTER);
		
		btnAgregar.addActionListener(new ControladorBoton(this));
	}

	@Override
	public PanelProceso getDibujo() {
		// TODO Auto-generated method stub
		return pnlDibujo;
	}

}
