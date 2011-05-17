package pe.edu.upc.dsd.onpe.ws;

import java.util.List;

import javax.jws.WebService;

import pe.edu.upc.dsd.onpe.model.BeanCandidato;

@WebService(endpointInterface="pe.edu.upc.dsd.onpe.ws.ServiciosWeb")
public class ServiciosWebImpl implements ServiciosWeb {

	@Override
	public List<BeanCandidato> getListaCandidatos() {
		// TODO Auto-generated method stub
		return null;
	}

}
