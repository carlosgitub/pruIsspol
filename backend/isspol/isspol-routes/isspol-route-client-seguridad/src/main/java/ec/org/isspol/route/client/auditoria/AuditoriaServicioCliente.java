package ec.org.isspol.route.client.auditoria;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.route.auditoria.service.AuditoriaServicio;
import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public class AuditoriaServicioCliente {
    private static final Logger logger = LoggerFactory.getLogger(AuditoriaServicioCliente.class);

    private CamelContext context;

    private AuditoriaServicio auditoriaServicio;

    public Map<String, Object> logAuditoria(HashMap<String, Object> values) throws IsspolException {
        auditoriaServicio = context.getRegistry().lookupByNameAndType("auditoria", AuditoriaServicio.class);
        Map<String, Object> response = null;
        try {
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_LOG);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta = auditoriaServicio.callRemoteService(peticionRespuesta);
            response= (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(IsspolConstant.METHOD_PROC_LOG), e);
        }
        return response;
    }

    public void setContext(CamelContext context) {
        this.context = context;
    }
}
