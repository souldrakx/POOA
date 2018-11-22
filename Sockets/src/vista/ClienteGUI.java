package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ClienteGUI extends JFrame {

	private JPanel contentPane;
	private JPanel tarjetas;
	private Socket Cliente;
	private int port = 8000;
	private String host="127.0.0.1";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGUI frame = new ClienteGUI();
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
	public ClienteGUI() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setIcon(new ImageIcon(ClienteGUI.class.getResource("/img/new.png")));
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon(ClienteGUI.class.getResource("/img/open.png")));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon(ClienteGUI.class.getResource("/img/save.png")));
		mnFile.add(mntmSave);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(ClienteGUI.class.getResource("/img/about.png")));
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setToolTipText("\r\n");
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente = new Socket(host,port);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(btnConnect);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout) tarjetas.getLayout();
				c.next(tarjetas);
				//c.show(tarjetas, "Juego");
			}
		});
		toolBar.add(btnNew);
		
		JButton btnOpen = new JButton("");
		btnOpen.setToolTipText("Open\r\n");
		btnOpen.setIcon(new ImageIcon(ClienteGUI.class.getResource("/img/open.png")));
		toolBar.add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		toolBar.add(btnSave);
		
		tarjetas = new JPanel();
		contentPane.add(tarjetas, BorderLayout.CENTER);
		tarjetas.setLayout(new CardLayout(0, 0));
		
		PanelPrincipal pnlPrincipal = new PanelPrincipal();
		tarjetas.add(pnlPrincipal,"Principal");
		
		PanelJuego pnlJuego = new PanelJuego();
		tarjetas.add(pnlJuego,"Juego");
		
	}

}
