package pe.edu.upc.dsd.onpe.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.dsd.onpe.model.BeanCandidato;
import pe.edu.upc.dsd.onpe.service.CandidatoService;

public class CandidatoServiceImpl implements CandidatoService{

	public List<BeanCandidato> getListaCandidatos() {
		
		
		List  lstCandidatos = new ArrayList<BeanCandidato>();
		
		BeanCandidato candidato1 = new BeanCandidato();
		candidato1.setApellidos("Fujimori Iguchi");
		candidato1.setNombre("Keiko");
		candidato1.setPartidoPolitico("Fuerza 2011");
		lstCandidatos.add(candidato1);
		
		BeanCandidato candidato2 = new BeanCandidato();
		candidato2.setApellidos("Kuczinsky");
		candidato2.setNombre("Pedro Pablo");
		candidato2.setPartidoPolitico("Alianza por el Gran Cambio");
		lstCandidatos.add(candidato2);
				
		BeanCandidato candidato3 = new BeanCandidato();
		candidato3.setApellidos("Humala Tazo");
		candidato3.setNombre("Ollanta");
		candidato3.setPartidoPolitico("Gana Peru");
		lstCandidatos.add(candidato3);
		
		BeanCandidato candidato4 = new BeanCandidato();
		candidato4.setApellidos("Toledo Manrique");
		candidato4.setNombre("Alejandro");
		candidato4.setPartidoPolitico("Peru Posible");
		lstCandidatos.add(candidato4);
		
		
		BeanCandidato candidato5 = new BeanCandidato();
		candidato5.setApellidos("Castaneda Lossio");
		candidato5.setNombre("Luis");
		candidato5.setPartidoPolitico("Solidaridad Nacional");
		lstCandidatos.add(candidato5);
		
		return lstCandidatos;
	}

}
