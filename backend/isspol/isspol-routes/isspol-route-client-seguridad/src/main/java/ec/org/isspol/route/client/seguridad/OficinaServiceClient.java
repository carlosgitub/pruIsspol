package ec.org.isspol.route.client.seguridad;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by andres.campoverde on 03/05/2017.
 */
public class OficinaServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceClient.class);

    private CamelContext context;
    private UsuarioService usuarioService;


    public void setContext(CamelContext context) {
        this.context = context;
    }

    public Oficina obtenerOficinaPorId(Integer id) throws IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_OFICINA_ID);
        peticionRespuesta.setParameters(new Object[]{id});
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        if (peticionRespuesta.getException() != null)
            throw new IsspolException(peticionRespuesta.getException());
        Oficina oficina= (Oficina) peticionRespuesta.getResullt();
        return oficina;
    }
}
