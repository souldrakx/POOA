package Modelo;

public class Persona {

	

	private String nombre;
	private int edad;
	private Genero genero;
	private String telefono;
	
	public Persona(String nombre, int edad, Genero genero, String telefono) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
		this.telefono = telefono;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", genero=" + genero + ", telefono=" + telefono + "]";
	}
	
	
}
