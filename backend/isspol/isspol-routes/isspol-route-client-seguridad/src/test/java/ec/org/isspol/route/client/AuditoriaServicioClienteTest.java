package ec.org.isspol.route.client;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.route.auditoria.service.AuditoriaServicio;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public class AuditoriaServicioClienteTest extends CamelSpringTestSupport{
    private static final Logger LOG = LoggerFactory.getLogger(AuditoriaServicioClienteTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
    }

    @Test
    public void testLogAuditoria() throws IsspolException {
        AuditoriaServicio auditoriaServicio = context.getRegistry().lookupByNameAndType("auditoria", AuditoriaServicio.class);
        LOG.info("Log Auditoria SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_DESCRIPCION,"prueba");
        in.put(IsspolConstant.AS_REFERENCIA,"referencia prueba");
        in.put(IsspolConstant.AS_TIPO,"tipo");
        in.put(IsspolConstant.AS_USUARIO,"carauz");
        in.put(IsspolConstant.AS_MAQUINA,"BDD");
        in.put(IsspolConstant.AS_APLICACION,"backend");
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_LOG);
        peticionRespuesta.setParameters(new Object[]{in});
        peticionRespuesta=auditoriaServicio.callRemoteService(peticionRespuesta);
        Map<String, Object> response = (Map<String, Object>) peticionRespuesta.getResullt();
        LOG.info("Response {}", response);
    }
}
