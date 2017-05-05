package ec.org.isspol.web.seguridades;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.route.client.context.AppContext;
import ec.org.isspol.route.client.seguridad.OficinaServiceClient;
import ec.org.isspol.web.comun.ComunController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.io.Serializable;

/**
 * Created by andres.campoverde on 03/05/2017.
 */
@Controller
public class OficinaController extends ComunController implements Serializable{
    private static final Logger logger = LoggerFactory.getLogger(OficinaController.class);

    public Oficina buscarOficinaPorId(Integer id) throws IsspolException {
        OficinaServiceClient client = (OficinaServiceClient) AppContext.getBean("oficinaServiceClient");
        Oficina oficina=client.obtenerOficinaPorId(id);
        return oficina;
    }
}
