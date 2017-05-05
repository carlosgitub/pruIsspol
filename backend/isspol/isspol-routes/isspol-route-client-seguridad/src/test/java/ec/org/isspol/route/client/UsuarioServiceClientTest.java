package ec.org.isspol.route.client;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.security.*;

import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul.salgado on 18/04/17.
 */
public class UsuarioServiceClientTest extends CamelSpringTestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceClientTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
    }

    @Test
    @Ignore
    public void testListaUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("listaUsuario");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_GET_ALL_USUARIO);
        message.setParameters(new Object[]{});
        message = usuarioService.callRemoteService(message);
        List<Usuario> listaUsuario = (List<Usuario>) message.getResullt();
        for (Usuario usuario: listaUsuario){
            LOG.info("Usuario: {} {} {}", usuario.getIdUsuario(), usuario.getEmail(), usuario.getPersonaTipoSubtipo().getPersona().getNombre());
        }
    }

    @Test
    @Ignore
    public void testListaEstadoUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("listaEstadoUsuario");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_GET_ESTADO_USUARIO);
        message.setParameters(new Object[]{});
        message = usuarioService.callRemoteService(message);
        List<EstadoUsuario> listaUsuario = (List<EstadoUsuario>) message.getResullt();
        for (EstadoUsuario estadoUsuario: listaUsuario){
            LOG.info("Estado Usuario: {}", estadoUsuario.getDescripcion());
        }
    }

    @Test
    @Ignore
    public void testListaOficina() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("listaOficina");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_GET_ALL_OFICINA);
        message.setParameters(new Object[]{});
        message = usuarioService.callRemoteService(message);
        List<EstadoUsuario> listaUsuario = (List<EstadoUsuario>) message.getResullt();
        for (EstadoUsuario estadoUsuario: listaUsuario){
            LOG.info("Estado Usuario: {}", estadoUsuario.getDescripcion());
        }
    }

    @Test
    public void testListaCargo() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_GET_ALL_CARGO);
        message.setParameters(new Object[]{});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }
    @Test
    @Ignore
    public void testListaEstructuraOrganizacional() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("listaUsuario");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURA);
        message.setParameters(new Object[]{});
        message = usuarioService.callRemoteService(message);
        List<EstructuraOrganizacional> lista = (List<EstructuraOrganizacional>) message.getResullt();
        for (EstructuraOrganizacional estructuraOrganizacional: lista){
            LOG.info("EstructuraOrganizacional: {} - {}", estructuraOrganizacional.getId(), estructuraOrganizacional.getLabel());
        }
    }


	@Test
    public void testProcEstructuraOrganizacional() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);

        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AI_ID_ESTRUCTURA, 1);
        in.put(IsspolConstant.AS_CODIGO, "32");
        in.put(IsspolConstant.AS_DESCRIPCION , "Root B");
        in.put(IsspolConstant.AI_ORDEN, 1);
        in.put(IsspolConstant.AI_NIVEL, 1);
        in.put(IsspolConstant.AI_ID_ESTRUCTURA_PADRE, null);
        in.put(IsspolConstant.AS_USUARIO, "455");
       // in.put(IsspolConstant.AS_MSJ, "455");
        in.put(IsspolConstant.AS_USUARIO_ACT, "SYACELGA");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_PROC_ESTRUCTURA_ORGANIZACIONAL_GUARDAR);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);

    }

    @Test
    @Ignore
    public void testInsertarUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Insertar Usuario por SP");
        Map<String, Object> in = new HashMap();
        in.put(IsspolConstant.AS_USU_USUARIO, "aaapsalgado");
        in.put(IsspolConstant.AI_ID_PERSONA_SUBTIPO_AFILIACION, 1);
        in.put(IsspolConstant.AI_ESTADO, 1);
        in.put(IsspolConstant.AS_EMAIL, "paul@mail.com");
        in.put(IsspolConstant.AS_IDENTIFICACION, "1717391252");
        in.put(IsspolConstant.AB_CUALQUIER_ESTACION, Boolean.TRUE);
        in.put(IsspolConstant.AI_ID_HORARIO, 1);
        in.put(IsspolConstant.AI_ID_ESTRUCTURA, 1);
        in.put(IsspolConstant.AS_USUARIO_SUPERIOR, null);
        in.put(IsspolConstant.AI_ID_DASHBOARD_INICIO, 1);
        in.put(IsspolConstant.AS_USUARIO, "ADMIN");
        StringBuilder sb = null;
        try {
            byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
            sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
        } catch (Exception e) {
            LOG.error("Error al obtener direccion MAC: ", e);
        }
        LOG.info("MAC: ".concat(sb.toString()));
        in.put(IsspolConstant.AS_DIRECCION_FISICA, sb.toString());
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_PROC_USUARIO_INSERTAR);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    @Ignore
    public void testProcUsuarioActualizar() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Actualizar Usuario por SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USU_USUARIO, "aaapsalgado");
        in.put(IsspolConstant.AI_ESTADO, 1);
        in.put(IsspolConstant.AS_EMAIL, "candresc@prueba.com.ec");
        in.put(IsspolConstant.AB_CAMBIAR_PWD_PRX_LOGON, Boolean.FALSE);
        in.put(IsspolConstant.AB_NO_PUEDE_CAMBIAR_PWD, Boolean.FALSE);
        in.put(IsspolConstant.AB_PWD_NUNCA_EXPIRA, Boolean.TRUE);
        in.put(IsspolConstant.AB_BLOQUEADA, Boolean.FALSE);
        in.put(IsspolConstant.AI_ID, 13);
        in.put(IsspolConstant.AS_IDENTIFICACION, "1001514866");
        in.put(IsspolConstant.AB_CUALQUIER_ESTACION, Boolean.TRUE);
        in.put(IsspolConstant.AI_TIEMPO_INACTIVIDAD, 60000);
        in.put(IsspolConstant.AS_USUARIO_ACT, "ADMIN");
        in.put(IsspolConstant.AS_DIRECCION_FISICA, "maquina");
       // in.put(IsspolConstant.AS_MSJ, "mensaje ok");
        in.put(IsspolConstant.AI_ID_HORARIO, 1);
        in.put(IsspolConstant.AI_ID_ESTRUCTURA, 3);
        in.put(IsspolConstant.AS_USUARIO_SUPERIOR, null);
        in.put(IsspolConstant.AI_ID_DASHBOARD_INICIO, 1);
        StringBuilder sb = null;
        try {
            byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
            sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
        } catch (Exception e) {
            LOG.error("Error al obtener direccion MAC: ", e);
        }
        in.put(IsspolConstant.AS_DIRECCION_FISICA, sb.toString());
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_PROC_USUARIO_ACTUALIZAR);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    @Ignore
    public void testValidacionesFormularioInsertarUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Validaciones Formulario Insertar Usuario");
        Map<String, Object> in = new HashMap();
        in.put(IsspolConstant.AS_IDENTIFICACION, "1802317782");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_PROC_USUARIO_VALIDAR_FORMULARIO);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }


    @Test
    public void testUsuarioActualizar() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        //Listar Usuarios
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_GET_ALL_USUARIO);
        message.setParameters(new Object[]{});
        List<Usuario> listaUsuario = (List<Usuario>) usuarioService.callRemoteService(message);
        Usuario usuario = listaUsuario.get(0);
        usuario.setModificaUsuario("carlos.calo");
        message.setMethod(IsspolConstant.METHOD_UPDATE_USUARIO);
        message.setParameters(new Object[]{usuario});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    public void testValidaClaveUsuarioSP() throws IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Obtener Informacion Sesion  SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USU_USUARIO,"1");
        in.put(IsspolConstant.AB_VALIDA_HOSTNAME,0);
        in.put(IsspolConstant.AS_HOSTNAME,"BDD");
        in.put(IsspolConstant.AS_CLAVE,"123456");
        in.put(IsspolConstant.AD_FECHA,new Date());
        in.put(IsspolConstant.AS_EQUIPO,"34-DE-1A-53-AC-D2");
        in.put(IsspolConstant.AI_USUARIO,0);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_USUARIO_VALIDA_CLAVE);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            LOG.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public void testUsuarioObtenerInformacionSesion() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Obtener Informacion Sesion  SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USUARIO,"carauz");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_USUARIO_OBTENER_INFORMACION_SESION);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            LOG.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public void testFavoritosLista() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Favoritos Lista  SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USUARIO,"psalgado");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_FAVORITOS_LISTA);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            LOG.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
        List<HashMap> rows = (List) response.get("#result-set-1");
        for (HashMap  row : rows) {
            LOG.info("descripcion: {}", row.get("descripcion"));
            LOG.info("nombre: {}", row.get("nombre"));
        }

    }

    @Test
    public void testBuscarUsuarioPorId() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Buscar usuario por id");
        String in="CDIAZ";
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_BUSCAR_USUARIO_ID);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Usuario response = (Usuario) message.getResullt();
        if(response!=null){
            LOG.info("Email {}", response.getEmail());
            LOG.info("Id {}", response.getIdUsuario());
        }
        Assert.assertNotNull(response);
    }

    @Test
    public void testobtenerOficinaNombreOficina() throws IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Obtener nombre oficina SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_OFICINA,"1");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_OBTENER_OFICINA_NOMBRE_OFICINA);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            LOG.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public void testobtenerSucursalOficina() throws IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Obtener nombre sucursal SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_OFICINA,"1");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_OBTENER_SUCURSAL_OFICINA);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            LOG.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public  void testobtenerCarpetaOpcionPorGrupo() throws IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Obtener carpetas y opociones por grupo SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_GRUPO,"1");
        in.put(IsspolConstant.AS_USUARIO,"jnunez");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_OBTENER_CARPETA_OPCION_GRUPO);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            LOG.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public void testobtenerOpcionUsoFrecuentes() throws IsspolException{
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Obtener opciones de uso frecuente SP");
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USUARIO,"jnunez");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_OBTENER_OPCION_USO_FRECUENTE);
        message.setParameters(new Object[]{in});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            LOG.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
    }

    @Test
    public void testBuscarGrupoPorId() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_BUSCAR_GRUPO_POR_ID);
        message.setParameters(new Object[]{1});
        message = usuarioService.callRemoteService(message);
        Grupo response = (Grupo) message.getResullt();
        LOG.info("Response {}", response.getNombre());
    }

    @Test
    public void testBuscarOficinaPorId() throws IsspolSearchException, IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_BUSCAR_OFICINA_ID);
        message.setParameters(new Object[]{1});
        message = usuarioService.callRemoteService(message);
        Oficina response = (Oficina) message.getResullt();
        LOG.info("Response {}", response.getNombre());
    }

    @Test
    public void testBuscarSucursalPorId() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_BUSCAR_SUCURSAL_POR_ID);
        message.setParameters(new Object[]{1});
        message = usuarioService.callRemoteService(message);
        Sucursal response= (Sucursal) message.getResullt();
        LOG.info("Response {}", response.getNombre());
    }

    /**
     *
     * Estacion
     * -------------------------------------------------------------------
     */

    @Test
    @Ignore
    public void testInsertarEstacion() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Insertar Estacion");

        Estacion estacion = new Estacion();
        estacion.setHostname("Sistemas");
        estacion.setDireccionFisica("30-E3-7A-2D-9A-7D");
        estacion.setIp("192.168.2.231");
        estacion.setDescripcion("Sistemas");
        estacion.setUbicacion("Desarrollo");

        estacion.setEliminado(false);
        estacion.setCreacionUsuario("Administrador");
        estacion.setCreacionFecha(new Date());
        estacion.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        estacion.setModificaUsuario("Administrador");
        estacion.setModificaFecha(new Date());
        estacion.setModificaEquipo("30-E3-7A-2D-9A-7D");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_INSERTAR_ESTACION);
        message.setParameters(new Object[]{estacion});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    @Ignore
    public void testActualizarEstacion() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Actualizar Estacion");

        Estacion estacion = new Estacion();
        estacion.setIdEstacion(11);
        estacion.setHostname("Servidor Jboss");
        estacion.setDireccionFisica("C8-D3-FF-26-29-79");
        estacion.setIp("192.168.2.248");
        estacion.setDescripcion("Base de Datos");
        estacion.setUbicacion("Servidor Desarrollo");

        estacion.setEliminado(false);
        estacion.setCreacionUsuario("Administradora");
        estacion.setCreacionFecha(new Date());
        estacion.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        estacion.setModificaUsuario("Administradora");
        estacion.setModificaFecha(new Date());
        estacion.setModificaEquipo("30-E3-7A-2D-9A-7D");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_ACTUALIZAR_ESTACION);
        message.setParameters(new Object[]{estacion});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    @Ignore
    public void testListarTodosEstacion() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testListarTodosEstacion");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_LISTAR_TODOS_ESTACION);
        message.setParameters(new Object[]{});
        message = usuarioService.callRemoteService(message);
        List<Estacion> estacions = (List<Estacion>) message.getResullt();
        for (Estacion estacion: estacions){
            LOG.info("Estacion: {} {}", "IdEstacion" + estacion.getIdEstacion(),
                    "Hostname: " + estacion.getHostname(),
                    "Ip: " + estacion.getIp());
        }
    }

    @Test
    @Ignore
    public void testBuscarEstacionPorId() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testBuscarEstacionPorId");

        Integer id=13;
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_BUSCAR_ESTACION_PORID);
        message.setParameters(new Object[]{id});
        message = usuarioService.callRemoteService(message);
        Estacion response = (Estacion) message.getResullt();
        LOG.info("Response {}", "IdEstacion: " + response.getIdEstacion());
    }

    @Test
    @Ignore
    public void testListarEstacionNoEliminado() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testListarEstacionNoEliminado");

        PagedResult<Estacion> pagedResult = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);/*0: inicia el paginado, visualiza los primeros 3 registros de la lista*/
        filterParam.setItemsPerPage(2);

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_LISTAR_ESTACION_NO_ELIMINADO);
        message.setParameters(new Object[]{filterParam});
        message = usuarioService.callRemoteService(message);
        pagedResult = (PagedResult<Estacion>) message.getResullt();

        for (Estacion estacion: (List<Estacion>)pagedResult.getItems()) {
            LOG.info("Estacion: {} {}", "IdEstacion" + estacion.getIdEstacion(),
                    "Hostname: " + estacion.getHostname(),
                    "Ip: " + estacion.getIp());
        }
    }


    //INICIA METODOS Mavelin Ati
    //----------------------------------------------------------------------------------------------
    /**
     * Estacion Usuario
     * ----------------
     */

    @Test
    @Ignore
    public void testInsertarEstacionUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Insertar EstacionUsuario");

        EstacionUsuario estacionUsuario = new EstacionUsuario();
        Estacion estacion = new Estacion();
        estacion.setIdEstacion(12);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jlopez");
        estacionUsuario.setEstacion(estacion);
        estacionUsuario.setUsuario(usuario);

        estacionUsuario.setEliminado(false);
        estacionUsuario.setCreacionUsuario("Administrador");
        estacionUsuario.setCreacionFecha(new Date());
        estacionUsuario.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        estacionUsuario.setModificaUsuario("Administrador");
        estacionUsuario.setModificaFecha(new Date());
        estacionUsuario.setModificaEquipo("30-E3-7A-2D-9A-7D");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_INSERTAR_ESTACION_USUARIO);
        message.setParameters(new Object[]{estacionUsuario});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    @Ignore
    public void testActualizarEstacionUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Actualizar EstacionUsuario");
        EstacionUsuario estacionUsuario = new EstacionUsuario();
        Estacion estacion = new Estacion();
        estacion.setIdEstacion(11);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jnunez");
        estacionUsuario.setEstacion(estacion);
        estacionUsuario.setUsuario(usuario);

        estacionUsuario.setEliminado(false);
        estacionUsuario.setCreacionUsuario("Administradora");
        estacionUsuario.setCreacionFecha(new Date());
        estacionUsuario.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        estacionUsuario.setModificaUsuario("Administradora");
        estacionUsuario.setModificaFecha(new Date());
        estacionUsuario.setModificaEquipo("30-E3-7A-2D-9A-7D");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_ACTUALIZAR_ESTACION_USUARIO);
        message.setParameters(new Object[]{estacionUsuario});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    @Ignore
    public void testListarTodosEstacionUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testListarTodosEstacionUsuario");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_LISTAR_TODOS_ESTACION_USUARIO);
        message.setParameters(new Object[]{});
        message = usuarioService.callRemoteService(message);
        List<EstacionUsuario> estacionUsuarios = (List<EstacionUsuario>) message.getResullt();
        for (EstacionUsuario estacionUsuario: estacionUsuarios){
            LOG.info("EstacionUsuario: {} {} {}", "IdEstacionUsuario: " + estacionUsuario.getIdEstacionUsuario(),
                    "IdUsuario: " + estacionUsuario.getUsuario().getIdUsuario(),
                    "IdEstacion: " + estacionUsuario.getEstacion().getIdEstacion());
        }
    }

    @Test
    @Ignore
    public void testBuscarEstacionUsuarioPorId() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testBuscarEstacionUsuarioPorId");

        Integer id=2;
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_BUSCAR_ESTACION_USUARIO_PORID);
        message.setParameters(new Object[]{id});
        message = usuarioService.callRemoteService(message);
        EstacionUsuario response = (EstacionUsuario) message.getResullt();
        LOG.info("Response {}", "IdEstacionUsuario: " + response.getIdEstacionUsuario());
    }

    @Test
    @Ignore
    public void testListarEstacionUsuarioPorUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testListarEstacionUsuarioPorUsuario");
        String idUsuario = "jnunez";
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_LISTAR_ESTACION_USUARIO_POR_USUARIO);
        message.setParameters(new Object[]{idUsuario});
        message = usuarioService.callRemoteService(message);
        List<EstacionUsuario> estacionUsuarios = (List<EstacionUsuario>) message.getResullt();
        for (EstacionUsuario estacionUsuario: estacionUsuarios){
            LOG.info("EstacionUsuario: {} {} {}", "IdEstacionUsuario: " + estacionUsuario.getIdEstacionUsuario(),
                    "IdUsuario: " + estacionUsuario.getUsuario().getIdUsuario(),
                    "IdEstacion: " + estacionUsuario.getEstacion().getIdEstacion());
        }
    }

    @Test
    @Ignore
    public void testListarEstacionUsuarioNoEliminadoPorUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testListarEstacionUsuarioNoEliminadoPorUsuario");

        PagedResult<EstacionUsuario> pagedResult = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);/*0: inicia el paginado, visualiza los primeros 3 registros de la lista*/
        filterParam.setItemsPerPage(2);
        String idUsuario = "jlopez";

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_LISTAR_ESTACION_USUARIO_NO_ELIMINADO_POR_USUARIO);
        message.setParameters(new Object[]{idUsuario, filterParam});
        message = usuarioService.callRemoteService(message);
        pagedResult = (PagedResult<EstacionUsuario>) message.getResullt();

        for (EstacionUsuario estacionUsuario: (List<EstacionUsuario>)pagedResult.getItems()) {
            LOG.info("EstacionUsuario: {} {} {}", "IdEstacionUsuario: " + estacionUsuario.getIdEstacionUsuario(),
                    "IdUsuario: " + estacionUsuario.getUsuario().getIdUsuario(),
                    "IdEstacion: " + estacionUsuario.getEstacion().getIdEstacion());
        }
    }

    /**
     * Grupo Usuario
     * -------------
     */

    @Test
    @Ignore
    public void testInsertarGrupoUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Insertar GrupoUsuario");

        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jlopez");
        Grupo grupo = new Grupo();
        grupo.setIdGrupo(3);

        GrupoUsuario grupoUsuario = new GrupoUsuario();
        grupoUsuario.setGrupo(grupo);
        grupoUsuario.setUsuario(usuario);
        grupoUsuario.setEstado(1);
        grupoUsuario.setTieneVencimiento(Boolean.FALSE);
        grupoUsuario.setFechaVencimiento(new Date());

        grupoUsuario.setEliminado(false);
        grupoUsuario.setCreacionUsuario("Administrador");
        grupoUsuario.setCreacionFecha(new Date());
        grupoUsuario.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        grupoUsuario.setModificaUsuario("Administrador");
        grupoUsuario.setModificaFecha(new Date());
        grupoUsuario.setModificaEquipo("30-E3-7A-2D-9A-7D");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_INSERTAR_GRUPO_USUARIO);
        message.setParameters(new Object[]{grupoUsuario});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    @Ignore
    public void testActualizarGrupoUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Actualizar GrupoUsuario");

        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jnunez");
        Grupo grupo = new Grupo();
        grupo.setIdGrupo(5);

        GrupoUsuario grupoUsuario = new GrupoUsuario();
        grupoUsuario.setIdGrupoUsuario(2);
        grupoUsuario.setGrupo(grupo);
        grupoUsuario.setUsuario(usuario);
        grupoUsuario.setEstado(1);
        grupoUsuario.setTieneVencimiento(Boolean.FALSE);
        grupoUsuario.setFechaVencimiento(new Date());

        grupoUsuario.setEliminado(false);
        grupoUsuario.setCreacionUsuario("Administrador");
        grupoUsuario.setCreacionFecha(new Date());
        grupoUsuario.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        grupoUsuario.setModificaUsuario("Administrador");
        grupoUsuario.setModificaFecha(new Date());
        grupoUsuario.setModificaEquipo("30-E3-7A-2D-9A-7D");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_ACTUALIZAR_GRUPO_USUARIO);
        message.setParameters(new Object[]{grupoUsuario});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    @Ignore
    public void testListarTodosGrupoUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testListarTodosGrupoUsuario");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_LISTAR_TODOS_GRUPO_USUARIO);
        message.setParameters(new Object[]{});
        message = usuarioService.callRemoteService(message);
        List<GrupoUsuario> grupoUsuarios = (List<GrupoUsuario>) message.getResullt();
        for (GrupoUsuario grupoUsuario: grupoUsuarios){
            LOG.info("GrupoUsuario: {} {}", "IdGrupoUsuario" + grupoUsuario.getIdGrupoUsuario(),
                    "IdGrupo" + grupoUsuario.getGrupo().getIdGrupo(),
                    "IdUsuario" + grupoUsuario.getUsuario().getIdUsuario());
        }
    }

    @Test
    @Ignore
    public void testBuscarGrupoUsuarioPorId() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testBuscarGrupoUsuarioPorId");
        Integer id=1;
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_BUSCAR_GRUPO_USUARIO_PORID);
        message.setParameters(new Object[]{id});
        message = usuarioService.callRemoteService(message);
        GrupoUsuario response = (GrupoUsuario) message.getResullt();
        LOG.info("Response {}", "IdGrupoUsuario: " + response.getIdGrupoUsuario());
    }

    @Test
    @Ignore
    public void testListarGrupoUsuarioPorUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("listarGrupoUsuarioPorUsuario");
        String idUsuario = "jnunez";
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_LISTAR_GRUPO_USUARIO_POR_USUARIO);
        message.setParameters(new Object[]{idUsuario});
        message = usuarioService.callRemoteService(message);
        List<GrupoUsuario> grupoUsuarios = (List<GrupoUsuario>) message.getResullt();
        for (GrupoUsuario grupoUsuario: grupoUsuarios){
            LOG.info("GrupoUsuario: {} {}", "IdGrupoUsuario" + grupoUsuario.getIdGrupoUsuario(),
                    "IdGrupo" + grupoUsuario.getGrupo().getIdGrupo(),
                    "IdUsuario" + grupoUsuario.getUsuario().getIdUsuario());
        }
    }

    @Test
    @Ignore
    public void testListarGrupoUsuarioNoEliminadoPorUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testListarGrupoUsuarioNoEliminadoPorUsuario");

        PagedResult<GrupoUsuario> pagedResult = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);/*0: inicia el paginado, visualiza los primeros 3 registros de la lista*/
        filterParam.setItemsPerPage(2);
        String idUsuario = "jlopez";

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_LISTAR_GRUPO_USUARIO_NO_ELIMINADO_POR_USUARIO);
        message.setParameters(new Object[]{idUsuario, filterParam});
        message = usuarioService.callRemoteService(message);
        pagedResult = (PagedResult<GrupoUsuario>) message.getResullt();

        for (GrupoUsuario grupoUsuario: (List<GrupoUsuario>)pagedResult.getItems()) {
            LOG.info("GrupoUsuario: {} {}", "IdGrupoUsuario" + grupoUsuario.getIdGrupoUsuario(),
                    "IdGrupo" + grupoUsuario.getGrupo().getIdGrupo(),
                    "IdUsuario" + grupoUsuario.getUsuario().getIdUsuario());
        }
    }

    //FIN METODOS Mavelin Ati
    //-----------------------------------------------------------------------------------------------------

    /**
     * UsuarioOficina
     * --------------
     */

    @Test
    @Ignore
    public void testInsertarUsuarioOficina() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Insertar UsuarioOficina");

        UsuarioOficina usuarioOficina = new UsuarioOficina();
        Oficina oficina = new Oficina();
        oficina.setIdOficina(12);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jnunez");
        usuarioOficina.setOficina(oficina);
        usuarioOficina.setUsuario(usuario);

        // usuarioOficina.setEliminado(false);
        usuarioOficina.setCreacionUsuario("Administrador");
        usuarioOficina.setCreacionFecha(new Date());
        usuarioOficina.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        usuarioOficina.setModificaUsuario("Administrador");
        usuarioOficina.setModificaFecha(new Date());
        usuarioOficina.setModificaEquipo("30-E3-7A-2D-9A-7D");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_INSERTAR_USUARIO_OFICINA);
        message.setParameters(new Object[]{usuarioOficina});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    @Ignore
    public void testActualizarUsuarioOficina() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Actualizar UsuarioOficina");
        UsuarioOficina usuarioOficina = new UsuarioOficina();
        Oficina oficina = new Oficina();
        oficina.setIdOficina(11);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("jnunez");
        usuarioOficina.setOficina(oficina);
        usuarioOficina.setUsuario(usuario);

        // usuarioOficina.setEliminado(false);
        usuarioOficina.setCreacionUsuario("Administradora");
        usuarioOficina.setCreacionFecha(new Date());
        usuarioOficina.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        usuarioOficina.setModificaUsuario("Administradora");
        usuarioOficina.setModificaFecha(new Date());
        usuarioOficina.setModificaEquipo("30-E3-7A-2D-9A-7D");

        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_ACTUALIZAR_ESTACION_USUARIO);
        message.setParameters(new Object[]{usuarioOficina});
        message = usuarioService.callRemoteService(message);
        Map<String, Object> response = (Map<String, Object>) message.getResullt();
        LOG.info("Response {}", response);
    }

    @Test
    @Ignore
    public void testListarTodosUsuarioOficina() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("listarTodasUsuarioOficinas");
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_LISTAR_TODAS_USUARIO_OFICINA);
        message.setParameters(new Object[]{});
        message = usuarioService.callRemoteService(message);
        List<UsuarioOficina> usuarioOficinas = (List<UsuarioOficina>) message.getResullt();
        for (UsuarioOficina usuarioOficina: usuarioOficinas){
            LOG.info("UsuarioOficina: {} {} {}", "IdUsuarioOficina: " + usuarioOficina.getIdUsuarioOficina(),
                    "IdUsuario: " + usuarioOficina.getUsuario().getIdUsuario(),
                    "IdOficina: " + usuarioOficina.getOficina().getIdOficina());
        }
    }

    @Test
    @Ignore
    public void testBuscarUsuarioOficinaPorId() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testBuscarUsuarioOficinaPorId");

        Integer id=2;
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_BUSCAR_USUARIO_OFICINA_POR_ID);
        message.setParameters(new Object[]{id});
        message = usuarioService.callRemoteService(message);
        UsuarioOficina response = (UsuarioOficina) message.getResullt();
        LOG.info("Response {}", "IdUsuarioOficina: " + response.getIdUsuarioOficina());
    }

    @Test
    @Ignore
    public void testListarUsuarioOficinaPorUsuario() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("testListarUsuarioOficinaPorUsuario");
        String idUsuario = "jnunez";
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METODO_LISTAR_USUARIO_OFICINA_POR_USUARIO);
        message.setParameters(new Object[]{idUsuario});
        message = usuarioService.callRemoteService(message);
        List<UsuarioOficina> usuarioOficinas = (List<UsuarioOficina>) message.getResullt();
        LOG.info(String.valueOf(usuarioOficinas.size()));
        for (UsuarioOficina usuarioOficina: usuarioOficinas){
            LOG.info("IdUsuarioOficina: {}", usuarioOficina.getIdUsuarioOficina());
            LOG.info("IdUsuario: {}", usuarioOficina.getUsuario().getIdUsuario());
            LOG.info("IdOficina: {}", usuarioOficina.getOficina().getIdOficina());
        }
    }

}
