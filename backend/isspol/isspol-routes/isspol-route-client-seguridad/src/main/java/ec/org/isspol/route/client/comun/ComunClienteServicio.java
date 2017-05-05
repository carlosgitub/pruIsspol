package ec.org.isspol.route.client.comun;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.comun.Canton;
import ec.org.isspol.persistence.entities.comun.Estado;
import ec.org.isspol.persistence.entities.comun.Pais;
import ec.org.isspol.persistence.entities.comun.Provincia;
import ec.org.isspol.route.comun.service.ComunServicio;
import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andres.campoverde on 18/04/2017.
 */
public class ComunClienteServicio {
    private static final Logger logger = LoggerFactory.getLogger(ComunClienteServicio.class);

    private CamelContext context;
    private ComunServicio comunServicio;

    public List<Pais>listarPaises(){
        comunServicio =context.getRegistry().lookupByNameAndType("comun",ComunServicio.class);
        List<Pais>response=null;

        try{
            PeticionRespuesta peticionRespuesta=new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTA_PAISES);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta= comunServicio.callRemoteService(peticionRespuesta);
            response= (List<Pais>) peticionRespuesta.getResullt();

            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(IsspolConstant.METHOD_LISTA_PAISES), e);
        }
        return response;
    }

    public Map<String,Object>obtenerFechaHoraSistema(HashMap<String,Object>values){
        comunServicio =context.getRegistry().lookupByNameAndType("comun",ComunServicio.class);
        Map<String,Object>response=null;
        try{
            PeticionRespuesta peticionRespuesta=new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_FECHAHORASISTEMA);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta= comunServicio.callRemoteService(peticionRespuesta);
            response= (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(IsspolConstant.METHOD_PROC_FECHAHORASISTEMA), e);
        }
        return response;
    }

    public void setContext(CamelContext context) {
        this.context = context;
    }

    public List<Provincia> listarProvincias() throws IsspolSearchException, IsspolException {
        comunServicio =context.getRegistry().lookupByNameAndType("comun",ComunServicio.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_PROVINCIAS);
        peticionRespuesta.setParameters(new Object[]{});
        peticionRespuesta = comunServicio.callRemoteService(peticionRespuesta);
        List<Provincia> listaProvincias = (List<Provincia>) peticionRespuesta.getResullt();
        if(peticionRespuesta.getException() != null)
            throw new IsspolSearchException(peticionRespuesta.getException());
        return listaProvincias;
    }

    public List<Canton> listarCantonesPorProvincia(Provincia provincia) throws IsspolSearchException, IsspolException{
        comunServicio =context.getRegistry().lookupByNameAndType("comun",ComunServicio.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_CANTONES_POR_PROVINCIA);
        peticionRespuesta.setParameters(new Object[]{provincia});
        peticionRespuesta = comunServicio.callRemoteService(peticionRespuesta);
        List<Canton> listaCantones = (List<Canton>) peticionRespuesta.getResullt();
        if(peticionRespuesta.getException() != null)
            throw  new IsspolSearchException(peticionRespuesta.getException());
        return listaCantones;
    }

    public List<Estado> listarEstados() throws IsspolSearchException, IsspolException{
        comunServicio =context.getRegistry().lookupByNameAndType("comun",ComunServicio.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_ESTADOS);
        peticionRespuesta.setParameters(new Object[]{});
        peticionRespuesta = comunServicio.callRemoteService(peticionRespuesta);
        List<Estado> listaEstados = (List<Estado>) peticionRespuesta.getResullt();
        if(peticionRespuesta.getException() != null)
            throw new IsspolSearchException(peticionRespuesta.getException());
        return listaEstados;
    }

}
