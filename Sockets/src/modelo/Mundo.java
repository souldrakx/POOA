package modelo;

import java.util.ArrayList;
import java.util.Observable;

public class Mundo extends Observable{
	
	private ArrayList<Cuadrado> listaCuadrados;
	
	public Mundo() {
		listaCuadrados=new ArrayList<Cuadrado>();
	}
	
	public void addCuadrado(Cuadrado c) {
		listaCuadrados.add(c);
		setChanged();
		notifyObservers(c);
	}
	
	public void removeCuadrado(Cuadrado c) {
		listaCuadrados.remove(c);
		setChanged();
		notifyObservers(c);
		
	}

}
