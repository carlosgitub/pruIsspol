package ec.org.isspol.route.client.seguridad;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;
import ec.org.isspol.persistence.entities.security.NivelEstructuraOrg;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by santiago.yacelga on 21/04/2017.
 */
public class EstructuraOrganizacionalClient {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceClient.class);

    private CamelContext context;
    public void setContext(CamelContext context) {
        this.context = context;
    }

    private UsuarioService usuarioService;


    public Collection<EstructuraOrganizacional> listarEstrucOraganiz(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Collection<EstructuraOrganizacional> lstEstr = null;
        try {
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURANIVEL);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lstEstr = (List<EstructuraOrganizacional>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURANIVEL), e);
        }


        return lstEstr;
    }

    public Map<String, Object> procEstructuraOrganizacionalEliminar(HashMap<String, Object> values){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_ESTRUCTURA_ORGANIZACIONAL_ELIMINAR);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }



    public List<EstructuraOrganizacional> listarEstructuraOrganizacional(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<EstructuraOrganizacional> lstEstr = null;
        try {
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURA);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lstEstr = (List<EstructuraOrganizacional>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURA), e);
        }
        return lstEstr;
    }

    public List<NivelEstructuraOrg> listarTodosNivelEstructuraOrg(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<NivelEstructuraOrg> lstNivelEstr = null;
        try {
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTA_NIVEL_ESTRUCUTURA_ORG);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lstNivelEstr = (List<NivelEstructuraOrg>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(IsspolConstant.METHOD_LISTA_NIVEL_ESTRUCUTURA_ORG), e);
        }
        return lstNivelEstr;
    }
}
