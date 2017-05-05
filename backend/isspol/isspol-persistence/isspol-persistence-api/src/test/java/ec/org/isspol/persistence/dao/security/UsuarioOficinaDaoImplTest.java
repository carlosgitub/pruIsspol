package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.*;
import ec.org.isspol.persistence.service.security.UsuarioOficinaSvc;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by mavelin.ati on 05/05/2017.
 */

public class UsuarioOficinaDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioOficinaDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void insertarUsuarioOficina() throws IsspolPersistException {
        UsuarioOficinaSvc usuarioOficinaSvc = (UsuarioOficinaSvc) getBean("usuarioOficinaSvc");

        Oficina oficina = new Oficina();
        oficina.setIdOficina(1);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jnunez");

        UsuarioOficina usuarioOf = new UsuarioOficina();
        usuarioOf.setOficina(oficina);
        usuarioOf.setUsuario(usuario);

        usuarioOf.setEliminado(false);
        usuarioOf.setCreacionUsuario("Administrador");
        usuarioOf.setCreacionFecha(new Date());
        usuarioOf.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        usuarioOf.setModificaUsuario("Administrador");
        usuarioOf.setModificaFecha(new Date());
        usuarioOf.setModificaEquipo("30-E3-7A-2D-9A-7D");

        usuarioOficinaSvc.insertarUsuarioOficina(usuarioOf);
    }

    @Test
    public void actualizarUsuarioOficina() throws IsspolPersistException {
        UsuarioOficinaSvc usuarioOficinaSvc = (UsuarioOficinaSvc) getBean("usuarioOficinaSvc");

        Oficina oficina = new Oficina();
        oficina.setIdOficina(1);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jnunez");

        UsuarioOficina usuarioOf = new UsuarioOficina();
        usuarioOf.setIdUsuarioOficina(2);
        usuarioOf.setOficina(oficina);
        usuarioOf.setUsuario(usuario);

        usuarioOf.setEliminado(false);
        usuarioOf.setCreacionUsuario("Administrador");
        usuarioOf.setCreacionFecha(new Date());
        usuarioOf.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        usuarioOf.setModificaUsuario("Administrador");
        usuarioOf.setModificaFecha(new Date());
        usuarioOf.setModificaEquipo("30-E3-7A-2D-9A-7D");

        usuarioOficinaSvc.actualizarUsuarioOficina(usuarioOf);
    }

    @Test
    public void listarTodosUsuarioOficina() throws IsspolSearchException {
        UsuarioOficinaSvc usuarioOficinaSvc = (UsuarioOficinaSvc) getBean("usuarioOficinaSvc");

        List<UsuarioOficina> usuarioOficinas = usuarioOficinaSvc.listarTodosUsuarioOficina();
        for (UsuarioOficina usuarioOficina: usuarioOficinas){
            logger.info("UsuarioOficina {} --> {}",
                    "IdUsuarioOficina: " + usuarioOficina.getIdUsuarioOficina(),
                    "IdUsuario: " + usuarioOficina.getUsuario().getIdUsuario());
        }
        Assert.assertNotNull(usuarioOficinas);
    }

    @Test
    public void buscarUsuarioOficinaPorId() throws IsspolSearchException {
        UsuarioOficinaSvc usuarioOficinaSvc = (UsuarioOficinaSvc) getBean("usuarioOficinaSvc");
        Integer id = 2;
        UsuarioOficina usuarioOficina = usuarioOficinaSvc.buscarUsuarioOficinaPorId(id);
        logger.info("UsuarioOficina {} --> {}",
                "IdUsuarioOficina: " + usuarioOficina.getIdUsuarioOficina(),
                "IdUsuario: " + usuarioOficina.getUsuario().getIdUsuario());
    }

    @Test
    public void listarUsuarioOficinaPorUsuario() throws IsspolSearchException {
        UsuarioOficinaSvc usuarioOficinaSvc = (UsuarioOficinaSvc) getBean("usuarioOficinaSvc");
        String idUsuario = "jnunez";
        List<UsuarioOficina> usuarioOficinas = usuarioOficinaSvc.listarUsuarioOficinaPorUsuario(idUsuario);
        for (UsuarioOficina usuarioOficina: usuarioOficinas){
            logger.info("UsuarioOficina {} --> {}",
                    "IdUsuarioOficina: " + usuarioOficina.getIdUsuarioOficina(),
                    "IdUsuario: " + usuarioOficina.getUsuario().getIdUsuario());
        }
        Assert.assertNotNull(usuarioOficinas);
    }

    @Test
    public void testListarUsuarioOficinaNoEliminadoPorUsuario() throws IsspolSearchException{
        UsuarioOficinaSvc usuarioOficinaSvc = (UsuarioOficinaSvc) getBean("usuarioOficinaSvc");

        PagedResult<UsuarioOficina> pagedResult = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);/*0: inicia el paginado, visualiza los primeros 3 registros de la lista*/
        filterParam.setItemsPerPage(2);
        String idUsuario = "jlopez";
        pagedResult =  usuarioOficinaSvc.listarUsuarioOficinaNoEliminadoPorUsuario(idUsuario, filterParam);
        for (UsuarioOficina usuarioOficina : (List<UsuarioOficina>)pagedResult.getItems()){
            logger.info("Resultado {},{}",
                    "IdUsuarioOficina: " + usuarioOficina.getIdUsuarioOficina(),
                    "IdUsuario: " + usuarioOficina.getUsuario().getIdUsuario());
        }
    }

    @Test
    public void testObtenerOficinasPorUsuario() throws IsspolSearchException {
        UsuarioOficinaSvc usuarioOficinaSvc = (UsuarioOficinaSvc) getBean("usuarioOficinaSvc");
        List<UsuarioOficina> usuarioOficina = new ArrayList<>();
        usuarioOficina= usuarioOficinaSvc.listarUsuarioOficinaPorUsuario("jnunez");
        for(UsuarioOficina uo:usuarioOficina){
            logger.info("usuario: {}",uo.getUsuario().getIdUsuario());
            logger.info("oficina: {}",uo.getOficina().getIdOficina());
        }
    }

}
