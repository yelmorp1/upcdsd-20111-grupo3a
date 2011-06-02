package pe.edu.upc.dsd.onpe.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.dsd.onpe.model.BeanResultado;
import pe.edu.upc.dsd.onpe.service.ResultadoService;

public class ResultadoServiceImpl implements ResultadoService {

	public List<BeanResultado> getObtenerResutados(){
		
		List lstResultados= new ArrayList<BeanResultado>();
		
		BeanResultado resultado1= new BeanResultado();
		resultado1.setNomCandidato("Keiko Sofia Fujimori Iguchi");
		resultado1.setCantVotos(2000000);
		lstResultados.add(resultado1);
		
		BeanResultado resultado2= new BeanResultado();
		resultado2.setNomCandidato("Pedro Pablo Kuczinsky");
		resultado2.setCantVotos(5000);
		lstResultados.add(resultado2);
		
		BeanResultado resultado3= new BeanResultado();
		resultado3.setNomCandidato("Ollanta Humala Tazo");
		resultado3.setCantVotos(100000);
		lstResultados.add(resultado3);
		
		BeanResultado resultado4= new BeanResultado();
		resultado4.setNomCandidato("Alejandro Toledo Manrique");
		resultado4.setCantVotos(10000);
		lstResultados.add(resultado4);
		
		BeanResultado resultado5= new BeanResultado();
		resultado5.setNomCandidato("Luis Castaneda Lossio");
		resultado5.setCantVotos(5000);
		lstResultados.add(resultado5);
		
		BeanResultado resultado6= new BeanResultado();
		resultado6.setNomCandidato("Ricardo Noriega");
		resultado6.setCantVotos(5000);
		lstResultados.add(resultado6);

		
		return lstResultados;
		
	}
}
