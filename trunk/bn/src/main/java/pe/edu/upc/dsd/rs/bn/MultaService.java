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
		
			
		
		Gson gson = new Gson();
		List<Multa> lista = new ArrayList<Multa>();		
	
		Multa multa = new Multa();
		multa.setMonto(2000);
		multa.setDniElector("44501659");
		
		lista.add(multa);
		
	    multa = new Multa();
		multa.setMonto(1000);
		multa.setDniElector("42722311");
		
		lista.add(multa);
		
		 multa = new Multa();
		multa.setMonto(50000);
		multa.setDniElector("08524439");
		
		lista.add(multa);
		
		return gson.toJson(lista); // Convierto de un bean Java a JSON ;)
	}
	
}
