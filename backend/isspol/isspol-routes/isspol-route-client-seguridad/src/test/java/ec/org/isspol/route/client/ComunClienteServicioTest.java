package ec.org.isspol.route.client;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.persistence.entities.comun.Pais;
import ec.org.isspol.route.comun.service.ComunServicio;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by andres.campoverde on 18/04/2017.
 */
public class ComunClienteServicioTest extends CamelSpringTestSupport{

    private static final Logger LOG = LoggerFactory.getLogger(ComunClienteServicioTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
    }

    @Test
    @Ignore
    public void obtenerListaPaises() throws IsspolException{
        ComunServicio comunServicio =context.getRegistry().lookupByNameAndType("comun",ComunServicio.class);
        LOG.info("Calling Pais");
        PeticionRespuesta peticionRespuesta=new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTA_PAISES);
        peticionRespuesta.setParameters(new Object[]{});
        peticionRespuesta=comunServicio.callRemoteService(peticionRespuesta);
        List<Pais>paises= new ArrayList<>();
        paises= (List<Pais>) peticionRespuesta.getResullt();
        for(Pais pais:paises){
            LOG.info("Pais: {} {}", pais.getNombre(), pais.getIsoNumerico());
        }
    }

    @Test
    @Ignore
    public void testFechaHoraSP() throws IsspolException {
        ComunServicio comunServicio =context.getRegistry().lookupByNameAndType("comun",ComunServicio.class);
        LOG.info("Calling SP Seguridad.proc_fechahorasistema");
        PeticionRespuesta peticionRespuesta=new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_FECHAHORASISTEMA);
        peticionRespuesta.setParameters(new Object[]{});
        peticionRespuesta=comunServicio.callRemoteService(peticionRespuesta);
        Map<String,Object>response= (Map<String, Object>) peticionRespuesta.getResullt();
        LOG.info("Response {}", response);

    }
}
