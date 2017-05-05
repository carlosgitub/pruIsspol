package ec.org.isspol.test.seguridad.route;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.comun.Canton;
import ec.org.isspol.persistence.entities.comun.Estado;
import ec.org.isspol.persistence.entities.comun.Provincia;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.route.comun.service.ComunServicio;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andres.campoverde on 19/04/2017.
 */
public class ComunClienteTest extends CamelSpringTestSupport {
    private static final Logger logger = LoggerFactory.getLogger(ComunClienteTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
    }

    @Test
    public void probarServicioFecha() throws IsspolException {
        ComunServicio comunServicio = context.getRegistry().lookupByNameAndType("comunServicio", ComunServicio.class);
        Map<String, Object> respuesta1 = new HashMap();
        respuesta1.put(IsspolConstant.AD_FECHA,"");
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta(IsspolConstant.METHOD_PROC_FECHAHORASISTEMA, new Object[]{respuesta1});
        peticionRespuesta = comunServicio.callRemoteService(peticionRespuesta);
        Map<String, Object> respuesta = (Map<String, Object>) peticionRespuesta.getResullt();
//        Assert.assertNotNull(respuesta);
        logger.info("{}", respuesta);
        Assert.assertNotNull(respuesta);

        for (Map.Entry<String, Object> entry : respuesta.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    @Test
    public void testListarProvincias() throws IsspolException {
        ComunServicio comunServicio = context.getRegistry().lookupByNameAndType("comunServicio", ComunServicio.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta(IsspolConstant.METODO_LISTAR_PROVINCIAS, new Object[]{});
        peticionRespuesta = comunServicio.callRemoteService(peticionRespuesta);
        List<Provincia> provincias = (List<Provincia>) peticionRespuesta.getResullt();
        for (Provincia provincia : provincias ) {
            logger.info("Id: {} Nombre: {} ", provincia.getIdProvincia(), provincia.getNombre());
        }
    }

    @Test
    public void testListarCantonesPorProvincia() throws IsspolException {
        ComunServicio comunServicio = context.getRegistry().lookupByNameAndType("comunServicio", ComunServicio.class);
        Provincia provincia = new Provincia(9, "02090000", "GUAYAS", Boolean.FALSE, "dbo", new Date(),
                "00-15-5D-02-F1-1B", "dbo", new Date(), "00-15-5D-02-F1-1B");
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta(IsspolConstant.METODO_LISTAR_CANTONES_POR_PROVINCIA, new Object[]{provincia});
        peticionRespuesta = comunServicio.callRemoteService(peticionRespuesta);
        List<Canton> cantones = (List<Canton>) peticionRespuesta.getResullt();
        for (Canton canton : cantones){
            logger.info("Id: {} Nombre: {}", canton.getIdCanton(), canton.getNombre());
        }
    }

    @Test
    public void testListarEstados() throws IsspolException {
        ComunServicio comunServicio =context.getRegistry().lookupByNameAndType("comunServicio",ComunServicio.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_ESTADOS);
        peticionRespuesta.setParameters(new Object[]{});
        peticionRespuesta = comunServicio.callRemoteService(peticionRespuesta);
        List<Estado> listaEstados = (List<Estado>) peticionRespuesta.getResullt();
        for (Estado estado : listaEstados){
            logger.info("Id: {} Nombre: {}", estado.getIdEstado(), estado.getDescripcion());
        }
    }

}
