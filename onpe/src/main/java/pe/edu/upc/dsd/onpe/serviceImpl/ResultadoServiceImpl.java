package pe.edu.upc.dsd.onpe.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.dsd.onpe.model.BeanResultado;
import pe.edu.upc.dsd.onpe.service.ResultadoService;

public class ResultadoServiceImpl implements ResultadoService {
	
	public static BeanResultado keiko= new BeanResultado("Keiko Sofia Fujimori Iguchi",0);
	public static BeanResultado ollanta= new BeanResultado("Ollanta Humala Tazo",0);

	public List<BeanResultado> getObtenerResutados(){
		
		List lstResultados= new ArrayList<BeanResultado>();
		
		lstResultados.add(keiko);
		lstResultados.add(ollanta);
		
		/*BeanResultado resultado3= new BeanResultado();
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
		lstResultados.add(resultado6);*/

		
		return lstResultados;
		
	}
}
