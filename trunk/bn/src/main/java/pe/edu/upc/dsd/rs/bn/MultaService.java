package pe.edu.upc.dsd.rs.bn;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pe.edu.upc.dsd.bn.model.BeanElector;
import pe.edu.upc.dsd.rs.bn.Multa;

import com.google.gson.Gson;

public class MultaService {

	@GET
	@Path("/multas/")
	@Produces("application/json")
	public String getMulta() {
		//obtiene la lista de todos los eletores habiles
		List<BeanElector> listaElectores = new WSElectores().getElectores();
		
		//obtiene la lista de los electores que votaron
		List<BeanElector> listaElectoresQueVotaron = new WSElectores().getElectoresQueVotaron();
		
		//lista de electores que NO votaron
		List<BeanElector> listaElectoresQueNoVotaron = new ArrayList<BeanElector>();
		
		for(BeanElector elector:listaElectores){
			for(BeanElector votante:listaElectoresQueVotaron){
				if(!elector.getDni().equals(votante.getDni())){
					listaElectoresQueNoVotaron.add(elector);
				}
			}	
		}
		
		Gson gson = new Gson();
		List<Multa> lista = new ArrayList<Multa>();	
		
		for(BeanElector multado:listaElectoresQueNoVotaron){
			Multa multa = new Multa();
			multa.setMonto(150);
			multa.setDniElector(multado.getDni());
			
			lista.add(multa);
		}

		return gson.toJson(lista); // Convierto de un bean Java a JSON ;)
	}
	
}
