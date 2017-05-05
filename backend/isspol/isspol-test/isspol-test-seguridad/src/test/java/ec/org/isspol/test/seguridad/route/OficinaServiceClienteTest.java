package ec.org.isspol.test.seguridad.route;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by andres.campoverde on 03/05/2017.
 */
public class OficinaServiceClienteTest extends CamelSpringTestSupport{
    private static final Logger LOG = LoggerFactory.getLogger(OficinaServiceClienteTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
    }

    @Test
    @Ignore
    public void testBuscarOficinaPorId() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_OFICINA_ID);
        peticionRespuesta.setParameters(new Object[]{1});
        peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
        Oficina oficina= (Oficina) peticionRespuesta.getResullt();
        LOG.info("oficina {}",oficina.getNombre());
    }
}
