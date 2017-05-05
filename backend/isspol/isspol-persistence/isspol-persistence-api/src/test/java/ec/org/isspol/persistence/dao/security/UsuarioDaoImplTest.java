package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;
import ec.org.isspol.persistence.entities.security.Horario;
import ec.org.isspol.persistence.entities.security.Usuario;
import ec.org.isspol.persistence.service.security.EstadoUsuarioSvc;
import ec.org.isspol.persistence.service.security.HorarioSvc;
import ec.org.isspol.persistence.service.security.UsuarioSvc;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.*;

/**
 * Created by mauchilan on 21/3/17.
 */
public class UsuarioDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }


    @Test
    public  void bucarUsuarioPorId() throws IsspolSearchException{
        UsuarioSvc usuarioSvc = (UsuarioSvc) getBean("usuarioSvc");
        Usuario usuario = usuarioSvc.buscarUsuarioxId("afierro");
        System.out.println(usuario);


    };

    @Test
    @Ignore
    public void testCrudUsuario() throws IsspolSearchException, IsspolPersistException {
        UsuarioSvc usuarioSvc = (UsuarioSvc) getBean("usuarioSvc");
        EstadoUsuarioSvc estadoUsuarioSvc = (EstadoUsuarioSvc) getBean("estadoUsuarioSvc");
        HorarioSvc horarioSvc = (HorarioSvc) getBean("horarioSvc");
        EstructuraOrganizacionalDao estructuraOrganizacionalDao = (EstructuraOrganizacionalDao) getBean("estructuraOrganizacionalDao");
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("psalgado");
        EstadoUsuario estadoUsuario = estadoUsuarioSvc.buscarPorCriterio(Restrictions.eq("idEstadoUsuario",1));
        usuario.setEstadoUsuario(estadoUsuario);
        Horario horario = horarioSvc.buscarPorCriterio(Restrictions.eq("idHorario", 1));
        usuario.setHorario(horario);
        usuario.setBloqueada(false);
        usuario.setCambiarPwdProximoLogon(false);
        usuario.setCualquierEstacion(false);
        usuario.setNoPuedeCambiarPwd(false);
        usuario.setPwdNuncaExpira(false);
        usuario.setTiempoInactividad(1);
        usuario.setUsuarioSecuencial(1);
        usuario.setIdDashboardInicio(1);
        usuario.setEliminado(Boolean.FALSE);
        usuario.setCreacionUsuario("psalgado");
        usuario.setCreacionEquipo("equipo");
        usuario.setCreacionFecha(new Timestamp(new Date().getTime()));
        usuario.setModificaUsuario("psalgado");
        usuario.setModificaEquipo("equipo");
        usuario.setModificaFecha(new Timestamp(new Date().getTime()));
        EstructuraOrganizacional estructuraOrganizacional = estructuraOrganizacionalDao.buscarPorCriterio(Restrictions.eq("id", 1));
        usuario.setEstructuraOrganizacional(estructuraOrganizacional);
        logger.info("Creating user {}", usuario.getIdUsuario());
        usuarioSvc.insertarUsuario(usuario);
        usuario = usuarioSvc.buscarPorIdUsuario("psalgado");
        logger.info("Reading user {}", usuario.getIdUsuario());
        usuario.setEmail("correo@correo.com");
        logger.info("Updating user {} with value {}", usuario.getIdUsuario(), usuario.getEmail());
        usuarioSvc.actualizarUsuario(usuario);
        logger.info("Deleting user {}", usuario.getIdUsuario());
        usuarioSvc.eliminarUsuario(usuario);
    }

    @Test
    public void obtenerUsuarioPorId() throws IsspolSearchException {
        UsuarioSvc usuarioSvc = (UsuarioSvc) getBean("usuarioSvc");
        Usuario usuario=usuarioSvc.buscarPorIdUsuario("afierro");
        logger.info("Reading user {}", usuario.getIdUsuario());
        Assert.assertNotNull(usuario);
    }

    @Test
    public void testGetAllUsuario() throws IsspolSearchException {
        UsuarioSvc usuarioSvc = (UsuarioSvc) getBean("usuarioSvc");
        List<Usuario> usuarios = usuarioSvc.listarUsuario();
        for (Usuario usuario: usuarios){
            logger.info("User: {} {} {}", usuario.getIdUsuario(), usuario.getEmail(), usuario.getCreacionFecha());
        }
        Assert.assertNotNull(usuarios);
    }

    @Test
    public void testProcUsuarioActualizar() throws IsspolException, IsspolPersistException {
        UsuarioSvc usuarioSvc = (UsuarioSvc) getBean("usuarioSvc");
        HashMap<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USU_USUARIO, "jlopez");
        in.put(IsspolConstant.AI_ID_OFICINA, 1);
        in.put(IsspolConstant.AI_ESTADO, 1);
        in.put(IsspolConstant.AS_EMAIL, "prueba3@mail.com");
        in.put(IsspolConstant.AB_CAMBIAR_PWD_PRX_LOGON, Boolean.TRUE);
        in.put(IsspolConstant.AB_NO_PUEDE_CAMBIAR_PWD, Boolean.TRUE);
        in.put(IsspolConstant.AB_PWD_NUNCA_EXPIRA, Boolean.TRUE);
        in.put(IsspolConstant.AB_BLOQUEADA, Boolean.TRUE);
        in.put(IsspolConstant.AI_ID, 1);
        in.put(IsspolConstant.AS_IDENTIFICACION, "1725252525");
        in.put(IsspolConstant.AB_CUALQUIER_ESTACION, Boolean.TRUE);
        in.put(IsspolConstant.AI_TIEMPO_INACTIVIDAD, 6000);
        in.put(IsspolConstant.AS_USUARIO_ACT, "test");
        in.put(IsspolConstant.AS_DIRECCION_FISICA, "test");
        in.put(IsspolConstant.AI_ID_HORARIO, 1);
        in.put(IsspolConstant.AI_ID_ESTRUCTURA, 1);
        in.put(IsspolConstant.AS_USUARIO_SUPERIOR, null);
        in.put(IsspolConstant.AI_ID_DASHBOARD_INICIO, 1);
        Map<String, Object> result = usuarioSvc.procUsuarioActualizar(in);
        Assert.assertNotNull(result);
        logger.info("{}",result);
        Assert.assertNotNull(result);
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

    }

    @Test
    public void testValidaClaveUsuarioSP() throws IsspolException, IsspolPersistException {
        UsuarioSvc usuarioSvc = (UsuarioSvc) getBean("usuarioSvc");
        HashMap<String, Object> in = new HashMap<>();

        in.put(IsspolConstant.AS_USU_USUARIO,"1");
        in.put(IsspolConstant.AB_VALIDA_HOSTNAME,0);
        in.put(IsspolConstant.AS_HOSTNAME,"BDD");
        in.put(IsspolConstant.AS_CLAVE,"123456");
        in.put(IsspolConstant.AS_USUARIO, "jnunez");
        in.put(IsspolConstant.AD_FECHA,new Date());
        in.put(IsspolConstant.AS_EQUIPO,new Date());
        in.put(IsspolConstant.AI_USUARIO,0);

        Map<String, Object> result = usuarioSvc.validarClaveUsuario(in);
        Assert.assertNotNull(result);
        logger.info("{}",result);
        Assert.assertNotNull(result);
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    @Test
    public void testUsuarioObtenerInformacionSesion() throws IsspolException, IsspolPersistException {
        UsuarioSvc usuarioSvc = (UsuarioSvc) getBean("usuarioSvc");
        HashMap<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USUARIO,"carauz");

        Map<String, Object> result = usuarioSvc.obtenerInformacionSesion(in);
        Assert.assertNotNull(result);
        logger.info("{}",result);
        Assert.assertNotNull(result);
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    @Test
    public void testFavoritosLista() throws IsspolException, IsspolPersistException {
        UsuarioSvc usuarioSvc = (UsuarioSvc) getBean("usuarioSvc");
        HashMap<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USUARIO,"carauz");

        SqlParameter[] sqlParameters=new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_USUARIO,Types.VARCHAR)
        };

        Map<String, Object> result = usuarioSvc.obtenerListaFavoritos(in);
        Assert.assertNotNull(result);
        logger.info("{}",result);
        Assert.assertNotNull(result);
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    @Test
    public void testProcUsuarioSolicitudCambioClave() throws IsspolException, IsspolPersistException {
        UsuarioSvc usuarioSvc = (UsuarioSvc) getBean("usuarioSvc");

        HashMap<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_CORREO, "afierro@isspol.org.ec");
        in.put(IsspolConstant.AS_DATO, Util.generarToken("jnunez"));
        in.put(IsspolConstant.AS_CODIGO_TIPO_TOKEN, IsspolConstant.TIPO_TOKEN_CAMBIO_CONTRASENA);
        in.put(IsspolConstant.AS_CODIGO_PROCESO_NOTIFICACION, IsspolConstant.PROCESO_NOT_CAMBIO_CONTRASENA);
        in.put(IsspolConstant.AS_USUARIO, "jnunez");
        in.put(IsspolConstant.AD_FECHA, new Date());
        in.put(IsspolConstant.AS_EQUIPO, "local");

        Map<String, Object> result = usuarioSvc.procUsuarioSolicitudCambioClave(in);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result);
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

    }
}
