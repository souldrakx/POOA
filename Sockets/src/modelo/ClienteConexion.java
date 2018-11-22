package modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import org.omg.CosNaming.IstringHelper;

public class ClienteConexion implements Runnable,Observer{
	private Socket cliente;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private boolean isRunning;
	private Thread t;
	private Mundo m;
	
	public ClienteConexion(Socket cliente,Mundo m) {
		this.cliente=cliente;
		this.m=m;
	}
	
	public void start() {
		if(isRunning)return;
		isRunning=true;
		t=new Thread(this);
		t.start();
	}
	
	public void stop() {
		if(!isRunning)return;
		isRunning=false;
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			try {
				input=new ObjectInputStream(cliente.getInputStream());
				Mensaje leido=(Mensaje) input.readObject();
				if(leido.getTipo().equals("SALIDA")) {
					m.deleteObserver(this);
					output=new ObjectOutputStream(cliente.getOutputStream());
					output.writeObject(new Mensaje("SALTE","SALTE"));
					stop();
					
					input.close();
					output.close();
					cliente.close();
				}
				else if(leido.getTipo().equals("CUADRADO")) {
					m.addCuadrado((Cuadrado)leido.getValor());
				}
				
				System.out.println(leido.toString());
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		try {
			output=new ObjectOutputStream(cliente.getOutputStream());
			output.writeObject(new Mensaje("CUADRADO",arg));
			System.out.println("ENVIA");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
