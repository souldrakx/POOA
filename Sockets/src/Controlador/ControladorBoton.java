package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import modelo.Cuadrado;
import modelo.Mensaje;
import vista.interfaces.VistaInterface;

public class ControladorBoton implements ActionListener {
	
	private VistaInterface vista;
	private ArrayList<Color> listaColores;
	
	public ControladorBoton(VistaInterface vista) {
		this.vista=vista;
		listaColores=new ArrayList<Color>();
		listaColores.add(Color.red);
		listaColores.add(Color.GREEN);
		listaColores.add(Color.blue);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// CALCULO DE RANGOS 
		Random r=new Random();// OBJETO PARA CREAR NUMEROS ALEATORIOS.
		/*
		 * METODO: nextInt(int value)
		 * Retorna un numero aleatorio entre 0 (incluido) y el valor especificado (excluido).
		 * EJEMPLOS: 
		 * nextInt(20) ---> Numero aleatorio entre 0 a 19
		 * nextInt(65) ---> Numero aleatorio entre 0 a 64
		 * nextInt(11) ---> Numero aleatorio entre 0 a 10
		 * */
		
		// FORMULA: nextInt(LIM.SUPERIOR-LIM. INFERIOR + 1)+LIMITE INFERIOR
		int size=r.nextInt(16)+5;//---> Numero aleatorio entre 5 a 20
		int x=r.nextInt(vista.getDibujo().getWidth()-size-10)+10;
		int y=r.nextInt(vista.getDibujo().getHeight()-size-10)+10;
		int dx=r.nextInt(5)+1;//---> Numero aleatorio entre 1 a 5
		int dy=r.nextInt(5)+1;//---> Numero aleatorio entre 1 a 5
		int indexColor=r.nextInt(3);//-->Numero aleatorio para color
		Cuadrado c=new Cuadrado(x,y,listaColores.get(indexColor),size,dx,dy);
		//vista.getDibujo().addCuadrado(c);
		//Thread t=new Thread(c);
		//t.start();
		
		try {
			ObjectOutputStream output=new ObjectOutputStream(vista.getCliente().getOutputStream());
			output.writeObject(new Mensaje<Cuadrado>("CUADRADO",c));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
