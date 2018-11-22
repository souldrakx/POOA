package pruebas;

public class ProcesoUno extends Thread{
	
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Proceso Uno - "+i);
		}
	}

}
