package pruebas;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcesoUno p1=new ProcesoUno();
		ProcesoDos m=new ProcesoDos();
		
		p1.setPriority(Thread.MIN_PRIORITY);
		p1.start();
		try {
			p1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread hilo=new Thread(m);
		hilo.setPriority(Thread.MAX_PRIORITY);
		hilo.start();
		
		
		
	}

}
