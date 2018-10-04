package Prueba;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Modelo.Persona;

public class TestSerializacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		Persona p = new Persona("Juan",33);
		Persona p2 = new Persona("Maria",31);
		
		lista.add(p);
		lista.add(p2);
		
		try {
			FileOutputStream file = new FileOutputStream("test.txt");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(lista);
			//oos.writeObject(p);
			//oos.writeObject(p2);
			oos.close();
			file.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream fileLectura = new FileInputStream("test.txt");
			ObjectInputStream ois = new ObjectInputStream(fileLectura);
			
			ArrayList<Persona> respuesta = (ArrayList<Persona>)ois.readObject();
			
			for(Persona item : respuesta) {
				System.out.println(item.toString());
			}
			
			//Persona respuesta = (Persona) ois.readObject();
			//Persona respuesta3 = (Persona) ois.readObject();
			
			
			fileLectura.close();
			ois.close();
			
			//System.out.println(respuesta.toString());
			//System.out.println(respuesta3.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
