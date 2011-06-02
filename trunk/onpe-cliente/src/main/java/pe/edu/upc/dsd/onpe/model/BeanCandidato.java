package pe.edu.upc.dsd.onpe.model;

import java.io.Serializable;

public class BeanCandidato implements Serializable{
	
	private String nombre;
	private String apellidos;
	private String partidoPolitico;
	private int edad;
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setPartidoPolitico(String partidoPolitico) {
		this.partidoPolitico = partidoPolitico;
	}
	public String getPartidoPolitico() {
		return partidoPolitico;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}	
	
	
	
	
}
