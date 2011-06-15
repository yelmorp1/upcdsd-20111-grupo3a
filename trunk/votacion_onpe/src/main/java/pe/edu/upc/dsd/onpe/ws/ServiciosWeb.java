package pe.edu.upc.dsd.onpe.ws;

import java.util.List;

import javax.jws.WebService;
import pe.edu.upc.dsd.votacion.model.BeanCandidato;
import pe.edu.upc.dsd.votacion.model.BeanElector;



@WebService
public interface ServiciosWeb {
	public List<BeanCandidato> getListaCandidatos();
	public void agregarElectorQueYaVoto(BeanElector elector);
}
