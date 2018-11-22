package modelo;

import java.io.Serializable;

public class Mensaje<T> implements Serializable{
	private String tipo;
	private T valor;
	
	public Mensaje(String tipo, T valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	
}
