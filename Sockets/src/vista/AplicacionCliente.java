package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorRaton;
import modelo.Cuadrado;
import modelo.Mensaje;
import vista.interfaces.VistaInterface;
import vista.paneles.PanelJuego;
import vista.paneles.PanelMundo;
import vista.paneles.PanelPresentacion;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class AplicacionCliente extends JFrame implements VistaInterface,Runnable{

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private PanelJuego pnlJuego;
	private Socket cliente;
	private int puerto=9001;
	private String host="127.0.0.1";
	private Thread t;
	private boolean isRunning;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private static AplicacionCliente frame ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AplicacionCliente();
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
	public AplicacionCliente() {
		setTitle("CLIENTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon(AplicacionCliente.class.getResource("/img/open.png")));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon(AplicacionCliente.class.getResource("/img/save.png")));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(AplicacionCliente.class.getResource("/img/cancel.png")));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(AplicacionCliente.class.getResource("/img/about.png")));
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnNew = new JButton("");
		btnNew.setToolTipText("Nuevo.");
		btnNew.setIcon(new ImageIcon(AplicacionCliente.class.getResource("/img/new.png")));
		
		btnNew.setBorderPainted(false);
		toolBar.add(btnNew);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout) panelPrincipal.getLayout();
				c.show(panelPrincipal, "JUEGO");
				try {
					cliente=new Socket(host, puerto);
					isRunning=true;
					t=new Thread(frame);
					t.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//c.next(panelPrincipal);
			}
		});
		toolBar.add(btnConectar);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					output=new ObjectOutputStream(cliente.getOutputStream());
					output.writeObject(new Mensaje<String>("SALIDA","SALIDA"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		toolBar.add(btnStop);
		
		panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new CardLayout(0, 0));
		
		PanelPresentacion pnlPresentacion=new PanelPresentacion();
		panelPrincipal.add(pnlPresentacion,"PRESENTACION");
		
		pnlJuego=new PanelJuego(this);
		panelPrincipal.add(pnlJuego,"JUEGO");
		
		pnlJuego.getDibujo().addMouseListener(new ControladorRaton(this));
		pnlJuego.getDibujo().setFocusable(true);
	}

	@Override
	public PanelMundo getDibujo() {
		// TODO Auto-generated method stub
		return pnlJuego.getDibujo();
	}

	@Override
	public Socket getCliente() {
		// TODO Auto-generated method stub
		return cliente;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			try {
				input=new ObjectInputStream(cliente.getInputStream());
				Mensaje c= (Mensaje)input.readObject();
				if(c.getTipo().equals("SALTE")) {
					isRunning=false;
					input.close();
					output.close();
					cliente.close();
					getDibujo().removeAll();
					
					CardLayout layout=(CardLayout) panelPrincipal.getLayout();
					layout.show(panelPrincipal, "PRESENTACION");
					
					
				}
				else if(c.getTipo().equals("CUADRADO")) {
					Cuadrado res=(Cuadrado) c.getValor();
					res.setPnlDibujo(getDibujo());
					getDibujo().addCuadrado(res);
					Thread t=new Thread(res);
					t.start();
				}

			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


}
