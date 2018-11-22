package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Controlador.ControladorBtn;
import Controlador.ListaControlador;
import Modelo.Genero;
import Modelo.Persona;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class AgendaGUI extends JFrame implements AgendaInterfaz{

	private JPanel contentPane;
	private DefaultListModel <Persona> modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaGUI frame = new AgendaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AgendaGUI() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlPrincipal = new JPanel();
		contentPane.add(pnlPrincipal, BorderLayout.CENTER);
		pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal, BoxLayout.X_AXIS));
		
		PersonaGUI personaGUI = new PersonaGUI();
		pnlPrincipal.add(personaGUI);
		
		JPanel pnlInformcaion = new JPanel();
		pnlPrincipal.add(pnlInformcaion);
		pnlInformcaion.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 10, true), "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInformcaion.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlInformcaion.add(scrollPane);
		
		JList listaDatos = new JList();
		modelo = new DefaultListModel<Persona>();
		listaDatos.setModel(modelo);
		scrollPane.setViewportView(listaDatos);
		
		Persona  p = new Persona("Luis", 30, Genero.FEMENINO,"123123123");
		Persona  p2 = new Persona("Luisa", 310, Genero.MASCULINO,"123123123");
		Persona  p3 = new Persona("Luis", 30, Genero.FEMENINO,"123123123");
		
		modelo.addElement(p);
		modelo.addElement(p2);
		modelo.addElement(p3);
		
		listaDatos.addListSelectionListener(new ListaControlador(null));
		
		ControladorBtn controlador = new ControladorBtn(this);
		btnAgregar.setActionCommand("Agregar");
		btnAgregar.addActionListener(controlador);
		
		btnNuevo.setActionCommand("Nuevo");
		btnNuevo.addActionListener(controlador);
		
		btnEditar.setActionCommand("Editar");
		btnEditar.addActionListener(controlador);
		
		btnAEliminar.setActionCommand("Eliminar");
		btnAEliminar.addActionListener(controlador);
		
		JPanel pnlBotones = new JPanel();
		contentPane.add(pnlBotones, BorderLayout.SOUTH);
		
		JButton btnNuevo = new JButton("Nuevo");
		pnlBotones.add(btnNuevo);
		
		JButton btnAgregar = new JButton("Agregar");
		pnlBotones.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		pnlBotones.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		pnlBotones.add(btnEliminar);
	}

	@Override
	public void setPersona(Persona p) {
		// TODO Auto-generated method stub
		
	}
	
	public Persona getPersona() {
		return personalPanel.getDatos();
		
		
	}
	
	public void limpiar() {
		personaPanel.Limpiar();
		listaResultadors.clearSelection();
	}

	@Override
	public Persona getPersona(Persona p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultListModel<Persona> getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Limpiar() {
		// TODO Auto-generated method stub
		
	}

}
