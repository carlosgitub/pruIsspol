package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.Estacion;
import ec.org.isspol.persistence.entities.security.EstacionUsuario;
import ec.org.isspol.persistence.entities.security.Usuario;
import ec.org.isspol.persistence.service.security.EstacionUsuarioSvc;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by mavelin.ati on 18/04/2017.
 */
public class EstacionUsuarioDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(EstacionUsuarioDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void insertarEstacionUsuario() throws IsspolPersistException {
        EstacionUsuarioSvc estacionUsuarioSvc = (EstacionUsuarioSvc) getBean("estacionUsuarioSvc");

        Estacion estacion = new Estacion();
        estacion.setIdEstacion(13);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jnunez");

        EstacionUsuario estUsuario = new EstacionUsuario();
        estUsuario.setEstacion(estacion);
        estUsuario.setUsuario(usuario);

        estUsuario.setEliminado(false);
        estUsuario.setCreacionUsuario("Administrador");
        estUsuario.setCreacionFecha(new Date());
        estUsuario.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        estUsuario.setModificaUsuario("Administrador");
        estUsuario.setModificaFecha(new Date());
        estUsuario.setModificaEquipo("30-E3-7A-2D-9A-7D");

        estacionUsuarioSvc.insertarEstacionUsuario(estUsuario);
    }

    @Test
    public void actualizarEstacionUsuario() throws IsspolPersistException {
        EstacionUsuarioSvc estacionUsuarioSvc = (EstacionUsuarioSvc) getBean("estacionUsuarioSvc");

        Estacion estacion = new Estacion();
        estacion.setIdEstacion(11);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jnunez");

        EstacionUsuario estUsuario = new EstacionUsuario();
        estUsuario.setIdEstacionUsuario(2);
        estUsuario.setEstacion(estacion);
        estUsuario.setUsuario(usuario);

        estUsuario.setEliminado(false);
        estUsuario.setCreacionUsuario("Administrador");
        estUsuario.setCreacionFecha(new Date());
        estUsuario.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        estUsuario.setModificaUsuario("Administrador");
        estUsuario.setModificaFecha(new Date());
        estUsuario.setModificaEquipo("30-E3-7A-2D-9A-7D");

        estacionUsuarioSvc.actualizarEstacionUsuario(estUsuario);
    }

    @Test
    public void listarTodosEstacionUsuario() throws IsspolSearchException {
        EstacionUsuarioSvc estacionUsuarioSvc = (EstacionUsuarioSvc) getBean("estacionUsuarioSvc");

        List<EstacionUsuario> estacionUsuarios = estacionUsuarioSvc.listarTodosEstacionUsuario();
        for (EstacionUsuario estacionUsuario: estacionUsuarios){
            logger.info("EstacionUsuario {} --> {}",
                    "IdEstacionUsuario: " + estacionUsuario.getIdEstacionUsuario(),
                    "IdUsuario: " + estacionUsuario.getUsuario().getIdUsuario());
        }
        Assert.assertNotNull(estacionUsuarios);
    }

    @Test
    public void buscarEstacionUsuarioPorId() throws IsspolSearchException {
        EstacionUsuarioSvc estacionUsuarioSvc = (EstacionUsuarioSvc) getBean("estacionUsuarioSvc");
        Integer id = 2;
        EstacionUsuario estacionUsuario = estacionUsuarioSvc.buscarEstacionUsuarioPorId(id);
        logger.info("EstacionUsuario {} --> {}",
                "IdEstacionUsuario: " + estacionUsuario.getIdEstacionUsuario(),
                "IdUsuario: " + estacionUsuario.getUsuario().getIdUsuario());
    }

    @Test
    public void listarEstacionUsuarioPorUsuario() throws IsspolSearchException {
        EstacionUsuarioSvc estacionUsuarioSvc = (EstacionUsuarioSvc) getBean("estacionUsuarioSvc");
        String idUsuario = "jnunez";
        List<EstacionUsuario> estacionUsuarios = estacionUsuarioSvc.listarEstacionUsuarioPorUsuario(idUsuario);
        for (EstacionUsuario estacionUsuario: estacionUsuarios){
            logger.info("EstacionUsuario {} --> {}",
                    "IdEstacionUsuario: " + estacionUsuario.getIdEstacionUsuario(),
                    "IdUsuario: " + estacionUsuario.getUsuario().getIdUsuario());
        }
        Assert.assertNotNull(estacionUsuarios);
    }

    @Test
    public void testListarEstacionUsuarioNoEliminadoPorUsuario() throws IsspolSearchException{
        EstacionUsuarioSvc estacionUsuarioSvc = (EstacionUsuarioSvc) getBean("estacionUsuarioSvc");

        PagedResult<EstacionUsuario> pagedResult = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);/*0: inicia el paginado, visualiza los primeros 3 registros de la lista*/
        filterParam.setItemsPerPage(2);
        String idUsuario = "jlopez";
        pagedResult =  estacionUsuarioSvc.listarEstacionUsuarioNoEliminadoPorUsuario(idUsuario, filterParam);
        for (EstacionUsuario estacionUsuario : (List<EstacionUsuario>)pagedResult.getItems()){
            logger.info("Resultado {},{}",
                    "IdEstacionUsuario: " + estacionUsuario.getIdEstacionUsuario(),
                    "IdUsuario: " + estacionUsuario.getUsuario().getIdUsuario());
        }
    }

}
