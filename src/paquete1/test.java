package paquete1;

public class test {

	public static void main(String[] args) {
		
		System.out.println(Operaciones.mult);
		System.out.println(Operaciones.suma.getvalor());
		System.out.println(Operaciones.suma.name());
		
		
		for(Operaciones elemento: Operaciones.values()) {
			System.out.println(elemento.getvalor());
			System.out.println(elemento.name());
		}
	}

}
