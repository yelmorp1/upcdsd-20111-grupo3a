package pe.edu.upc.dsd.onpe.model;

import java.io.Serializable;

public class BeanCandidato implements Serializable{
	
	private String nombre;
	private String apellidos;
	private String partidoPolitico;
	private int edad;
	private String logo;
	private String foto;
	private String codReferencia;
	private String codSeleccion;
	
	
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
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getLogo() {
		return logo;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getFoto() {
		return foto;
	}
	public void setCodReferencia(String codReferencia) {
		this.codReferencia = codReferencia;
	}
	public String getCodReferencia() {
		return codReferencia;
	}
	public void setCodSeleccion(String codSeleccion) {
		this.codSeleccion = codSeleccion;
	}
	public String getCodSeleccion() {
		return codSeleccion;
	}	
	
	
	
	
}
