package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.Opcion;
import ec.org.isspol.persistence.service.security.CarpetaOpcionSvc;
import ec.org.isspol.persistence.service.security.IconoSvc;
import ec.org.isspol.persistence.service.security.OpcionSvc;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by paul.salgado on 18/04/2017.
 */
public class OpcionDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(OpcionDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void testCrudOpcion() throws IsspolSearchException, IsspolPersistException {
        OpcionSvc opcionSvc = (OpcionSvc) getBean("opcionSvc");
        CarpetaOpcionSvc carpetaOpcionSvc = (CarpetaOpcionSvc) getBean("carpetaOpcionSvc");
        IconoSvc iconoSvc = (IconoSvc) getBean("iconoSvc");
        Opcion opcion = new Opcion();
        logger.info("CRUD Seguridad.Opcion");
        opcion.setNombre("Prueba");
        opcion.setCarpetaOpcion(carpetaOpcionSvc.buscarCarpetaOpcionPorId(9));
        opcion.setIcono(iconoSvc.buscarIconoPorId(1));
        opcion.setObjeto("objeto");
        opcion.setOrden(2);
        opcion.setTipoAbrir("SH");
        opcion.setVisible(Boolean.TRUE);
        opcion.setCreacionUsuario("test");
        opcion.setCreacionFecha(new Date());
        opcion.setCreacionEquipo("test");
        opcion.setModificaUsuario("test");
        opcion.setModificaFecha(new Date());
        opcion.setModificaEquipo("test");
        opcionSvc.insertarOpcion(opcion);
        logger.info("Insertar Seguridad.Opcion {}", opcion.getIdOpcion());
        opcion = opcionSvc.buscarOpcionPorId(opcion.getIdOpcion());
        logger.info("Buscar Seguridad.Opcion {}", opcion.getNombre());
        opcion.setNombre("PruebaMod");
        opcionSvc.actualizarOpcion(opcion);
        logger.info("Actualizar Seguridad.Opcion {}", opcion.getNombre());
        opcionSvc.eliminarOpcion(opcion);
        logger.info("Eliminar Seguridad.Opcion");
    }

    @Test
    public void testListarTodosOpcion() throws IsspolSearchException {
        OpcionSvc opcionSvc = (OpcionSvc) getBean("opcionSvc");
        List<Opcion> opcions = opcionSvc.listarTodosOpcion();
        for (Opcion opcion : opcions) {
            logger.info("Opcion {} --> {}", opcion.getIdOpcion(), opcion.getNombre());
        }
        Assert.assertNotNull(opcions);
    }

}
