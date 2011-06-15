package pe.edu.upc.dsd.onpe.ws;

import java.util.List;

import javax.jws.WebService;

import pe.edu.upc.dsd.onpe.model.BeanCandidato;
import pe.edu.upc.dsd.onpe.model.BeanElector;
import pe.edu.upc.dsd.onpe.model.BeanResultado;

@WebService
public interface ServiciosWeb {
	
	public List<BeanCandidato> getListaCandidatos();
	public List<BeanResultado> getObtenerResutados();
	public List<BeanElector> getListaElectoresQueVotaron();
	public void agregarElectorQueYaVoto(BeanElector elector);
}
