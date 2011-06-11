package pe.edu.upc.dsd.onpe.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.dsd.onpe.model.BeanCandidato;
import pe.edu.upc.dsd.onpe.service.CandidatoService;

public class CandidatoServiceImpl implements CandidatoService{

	public List<BeanCandidato> getListaCandidatos() {
		
		
		List<BeanCandidato> lstCandidatos = new ArrayList<BeanCandidato>();
		
		BeanCandidato candidato1 = new BeanCandidato();
		candidato1.setApellidos("Fujimori Iguchi");
		candidato1.setNombre("Keiko Sofia");
		candidato1.setPartidoPolitico("Fuerza 2011");
		candidato1.setEdad(36);
		lstCandidatos.add(candidato1);
		
		BeanCandidato candidato3 = new BeanCandidato();
		candidato3.setApellidos("Humala Tazo");
		candidato3.setNombre("Ollanta");
		candidato3.setPartidoPolitico("Gana Peru");
		candidato3.setEdad(47);
		lstCandidatos.add(candidato3);
		
		/*BeanCandidato candidato2 = new BeanCandidato();
		candidato2.setApellidos("Kuczinsky");
		candidato2.setNombre("Pedro Pablo");
		candidato2.setPartidoPolitico("Alianza por el Gran Cambio");
		candidato2.setEdad(72);
		lstCandidatos.add(candidato2);*/
				
		
		
		/*BeanCandidato candidato4 = new BeanCandidato();
		candidato4.setApellidos("Toledo Manrique");
		candidato4.setNombre("Alejandro");
		candidato4.setPartidoPolitico("Peru Posible");
		candidato4.setEdad(65);
		lstCandidatos.add(candidato4);
		
		
		BeanCandidato candidato5 = new BeanCandidato();
		candidato5.setApellidos("Castaneda Lossio");
		candidato5.setNombre("Luis");
		candidato5.setPartidoPolitico("Solidaridad Nacional");
		candidato5.setEdad(65);
		lstCandidatos.add(candidato5);
		
		BeanCandidato candidato6 = new BeanCandidato();
		candidato6.setApellidos("Noriega");
		candidato6.setNombre("Ricardo");
		candidato6.setPartidoPolitico("Despertar Nacional");
		candidato6.setEdad(64);
		lstCandidatos.add(candidato6);
		
		
		BeanCandidato candidato7 = new BeanCandidato();
		candidato7.setApellidos("Nique de la Puente");
		candidato7.setNombre("Jose");
		candidato7.setPartidoPolitico("Partido Fonavista del Peru");
		candidato7.setEdad(64);
		lstCandidatos.add(candidato7);
		
		BeanCandidato candidato8 = new BeanCandidato();
		candidato8.setApellidos("Reymer");
		candidato8.setNombre("Juliana");
		candidato8.setPartidoPolitico("Fuerza Nacional");
		candidato8.setEdad(51);
		lstCandidatos.add(candidato8);
		
		BeanCandidato candidato9 = new BeanCandidato();
		candidato9.setApellidos("Pinazo Bella");
		candidato9.setNombre("Humberto");
		candidato9.setPartidoPolitico("Partido Justicia,Tecnologia y Ecologia");
		candidato9.setEdad(70);
		lstCandidatos.add(candidato9);
		
		BeanCandidato candidato10 = new BeanCandidato();
		candidato10.setApellidos("Rodriguez Cuadros");
		candidato10.setNombre("Jose");
		candidato10.setPartidoPolitico("Fuerza Social");
		candidato10.setEdad(61);
		lstCandidatos.add(candidato10);
		
		BeanCandidato candidato11 = new BeanCandidato();
		candidato11.setApellidos("Belaunde");
		candidato11.setNombre("Rafael Luis");
		candidato11.setPartidoPolitico("Partido Politico Adelante");
		candidato11.setEdad(63);
		lstCandidatos.add(candidato11);*/
		
		return lstCandidatos;
	}

}
