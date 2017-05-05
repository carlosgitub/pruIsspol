import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.persistence.entities.comun.Estado;
import ec.org.isspol.persistence.entities.comun.LogNotificacion;
import ec.org.isspol.route.comun.service.ComunServicio;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andres.campoverde on 19/04/2017.
 */
public class ComunClienteTest extends CamelSpringTestSupport{
    private static final Logger logger = LoggerFactory.getLogger(ComunClienteTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-cliente-test.xml");
    }

    @Test
    public void probarServicioFecha() throws IsspolException{
        ComunServicio comunServicio =context.getRegistry().lookupByNameAndType("comunServicio",ComunServicio.class);
        HashMap<String,Object> in=new HashMap<>();
        PeticionRespuesta peticionRespuesta=new PeticionRespuesta(IsspolConstant.METHOD_PROC_FECHAHORASISTEMA,new Object[]{in});
        peticionRespuesta=comunServicio.callRemoteService(peticionRespuesta);
        Map<String,Object>respuesta= (Map<String, Object>) peticionRespuesta.getResullt();
//        Assert.assertNotNull(respuesta);
        logger.info("{}",respuesta);
//        Assert.assertNotNull(respuesta);
        for (Map.Entry<String, Object> entry : respuesta.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    @Test
    public void testInsertarLogNotificacion() throws IsspolException {
        LogNotificacion logNotificacion = new LogNotificacion();
        logNotificacion.setNotificado(Boolean.FALSE);
        logNotificacion.setCorreo("Hola mundo");
        ComunServicio comunServicio =context.getRegistry().lookupByNameAndType("comunServicio",ComunServicio.class);
        PeticionRespuesta isspolMessage = new PeticionRespuesta();
//        isspolMessage.setMethod(IsspolConstant.METHOD_INSERTAR_LOG_NOTIFICACION_CODIGO_PROCESO);
        isspolMessage.setParameters(new Object[]{logNotificacion, IsspolConstant.PROCESO_NOT_CAMBIO_CONTRASENA});
        isspolMessage = comunServicio.callRemoteService(isspolMessage);
        logger.info("Guardado {}", logNotificacion);
    }

    @Test
    @Ignore
    public void testListarEstado() throws IsspolException {
        ComunServicio comunServicio = context.getRegistry().lookupByNameAndType("comunServicio", ComunServicio.class);
        List<Estado> estados = null;
        logger.info("Llamando al método testListarEstado ==> {} ", IsspolConstant.METODO_LISTAR_ESTADOS);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_ESTADOS);
        peticionRespuesta.setParameters(new Object[]{});
        peticionRespuesta = comunServicio.callRemoteService(peticionRespuesta);
        estados = (List<Estado>) peticionRespuesta.getResullt();
        for (Estado estado : estados) {
            logger.info("ID: {}", estado.getIdEstado());
            logger.info("Nombre: {}", estado.getDescripcion());
        }
    }
}
