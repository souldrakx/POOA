package paquete1;

public enum Operaciones {
		suma("+"),resta("-"),mult("*"),division("/");
	
	private String valor;
	
	Operaciones(String valor){
		this.valor = valor;
	}
	
	public String getvalor() {
		return valor;
	}

}
