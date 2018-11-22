package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.ClienteConexion;
import modelo.Mundo;
import vista.interfaces.VistaInterface;
import vista.paneles.PanelJuego;
import vista.paneles.PanelMundo;
import vista.paneles.PanelPresentacion;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class AplicacionServidor extends JFrame implements Runnable,VistaInterface{

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private PanelJuego pnlJuego;
	
	private ServerSocket server;
	private boolean isRunning;
	private Thread t;
	private Socket cliente;
	private int puerto;
	private static AplicacionServidor frame ;
	private Mundo m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AplicacionServidor();
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
	public AplicacionServidor() {
		m=new Mundo();
		
		setTitle("SERVIDOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		t=new Thread(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon(AplicacionServidor.class.getResource("/img/open.png")));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon(AplicacionServidor.class.getResource("/img/save.png")));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opc=JOptionPane.showConfirmDialog(frame,"Seguro que desea salir...","SALIR",JOptionPane.YES_NO_OPTION);
				if(opc==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		mntmExit.setIcon(new ImageIcon(AplicacionServidor.class.getResource("/img/cancel.png")));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(AplicacionServidor.class.getResource("/img/about.png")));
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
		btnNew.setIcon(new ImageIcon(AplicacionServidor.class.getResource("/img/new.png")));
		
		btnNew.setBorderPainted(false);
		toolBar.add(btnNew);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout) panelPrincipal.getLayout();
				c.show(panelPrincipal, "JUEGO");
				try {
					puerto=9001;
					server=new ServerSocket(puerto);
					isRunning=true;
					t.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//c.next(panelPrincipal);
			}
		});
		toolBar.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		toolBar.add(btnStop);
		
		panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new CardLayout(0, 0));
		
		PanelPresentacion pnlPresentacion=new PanelPresentacion();
		panelPrincipal.add(pnlPresentacion,"PRESENTACION");
		
		pnlJuego=new PanelJuego(this);
		panelPrincipal.add(pnlJuego,"JUEGO");
	}

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			try {
				System.out.println("ESPERANDO CLIENTE");
				cliente=server.accept();
				ClienteConexion cc=new ClienteConexion(cliente,m);
				m.addObserver(cc);
				cc.start();
				System.out.println("CLIENTE CONECTADO...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public PanelMundo getDibujo() {
		// TODO Auto-generated method stub
		return pnlJuego.getDibujo();
	}

	@Override
	public Socket getCliente() {
		// TODO Auto-generated method stub
		return null;
	}	
}
