package ChatSockets;



import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread mihilo = new Thread(this);
		mihilo.start();
		
		}
	
	
	
	private	JTextArea areatexto;



	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("Holaa");
		
		try {
			ServerSocket servidor = new ServerSocket(9999);

			String nick,ip,mensaje;
			
			ArrayList <String> listaIP = new ArrayList<String>();

			PaqueteEnvio paquete_recibido;

			while (true) {
			
			Socket misocket = servidor.accept();
			
			

			ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());

			paquete_recibido =(PaqueteEnvio) paquete_datos.readObject();

			nick = paquete_recibido.getNick();
			
			ip = paquete_recibido.getIp();
			
			mensaje = paquete_recibido.getMensaje();
			
			//DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
			
			//String mensaje_texto = flujo_entrada.readUTF();
			
			//areatexto.append("\n" + mensaje_texto);
			
			if(!mensaje.equals("Online")) {

			areatexto.append("\n" + nick + ": "+mensaje+" para "+ ip);

			Socket enviaDestinatario = new Socket(ip,9090);

			ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());

			paqueteReenvio.writeObject(paquete_recibido);
			
			enviaDestinatario.close();
			
			misocket.close(); } else {
				
				//Detecta usuarios---------------------------------------
				
				InetAddress localizacion = misocket.getInetAddress();
				
				String ipRemota = localizacion.getHostAddress();
				
				System.out.println("Online "+ ipRemota);
				
				System.out.println("Hola");
				
				listaIP.add(ipRemota);
				
				for(String z:listaIP) {
					System.out.println("Array:" + z);
				}
				
				
				//-------------------------------------------------------
			}
			}
			
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
