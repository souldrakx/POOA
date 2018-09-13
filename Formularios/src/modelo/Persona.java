package modelo;

public class Persona {
	
	private String nombre;
	private String contra;
	private Genero genero;
	
	public Persona(String nombre, String contra) {
		super();
		this.nombre = nombre;
		this.contra = contra;
	}
	
	public Persona(String nombre, String contra, Genero genero) {
		super();
		this.nombre = nombre;
		this.contra = contra;
		this.genero = genero;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", contra=" + contra + "]";
	}
	

}
