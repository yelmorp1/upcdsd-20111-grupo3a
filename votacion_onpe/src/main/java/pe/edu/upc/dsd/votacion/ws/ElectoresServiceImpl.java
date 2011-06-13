package pe.edu.upc.dsd.votacion.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import pe.edu.upc.dsd.votacion.model.BeanElector;

@WebService 
public class ElectoresServiceImpl implements ElectoresService{

	private List<BeanElector> listaElectores;

	public ElectoresServiceImpl(){
		listaElectores = new ArrayList<BeanElector>();	
	}
	
	@Override
	public List<BeanElector> getElectoresQueVotaron() {
		return listaElectores;
	}
	
	public void agregarElector(BeanElector e){		
		listaElectores.add(e);
	}

}
