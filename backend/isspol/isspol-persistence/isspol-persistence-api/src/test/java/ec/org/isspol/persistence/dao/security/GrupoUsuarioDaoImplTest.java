package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.Grupo;
import ec.org.isspol.persistence.entities.security.GrupoUsuario;
import ec.org.isspol.persistence.entities.security.Usuario;
import ec.org.isspol.persistence.service.security.GrupoUsuarioSvc;
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
public class GrupoUsuarioDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(GrupoUsuarioDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void insertarGrupoUsuario() throws IsspolPersistException {
        GrupoUsuarioSvc grupoUsuarioSvc = (GrupoUsuarioSvc) getBean("grupoUsuarioSvc");

        Grupo grupo = new Grupo();
        grupo.setIdGrupo(4);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jnunez");

        GrupoUsuario grupoUsuario = new GrupoUsuario();
        grupoUsuario.setGrupo(grupo);
        grupoUsuario.setUsuario(usuario);

        grupoUsuario.setEstado(1);
        grupoUsuario.setTieneVencimiento(false);
        grupoUsuario.setFechaVencimiento(new Date());

        grupoUsuario.setEliminado(false);
        grupoUsuario.setCreacionUsuario("Administrador");
        grupoUsuario.setCreacionFecha(new Date());
        grupoUsuario.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        grupoUsuario.setModificaUsuario("Administrador");
        grupoUsuario.setModificaFecha(new Date());
        grupoUsuario.setModificaEquipo("30-E3-7A-2D-9A-7D");

        grupoUsuarioSvc.insertarGrupoUsuario(grupoUsuario);
    }

    @Test
    public void actualizarGrupoUsuario() throws IsspolPersistException {
        GrupoUsuarioSvc grupoUsuarioSvc = (GrupoUsuarioSvc) getBean("grupoUsuarioSvc");

        Grupo grupo = new Grupo();
        grupo.setIdGrupo(1);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jnunez");

        GrupoUsuario grupoUsuario = new GrupoUsuario();
        grupoUsuario.setGrupo(grupo);
        grupoUsuario.setUsuario(usuario);
        grupoUsuario.setIdGrupoUsuario(1);

        grupoUsuario.setEstado(1);
        grupoUsuario.setTieneVencimiento(false);
        grupoUsuario.setFechaVencimiento(new Date());

        grupoUsuario.setEliminado(false);
        grupoUsuario.setCreacionUsuario("Administrador");
        grupoUsuario.setCreacionFecha(new Date());
        grupoUsuario.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        grupoUsuario.setModificaUsuario("Administrador");
        grupoUsuario.setModificaFecha(new Date());
        grupoUsuario.setModificaEquipo("30-E3-7A-2D-9A-7D");

        grupoUsuarioSvc.actualizarGrupoUsuario(grupoUsuario);
    }

    @Test
    public void listarTodosGrupoUsuario() throws IsspolSearchException {
        GrupoUsuarioSvc grupoUsuarioSvc = (GrupoUsuarioSvc) getBean("grupoUsuarioSvc");

        List<GrupoUsuario> grupoUsuarios = grupoUsuarioSvc.listarTodosGrupoUsuario();
        for (GrupoUsuario grupoUsuario: grupoUsuarios){
            logger.info("GrupoUsuario {} --> {}",
                    "IdGrupoUsuario: " + grupoUsuario.getIdGrupoUsuario(),
                    "IdGrupo: " + grupoUsuario.getGrupo().getIdGrupo(),
                    "IdUsuario: " + grupoUsuario.getUsuario().getIdUsuario());
        }
        Assert.assertNotNull(grupoUsuarios);
    }

    @Test
    public void buscarGrupoUsuarioPorId() throws IsspolSearchException {
        GrupoUsuarioSvc grupoUsuarioSvc = (GrupoUsuarioSvc) getBean("grupoUsuarioSvc");
        Integer id = 1;
        GrupoUsuario grupoUsuario = grupoUsuarioSvc.buscarGrupoUsuarioPorId(id);
        logger.info("GrupoUsuario {} --> {}",
                "IdGrupoUsuario: " + grupoUsuario.getIdGrupoUsuario(),
                "IdGrupo: " + grupoUsuario.getGrupo().getIdGrupo(),
                "IdUsuario: " + grupoUsuario.getUsuario().getIdUsuario());
    }

    @Test
    public void listarGrupoUsuarioPorUsuario() throws IsspolSearchException {
        GrupoUsuarioSvc grupoUsuarioSvc = (GrupoUsuarioSvc) getBean("grupoUsuarioSvc");
        String idUsuario = "jnunez";
        List<GrupoUsuario> grupoUsuarios = grupoUsuarioSvc.listarGrupoUsuarioPorUsuario(idUsuario);
        for (GrupoUsuario grupoUsuario: grupoUsuarios){
            logger.info("GrupoUsuario {} --> {}",
                    "IdGrupoUsuario: " + grupoUsuario.getIdGrupoUsuario(),
                    "IdGrupo: " + grupoUsuario.getGrupo().getIdGrupo(),
                    "IdUsuario: " + grupoUsuario.getUsuario().getIdUsuario());
        }
        Assert.assertNotNull(grupoUsuarios);
    }

    @Test
    public void testListarGrupoUsuarioNoEliminadoPorUsuario() throws IsspolSearchException{
        GrupoUsuarioSvc grupoUsuarioSvc = (GrupoUsuarioSvc) getBean("grupoUsuarioSvc");

        PagedResult<GrupoUsuario> pagedResult = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);/*0: inicia paginado, visualiza los primeros n registros de la lista*/
        filterParam.setItemsPerPage(2);
        String idUsuario = "jnunez";
        pagedResult =  grupoUsuarioSvc.listarGrupoUsuarioNoEliminadoPorUsuario(idUsuario, filterParam);
        for (GrupoUsuario grupoUsuario : (List<GrupoUsuario>)pagedResult.getItems()){
            logger.info("Resultado GrupoUsuario; {},{}",
                    "IdGrupoUsuario: " + grupoUsuario.getIdGrupoUsuario(),
                    "IdGrupo: " + grupoUsuario.getGrupo().getIdGrupo(),
                    "IdUsuario: " + grupoUsuario.getUsuario().getIdUsuario());
        }
    }

}
