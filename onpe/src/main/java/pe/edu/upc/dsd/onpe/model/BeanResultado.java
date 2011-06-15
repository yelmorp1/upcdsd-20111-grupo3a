package pe.edu.upc.dsd.onpe.model;

import java.io.Serializable;

public class BeanResultado implements Serializable{
	
	private String nomCandidato;
	private int cantVotos;
	
	
	public BeanResultado() {
		
	}
	public BeanResultado(String nomcandidato, int votos) {
		nomCandidato= nomcandidato;
		cantVotos = votos;
	}
	
	public String getNomCandidato() {
		return nomCandidato;
	}
	public void setNomCandidato(String nomCandidato) {
		this.nomCandidato = nomCandidato;
	}
	public int getCantVotos() {
		return cantVotos;
	}
	public void setCantVotos(int cantVotos) {
		this.cantVotos = cantVotos;
	}
	
	

}
