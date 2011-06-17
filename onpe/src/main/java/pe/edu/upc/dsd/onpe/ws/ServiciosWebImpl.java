package pe.edu.upc.dsd.onpe.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import pe.edu.upc.dsd.onpe.model.BeanCandidato;
import pe.edu.upc.dsd.onpe.model.BeanElector;
import pe.edu.upc.dsd.onpe.model.BeanResultado;
import pe.edu.upc.dsd.onpe.service.CandidatoService;
import pe.edu.upc.dsd.onpe.service.ResultadoService;
import pe.edu.upc.dsd.onpe.serviceImpl.CandidatoServiceImpl;
import pe.edu.upc.dsd.onpe.serviceImpl.ResultadoServiceImpl;

@WebService(endpointInterface="pe.edu.upc.dsd.onpe.ws.ServiciosWeb")
public class ServiciosWebImpl implements ServiciosWeb {

	private List<BeanElector> listaElectoresQueVotaron;
	
	@Override
	public List<BeanCandidato> getListaCandidatos() {
		System.out.println("entrando onpe servicio: getListaCandidatos");
		CandidatoService cs = new CandidatoServiceImpl();
		return cs.getListaCandidatos();
	}

	@Override
	public List<BeanResultado> getObtenerResutados() {
		System.out.println("entrando onpe servicio: getObtenerResutados");
		ResultadoService rs= new ResultadoServiceImpl();
		return rs.getObtenerResutados();
	}

	@Override
	public List<BeanElector> getListaElectoresQueVotaron() {
		System.out.println("entrando onpe servicio: getListaElectoresQueVotaron");
		if(listaElectoresQueVotaron==null){
			listaElectoresQueVotaron = new ArrayList<BeanElector>();
		}
		System.out.println("votaron: "+listaElectoresQueVotaron.size());
		return listaElectoresQueVotaron;
	}

	@Override
	public void agregarElectorQueYaVoto(BeanElector elector) {
		if(listaElectoresQueVotaron==null)
			listaElectoresQueVotaron = new ArrayList<BeanElector>();
		listaElectoresQueVotaron.add(elector);		
	}

}
