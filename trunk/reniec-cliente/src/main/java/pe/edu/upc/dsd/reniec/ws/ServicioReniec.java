package pe.edu.upc.dsd.reniec.ws;

import java.util.List;

import javax.jws.WebService;

import pe.edu.upc.dsd.reniec.model.BeanElector;;

@WebService
public interface ServicioReniec {
	public List<BeanElector> getListaElectores();
	
	
}
