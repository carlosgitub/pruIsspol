package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.CarpetaOpcion;
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
public class CarpetaOpcionDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(CarpetaOpcionDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void testCrudCarpetaOpcion() throws IsspolSearchException, IsspolPersistException {
        CarpetaOpcionSvc carpetaOpcionSvc = (CarpetaOpcionSvc) getBean("carpetaOpcionSvc");
        IconoSvc iconoSvc = (IconoSvc) getBean("iconoSvc");
        CarpetaOpcion carpetaOpcion = new CarpetaOpcion();
        logger.info("CRUD Seguridad.CarpetaOpcion");
        carpetaOpcion.setNombre("Prueba");
        carpetaOpcion.setIcono(iconoSvc.buscarIconoPorId(1));
        carpetaOpcion.setOrden(2);
        carpetaOpcion.setVisible(Boolean.TRUE);
        carpetaOpcion.setCreacionUsuario("test");
        carpetaOpcion.setCreacionFecha(new Date());
        carpetaOpcion.setCreacionEquipo("test");
        carpetaOpcion.setModificaUsuario("test");
        carpetaOpcion.setModificaFecha(new Date());
        carpetaOpcion.setModificaEquipo("test");
        carpetaOpcionSvc.insertarCarpetaOpcion(carpetaOpcion);
        logger.info("Insertar Seguridad.CarpetaOpcion {}", carpetaOpcion.getIdCarpetaOpcion());
        carpetaOpcion = carpetaOpcionSvc.buscarCarpetaOpcionPorId(carpetaOpcion.getIdCarpetaOpcion());
        logger.info("Buscar Seguridad.CarpetaOpcion {}", carpetaOpcion.getNombre());
        carpetaOpcion.setNombre("PruebaMod");
        carpetaOpcionSvc.actualizarCarpetaOpcion(carpetaOpcion);
        logger.info("Actualizar Seguridad.CarpetaOpcion {}", carpetaOpcion.getNombre());
        carpetaOpcionSvc.eliminarCarpetaOpcion(carpetaOpcion);
        logger.info("Eliminar Seguridad.CarpetaOpcion");
    }

    @Test
    public void testListarTodosCarpetaOpcion() throws IsspolSearchException {
        CarpetaOpcionSvc carpetaOpcionSvc = (CarpetaOpcionSvc) getBean("carpetaOpcionSvc");
        List<CarpetaOpcion> opcions = carpetaOpcionSvc.listarTodosCarpetaOpcion();
        for (CarpetaOpcion opcion : opcions) {
            logger.info("CarpetaOpcion {} --> {}", opcion.getIdCarpetaOpcion(), opcion.getNombre());
        }
        Assert.assertNotNull(opcions);
    }

}
