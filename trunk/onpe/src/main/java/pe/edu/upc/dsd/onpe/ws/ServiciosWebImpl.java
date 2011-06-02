package pe.edu.upc.dsd.onpe.ws;

import java.util.List;

import javax.jws.WebService;

import pe.edu.upc.dsd.onpe.model.BeanCandidato;
import pe.edu.upc.dsd.onpe.model.BeanResultado;
import pe.edu.upc.dsd.onpe.service.CandidatoService;
import pe.edu.upc.dsd.onpe.service.ResultadoService;
import pe.edu.upc.dsd.onpe.serviceImpl.CandidatoServiceImpl;
import pe.edu.upc.dsd.onpe.serviceImpl.ResultadoServiceImpl;

@WebService(endpointInterface="pe.edu.upc.dsd.onpe.ws.ServiciosWeb")
public class ServiciosWebImpl implements ServiciosWeb {

	@Override
	public List<BeanCandidato> getListaCandidatos() {
		CandidatoService cs = new CandidatoServiceImpl();
		return cs.getListaCandidatos();
	}

	@Override
	public List<BeanResultado> getObtenerResutados() {
		ResultadoService rs= new ResultadoServiceImpl();
		return rs.getObtenerResutados();
	}

}
