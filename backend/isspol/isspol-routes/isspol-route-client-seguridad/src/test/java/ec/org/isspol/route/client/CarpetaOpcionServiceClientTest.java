package ec.org.isspol.route.client;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.persistence.entities.security.*;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by paul.salgado on 26/04/17.
 */
public class CarpetaOpcionServiceClientTest extends CamelSpringTestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(CarpetaOpcionServiceClientTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
    }

    @Test
    @Ignore
    public void testListaCarpetaOpcion() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("CarpetaOpcion");
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_CARPETA_OPCION);
        peticionRespuesta.setParameters(new Object[]{});
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        List<CarpetaOpcion> lista = (List<CarpetaOpcion>) peticionRespuesta.getResullt();
        for (CarpetaOpcion x: lista){
            LOG.info("CarpetaOpcion: {} {}", x.getIdCarpetaOpcion(), x.getDescripcion());
        }
    }
}
