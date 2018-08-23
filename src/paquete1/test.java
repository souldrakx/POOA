package paquete1;

public class test {

	public static void main(String[] args) {
		
		System.out.println(Operaciones.mult);
		System.out.println(Operaciones.suma.getvalor());
		System.out.println(Operaciones.suma.name());
		
		Operaciones[] values = Operaciones.values();
		for (int i = 0; i < values.length; i++) {
			Operaciones elemento = values[i];
		}
		
		for(Operaciones elemento: Operaciones.values()) {
			System.out.println(elemento.getvalor());
		}
	}

}
