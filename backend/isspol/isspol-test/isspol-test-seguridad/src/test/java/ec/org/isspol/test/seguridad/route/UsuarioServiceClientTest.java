package ec.org.isspol.test.seguridad.route;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.security.Grupo;

import ec.org.isspol.persistence.entities.security.Usuario;
import ec.org.isspol.route.security.service.IAfiliacionServiceBean;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by carlos.calo on 05/04/2017.
 */
public class UsuarioServiceClientTest extends CamelSpringTestSupport {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceClientTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
    }

    @Test
    public void testProcEstructuraOrganizacional() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);

        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_CODIGO, "22");
        in.put(IsspolConstant.AS_DESCRIPCION , "5877887");
        in.put(IsspolConstant.AI_ORDEN, 1);
        in.put(IsspolConstant.AI_NIVEL, 1);
        in.put(IsspolConstant.AS_USUARIO, "455");
        in.put(IsspolConstant.AI_ID_ESTRUCTURA_PADRE, null);
        in.put(IsspolConstant.AS_USUARIO_ACT, "SYACELGA");

        PeticionRespuesta isspolMessage = new PeticionRespuesta(IsspolConstant.METHOD_PROC_ESTRUCTURA_ORGANIZACIONAL_GUARDAR, new Object[]{in});
        Map<String, Object> result = (Map<String, Object>)usuarioService.callRemoteService(isspolMessage);

    }

    @Test
    public void testProcUsuarioActualizar() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USUARIO, "candresc");
        in.put(IsspolConstant.AS_NOMBRE, "Carlos A Cordova L");
        in.put(IsspolConstant.AI_ESTADO, 1);
        in.put(IsspolConstant.AS_EMAIL, "candresc@prueba.com.ec");
        in.put(IsspolConstant.AB_CAMBIAR_PWD_PRX_LOGON, Boolean.FALSE);
        in.put(IsspolConstant.AB_NO_PUEDE_CAMBIAR_PWD, Boolean.FALSE);
        in.put(IsspolConstant.AB_PWD_NUNCA_EXPIRA, Boolean.TRUE);
        in.put(IsspolConstant.AB_BLOQUEADA, Boolean.FALSE);
        in.put(IsspolConstant.AI_ID, 12);
        in.put(IsspolConstant.AS_IDENTIFICACION, "1001514866");
        in.put(IsspolConstant.AB_CUALQUIER_ESTACION, Boolean.TRUE);
        in.put(IsspolConstant.AI_TIEMPO_INACTIVIDAD, 60000);
        in.put(IsspolConstant.AS_USUARIO_ACT, "ADMIN");
        in.put(IsspolConstant.AI_ID_HORARIO, 1);
        in.put(IsspolConstant.AI_ID_ESTRUCTURA, 10);
        in.put(IsspolConstant.AS_USUARIO_SUPERIOR, null);
        in.put(IsspolConstant.AI_ID_DASHBOARD_INICIO, 1);

        PeticionRespuesta peticionRespuesta = new PeticionRespuesta(IsspolConstant.PROC_USUARIO_ACTUALIZAR, new Object[]{in});
        Map<String, Object> result = (Map<String, Object>)usuarioService.callRemoteService(peticionRespuesta);
        Assert.assertNotNull(result);
        logger.info("{}",result);
        Assert.assertNotNull(result);
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

    }
    
    /**
     * Métodos para administrar Grupo(Rol) by EA, Fecha: 2017-04-13
     */
    @Test
    @Ignore
    public void testInsertarGrupo() throws IsspolException {

        Grupo grupo = new Grupo();
        grupo.setNombre("ISSPOL-1");
        grupo.setCreacionUsuario("EA");
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        grupo.setCreacionFecha(ts);
        grupo.setCreacionEquipo("PC-EA");
        grupo.setModificaUsuario("EA");
        grupo.setModificaFecha(ts);
        grupo.setModificaEquipo("PC-MODIFICA-TEST");
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        logger.info("calling methodo insertarGrupo for insert {} ", grupo);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_INSERTAR_ACTUALIZAR_GRUPO);
        message.setParameters(new Object[]{grupo});
        logger.info("INSERTANDO {}");
        usuarioService.callRemoteService(message);
    }

    @Test
    @Ignore
    public void testBuscarGrupoPorId() throws IsspolException {
        Integer idGrupo = 3;
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Grupo grupo = new Grupo();
        logger.info("calling method buscarGrupoPorId ID ==> {} ", idGrupo);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_BUSCAR_GRUPO_POR_ID);
        message.setParameters(new Object[]{idGrupo});
        message = usuarioService.callRemoteService((message));
        grupo = (Grupo) message.getResullt();
        logger.info("ID: {}", grupo.getIdGrupo());
        logger.info("NOMBRE: {}", grupo.getNombre());
        //return grupo;
    }

    @Test
    public void   buscarUsuarioXId () throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Usuario usuario = new Usuario ();
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_BUSCAR_USUARIO_X_ID);
        message.setParameters(new Object[]{"jnunez"});
        message = usuarioService.callRemoteService((message));
        usuario = (Usuario) message.getResullt();
        System.out.println(usuario.getIdUsuario());

    }

    @Test
    @Ignore
    public void testActualizarGrupo() throws IsspolException {
        Integer idGrupo = 1;
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Grupo grupo = new Grupo();
        logger.info("calling method buscarGrupoPorId ID ==> {} ", idGrupo);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_BUSCAR_GRUPO_POR_ID);
        message.setParameters(new Object[]{idGrupo});
        message = usuarioService.callRemoteService((message));
        grupo = (Grupo) message.getResullt();
        logger.info("ID: {}", grupo.getIdGrupo());
        logger.info("NOMBRE: {}", grupo.getNombre());

        UsuarioService usuarioService1 = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);


        logger.info("Grupo a actualizar; ID: {}", grupo.getIdGrupo());
        logger.info("Grupo a actualizar; Nombre: {}", grupo.getNombre());
        logger.info("Llamando al método actualizarGrupo ==> {} ", IsspolConstant.METODO_INSERTAR_ACTUALIZAR_GRUPO);
        grupo.setNombre("ISSPOL-ACTUALIZADO");
        PeticionRespuesta message1 = new PeticionRespuesta();
        message1.setMethod(IsspolConstant.METODO_INSERTAR_ACTUALIZAR_GRUPO);
        message1.setParameters(new Object[]{grupo});
        usuarioService1.callRemoteService(message1);
    }

    @Test
    @Ignore
    public void testEliminarGrupo() throws IsspolException {
        Integer idGrupo = 35;
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Grupo grupo = new Grupo();
        logger.info("calling method buscarGrupoPorId ID ==> {} ", idGrupo);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_BUSCAR_GRUPO_POR_ID);
        message.setParameters(new Object[]{idGrupo});
        message = usuarioService.callRemoteService((message));
        grupo = (Grupo) message.getResullt();
        logger.info("ID: {}", grupo.getIdGrupo());
        logger.info("NOMBRE: {}", grupo.getNombre());

        UsuarioService usuarioService1 = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);

        logger.info("Grupo a actualizar; ID: {}", grupo.getIdGrupo());
        logger.info("Grupo a actualizar; Nombre: {}", grupo.getNombre());
        logger.info("Llamando al método actualizarGrupo ==> {} ", IsspolConstant.METODO_ELIMINAR_GRUPO);

        Map<String, Object> response = null;
        try {
            grupo.setEliminado(true);
            PeticionRespuesta message1 = new PeticionRespuesta();
            message1.setMethod(IsspolConstant.METODO_ELIMINAR_GRUPO);
            message1.setParameters(new Object[]{grupo});
            message1 = usuarioService.callRemoteService(message1);
            response = (Map<String, Object>) message1.getResullt();
            if(message1.getException() != null)
                throw new IsspolException(message1.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(IsspolConstant.METODO_ELIMINAR_GRUPO), e);
        }
    }

    @Test
    @Ignore
    public void testListarTodosGrupos() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        List<Grupo> grupos = null;
        logger.info("Llamando al método listarTodosGrupos ==> {} ", IsspolConstant.METODO_LISTAR_TODOS_GRUPOS);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_LISTAR_TODOS_GRUPOS);
        message.setParameters(new Object[]{});
        message = usuarioService.callRemoteService(message);
        grupos = (List<Grupo>) message.getResullt();
        for (Grupo grupo : grupos) {
            logger.info("ID: {}", grupo.getIdGrupo());
            logger.info("Nombre: {}", grupo.getNombre());
        }
    }

    @Test
    @Ignore
    public void testGrupoPorNombre() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        logger.info("Llamando al método GrupoPorNombre ==> {} ", IsspolConstant.METODO_BUSCAR_GRUPO_POR_NOMBRE);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_BUSCAR_GRUPO_POR_NOMBRE);
        message.setParameters(new Object[]{"GERENTE"});
        message = usuarioService.callRemoteService(message);
        Grupo grupo1 = (Grupo) message.getResullt();
        logger.info("ID: {}", grupo1.getIdGrupo());
        logger.info("Nombre: {}", grupo1.getNombre());
    }

    @Test
    @Ignore
    public void testListarGrupoPaginado() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = null;
        FilterParam filterParam = new FilterParam(3, 0);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_LISTAR_GRUPO_PAGINADO);
        message.setParameters(new Object[]{filterParam});
        peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(message);
        List<PagedResult> page = (List<PagedResult>) peticionRespuesta.getResullt();

       /* for (Grupo grupo : page.) {
            logger.info("ID: {}", grupo.getIdGrupo());
            logger.info("Nombre: {}", grupo.getNombre());
        }
*/
    }


    @Test
    public void testUsuarioValidaClave() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USU_USUARIO,"jnunez");
        in.put(IsspolConstant.AB_VALIDA_HOSTNAME,0);
        in.put(IsspolConstant.AS_HOSTNAME,"BDD");
        in.put(IsspolConstant.AS_CLAVE,"123456");
        in.put(IsspolConstant.AD_FECHA,new Date());
        in.put(IsspolConstant.AS_EQUIPO,"34-DE-1A-53-AC-D2");
        in.put(IsspolConstant.AI_USUARIO,0);
        PeticionRespuesta isspolMessage = new PeticionRespuesta(IsspolConstant.METHOD_USUARIO_VALIDA_CLAVE, new Object[]{in});
        isspolMessage=usuarioService.callRemoteService(isspolMessage);
        Map<String, Object> result = (Map<String, Object>)isspolMessage.getResullt();
        logger.info("Response update->{}", result);
    }

    @Test
    public void testBuscarUsuarioPorId() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        logger.info("Buscar usuario por id");
        String in="jnunez";
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_BUSCAR_USUARIO_ID);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Usuario response = (Usuario) message.getResullt();
        if(response!=null){
            logger.info("Email {}", response.getEmail());
            logger.info("Id {}", response.getIdUsuario());
        }
        Assert.assertNotNull(response);
    }

    @Test
    public void  testObtenerInformacionSesion() throws  IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USUARIO,"jnunez");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_USUARIO_OBTENER_INFORMACION_SESION);
        message.setParameters(new Object[]{in});
        message=usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        logger.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            logger.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public void testFavoritosLista() throws IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USUARIO,"carauz");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_FAVORITOS_LISTA);
        message.setParameters(new Object[]{in});
        message=usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        logger.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            logger.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public void testobtenerOficinaNombreOficina() throws IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        logger.info("Obtener nombre oficina SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_OFICINA,"1");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_OBTENER_OFICINA_NOMBRE_OFICINA);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        logger.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            logger.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public void testobtenerSucursalOficina() throws IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        logger.info("Obtener nombre sucursal SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_OFICINA,"1");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_OBTENER_SUCURSAL_OFICINA);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        logger.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            logger.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public  void testobtenerCarpetaOpcionPorGrupo() throws IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        logger.info("Obtener carpetas y opociones por grupo SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_GRUPO,"1");
        in.put(IsspolConstant.AS_USUARIO,"jnunez");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_OBTENER_CARPETA_OPCION_GRUPO);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        logger.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            logger.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public void testobtenerOpcionUsoFrecuentes() throws IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        logger.info("Obtener opciones de uso frecuente SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USUARIO,"jnunez");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_OBTENER_OPCION_USO_FRECUENTE);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        logger.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            logger.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public void testProcUsuarioSolicitudCambioClave() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);

        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AI_USUARIO, "jnunez");
        in.put(IsspolConstant.AS_DATO, Util.generarToken("jnunez"));
        in.put(IsspolConstant.AS_CODIGO_TIPO_TOKEN, IsspolConstant.TIPO_TOKEN_CAMBIO_CONTRASENA);
        in.put(IsspolConstant.AS_CODIGO_PROCESO_NOTIFICACION, IsspolConstant.PROCESO_NOT_CAMBIO_CONTRASENA);
        in.put(IsspolConstant.AS_USUARIO, "jnunez");
        in.put(IsspolConstant.AD_FECHA, new Date());
        in.put(IsspolConstant.AS_EQUIPO, "local");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_PROC_USUARIO_SOLICITUD_CAMBIO_CLAVE);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        logger.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            logger.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }

    }

    @Test
    public void testAfiliado() throws IsspolException {
        IAfiliacionServiceBean usuarioService = context.getRegistry().lookupByNameAndType("afiliacionCola", IAfiliacionServiceBean.class);
        logger.info("Buscar usuario por id");
        String in="jnunez";
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_BUSCAR_USUARIO_ID);
        message.setParameters(new Object[]{in});
        try {
            message = usuarioService.callRemoteService(message);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        Usuario response = (Usuario) message.getResullt();
        if(response!=null){
            logger.info("Email {}", response.getEmail());
            logger.info("Id {}", response.getIdUsuario());
        }
        Assert.assertNotNull(response);
    }
}
