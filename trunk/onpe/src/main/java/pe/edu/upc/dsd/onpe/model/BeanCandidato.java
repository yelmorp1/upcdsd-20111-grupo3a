package pe.edu.upc.dsd.onpe.model;

public class BeanCandidato {
	
	private String nombre;
	private String apellidos;
	private String partidoPolitico;
	
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
	
}
