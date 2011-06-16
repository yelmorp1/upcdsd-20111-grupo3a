package pe.edu.upc.dsd.onpe.ws;

import java.util.List;

import javax.jws.WebService;


import pe.edu.upc.dsd.votacion.model.BeanCandidato;
import pe.edu.upc.dsd.votacion.model.BeanElector;
import pe.edu.upc.dsd.votacion.model.BeanResultado;



@WebService
public interface ServiciosWeb {
	public List<BeanCandidato> getListaCandidatos();
	public void agregarElectorQueYaVoto(BeanElector elector);
	public List<BeanResultado> getObtenerResutados();
}
