package pe.edu.upc.dsd.reniec.ws;

import java.util.List;

import javax.jws.WebService;

import pe.edu.upc.dsd.reniec.model.BeanElector;
import pe.edu.upc.dsd.reniec.service.ElectorService;
import pe.edu.upc.dsd.reniec.serviceImpl.ElectorServiceImpl;

@WebService(endpointInterface="pe.edu.upc.dsd.reniec.ws.ServicioReniec")
public class ServicioReniecImpl implements ServicioReniec{

	@Override
	public List<BeanElector> getListaElectores() {
		ElectorService es = new ElectorServiceImpl();
		return es.getListaElectores();
	}

}
