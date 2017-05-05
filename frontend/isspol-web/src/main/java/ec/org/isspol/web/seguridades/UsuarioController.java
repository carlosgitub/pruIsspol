package ec.org.isspol.web.seguridades;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.security.*;
import ec.org.isspol.persistence.entities.security.dto.DatosPersonaUsuario;
import ec.org.isspol.route.client.auditoria.AuditoriaServicioCliente;
import ec.org.isspol.route.client.comun.ComunClienteServicio;
import ec.org.isspol.route.client.context.AppContext;
import ec.org.isspol.route.client.seguridad.UsuarioServiceClient;
import ec.org.isspol.web.comun.ComunController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.*;

@Controller
public class UsuarioController extends ComunController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    public List<Usuario> listaUsuario() {
        UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        List<Usuario> lista = client.listarUsuario();
        return lista;
    }

    public List<EstadoUsuario> listaEstadoUsuario() {
        UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        List<EstadoUsuario> lista = client.listarEstadoUsuario();
        return lista;
    }

    public List<Horario> listaHorario() {
        UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        List<Horario> lista = client.listarHorario();
        return lista;
    }

    public List<EstructuraOrganizacional> listaEstructura() {
        UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        List<EstructuraOrganizacional> lista = client.listarEstructuraOrganizacional();
        return lista;
    }

    public List<Oficina> listaOficina() {
        UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        List<Oficina> lista = client.listarOficina();
        return lista;
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        usuarioServiceClient.actualizarUsuario(usuario);
        return usuario;
    }

    public Map<String, Object> insertarUsuario(Usuario usuario) throws IsspolException {
        Map<String, Object> resultado = null;
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            HashMap<String, Object> in = new HashMap();
            in.put(IsspolConstant.AS_USU_USUARIO, usuario.getIdUsuario());
            in.put(IsspolConstant.AI_ID_PERSONA_SUBTIPO_AFILIACION,
                    usuario.getPersonaTipoSubtipo() != null ? usuario.getPersonaTipoSubtipo().getIdPersonaTipoSubtipo() : null);
            in.put(IsspolConstant.AI_ESTADO, usuario.getEstadoUsuario() != null ? usuario.getEstadoUsuario().getIdEstadoUsuario() : null);
            in.put(IsspolConstant.AS_EMAIL, usuario.getEmail());
            in.put(IsspolConstant.AS_IDENTIFICACION, usuario.getIdentificacion());
            in.put(IsspolConstant.AB_CUALQUIER_ESTACION, usuario.getCualquierEstacion());
            in.put(IsspolConstant.AI_ID_HORARIO, usuario.getHorario() != null ? usuario.getHorario().getIdHorario() : null);
            in.put(IsspolConstant.AI_ID_ESTRUCTURA, usuario.getEstructuraOrganizacional() != null ? usuario.getEstructuraOrganizacional().getId() : null);
            in.put(IsspolConstant.AS_USUARIO_SUPERIOR, usuario.getUsuario() != null ? usuario.getUsuario().getIdUsuario() : null);
            in.put(IsspolConstant.AI_ID_DASHBOARD_INICIO, usuario.getIdDashboardInicio());
            in.put(IsspolConstant.AS_USUARIO, getHostName());
            in.put(IsspolConstant.AS_DIRECCION_FISICA, getDireccionMac());
            PeticionRespuesta message = new PeticionRespuesta();
            message.setMethod(IsspolConstant.METHOD_PROC_USUARIO_INSERTAR);
            message.setParameters(new Object[]{in});
            resultado = client.procUsuarioInsertar(in);
        } catch (Exception e) {
            logger.error("Error insertar usuario: ", e);
        }
        return resultado;
    }

    public Map<String, Object> actualizarUsuarioSP(Usuario usuario) throws IsspolException {
        Map<String, Object> resultado = null;
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            HashMap<String, Object> in = new HashMap();
            in.put(IsspolConstant.AS_USU_USUARIO, usuario.getIdUsuario());
            in.put(IsspolConstant.AI_ESTADO, usuario.getEstadoUsuario() != null ? usuario.getEstadoUsuario().getIdEstadoUsuario() : null);
            in.put(IsspolConstant.AS_EMAIL, usuario.getEmail());
            in.put(IsspolConstant.AB_CAMBIAR_PWD_PRX_LOGON, usuario.getCambiarPwdProximoLogon());
            in.put(IsspolConstant.AB_NO_PUEDE_CAMBIAR_PWD, usuario.getNoPuedeCambiarPwd());
            in.put(IsspolConstant.AB_PWD_NUNCA_EXPIRA, usuario.getPwdNuncaExpira());
            in.put(IsspolConstant.AB_BLOQUEADA, usuario.getBloqueada());
            in.put(IsspolConstant.AI_ID, usuario.getUsuarioSecuencial());
            in.put(IsspolConstant.AS_IDENTIFICACION, usuario.getIdentificacion());
            in.put(IsspolConstant.AB_CUALQUIER_ESTACION, usuario.getCualquierEstacion());
            in.put(IsspolConstant.AI_TIEMPO_INACTIVIDAD, usuario.getTiempoInactividad());
            in.put(IsspolConstant.AS_USUARIO_ACT, getHostName());
            in.put(IsspolConstant.AS_DIRECCION_FISICA, getDireccionMac());
            in.put(IsspolConstant.AI_ID_HORARIO, usuario.getHorario() != null ? usuario.getHorario().getIdHorario() : null);
            in.put(IsspolConstant.AI_ID_ESTRUCTURA, usuario.getEstructuraOrganizacional() != null ? usuario.getEstructuraOrganizacional().getId() : null);
            in.put(IsspolConstant.AS_USUARIO_SUPERIOR, usuario.getUsuario() != null ? usuario.getUsuario().getIdUsuario() : null);
            in.put(IsspolConstant.AI_ID_DASHBOARD_INICIO, usuario.getIdDashboardInicio());
            PeticionRespuesta message = new PeticionRespuesta();
            message.setMethod(IsspolConstant.METHOD_PROC_USUARIO_ACTUALIZAR);
            message.setParameters(new Object[]{in});
            resultado = client.procUsuarioActualizar(in);
        } catch (Exception e) {
            logger.error("Error actualizar usuario: ", e);
        }
        return resultado;
    }

    public DatosPersonaUsuario validarFormularioInsertarUsuario(Usuario usuario) throws IsspolException {
        DatosPersonaUsuario dpu = new DatosPersonaUsuario();
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            HashMap<String, Object> in = new HashMap();
            in.put(IsspolConstant.AS_IDENTIFICACION, usuario.getIdentificacion());
            PeticionRespuesta message = new PeticionRespuesta();
            message.setMethod(IsspolConstant.METHOD_PROC_USUARIO_VALIDAR_FORMULARIO);
            message.setParameters(new Object[]{in});
            Map<String, Object> response = client.procUsuarioValidacionesFormulario(in);
            dpu.setRETURN_VALUE((Integer) response.get("RETURN_VALUE"));
            dpu.setAS_MSJ(response.get("AS_MSJ").toString());
            if (dpu.getRETURN_VALUE() == 1) {
                dpu.setAI_IDPERSONASUBTIPO((Integer) response.get("AI_IDPERSONASUBTIPO"));
                dpu.setAS_IDUSUARIO(response.get("AS_IDUSUARIO").toString());
                dpu.setAS_CORREO(response.get("AS_CORREO").toString());
                dpu.setAS_APELLIDOPATERNO(response.get("AS_APELLIDOPATERNO").toString());
                dpu.setAS_NOMBRES(response.get("AS_NOMBRES").toString());
                dpu.setAS_APELLIDOMATERNO(response.get("AS_APELLIDOMATERNO").toString());
            }
        } catch (Exception e) {
            logger.error("Error insertar usuario: ", e);
        }
        return dpu;
    }

    public Map<String, Object> obtenerFecha() {
        ComunClienteServicio paisClienteServicio = (ComunClienteServicio) AppContext.getBean("comunClienteServicio");
        HashMap<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.FECHA, "");
        Map<String, Object> resultado = paisClienteServicio.obtenerFechaHoraSistema(in);
        return resultado;
    }

    public Map<String, Object> validarClaveUsuario(String usuario, String clave) throws UnknownHostException {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        HashMap<String, Object> in = new HashMap();

        in.put(IsspolConstant.AS_USU_USUARIO, usuario);
        in.put(IsspolConstant.AB_VALIDA_HOSTNAME, 0);
        in.put(IsspolConstant.AS_HOSTNAME, getHostName());
        in.put(IsspolConstant.AS_CLAVE, clave);
        in.put(IsspolConstant.AS_USUARIO, usuario);
        in.put(IsspolConstant.AD_FECHA, new Date());
        in.put(IsspolConstant.AS_EQUIPO, getDireccionMac());
        PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_USUARIO_VALIDA_CLAVE);
        message.setParameters(new Object[]{in});
        Map<String, Object> resultado = usuarioServiceClient.validarClaveUsuario(in);
        return resultado;
    }

    public List<HashMap> obtenerInformacionSesion(String nombreUsuario) {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        HashMap<String, Object> in = new HashMap();
        in.put(IsspolConstant.AS_USUARIO, nombreUsuario);
        Map<String, Object> resultado = usuarioServiceClient.obtenerInformacionSesion(in);
        List<HashMap> rows = (List) resultado.get("#result-set-1");
        return rows;
    }

    public Map<String, Object> obtenerOficinaNombreOficina(String oficina) {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        HashMap<String, Object> in = new HashMap();
        in.put(IsspolConstant.AS_OFICINA, oficina);
        Map<String, Object> resultado = usuarioServiceClient.obtenerOficinaNombreOficina(in);
        return resultado;
    }

    public Map<String, Object> obtenerSucursalOficina(String oficina) {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        HashMap<String, Object> in = new HashMap();
        in.put(IsspolConstant.AS_OFICINA, oficina);
        Map<String, Object> resultado = usuarioServiceClient.obtenerSucursalOficina(in);
        return resultado;
    }

    public List<HashMap> obtenerListaFavoritos(String usuario) {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        HashMap<String, Object> in = new HashMap();
        in.put(IsspolConstant.AS_USUARIO, usuario);
        Map<String, Object> resultado = usuarioServiceClient.obtenerListaFavoritos(in);
        List<HashMap> rows = (List) resultado.get("#result-set-1");
        return rows;
    }

    public Integer logAuditoria(String descripcion, String referencia, String tipo, String usuario) throws
            IsspolException, UnknownHostException {
        AuditoriaServicioCliente auditoriaServicioCliente = (AuditoriaServicioCliente) AppContext.getBean("auditoriaServicioCliente");
        HashMap<String, Object> in = new HashMap();
        in.put(IsspolConstant.AS_DESCRIPCION, descripcion);
        in.put(IsspolConstant.AS_REFERENCIA, referencia);
        in.put(IsspolConstant.AS_TIPO, tipo);
        in.put(IsspolConstant.AS_USUARIO, usuario);
        in.put(IsspolConstant.AS_MAQUINA, getDireccionMac());
        in.put(IsspolConstant.AS_APLICACION, "front end");
        Map<String, Object> resultado = auditoriaServicioCliente.logAuditoria(in);
        Integer rows = (Integer) resultado.get("#update-count-1");
        return rows;
    }

    public Map<String, Object> obtenerCarpetaOpcionPorGrupo(String grupo, String nombre) throws IsspolException {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
//        logger.info("Obtener carpetas y opociones por grupo SP");
        HashMap<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_GRUPO, grupo);
        in.put(IsspolConstant.AS_USUARIO, nombre);
        Map<String, Object> resultado = usuarioServiceClient.obtenerCarpetaOpcionPorGrupo(in);
        List<HashMap> rows = (List<HashMap>) resultado.get("#result-set-1");
        Integer rows1 = (Integer) resultado.get("#update-count-1");
        return resultado;
    }

    public List<HashMap> obtenerOpcionUsoFrecuentes(String nombre) throws IsspolException {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
//        logger.info("Obtener opciones de uso frecuente SP");
        HashMap<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_USUARIO, nombre);
        Map<String, Object> resultado = usuarioServiceClient.obtenerOpcionUsoFrecuentes(in);
        List<HashMap> rows = (List<HashMap>) resultado.get("#result-set-1");
        return rows;
    }

    public boolean verificarNombreUsuario(String idUsuario) {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        Usuario usuario = usuarioServiceClient.buscarUsuarioporId(idUsuario);
        if (usuario != null)
            if (usuario.getIdUsuario() != null)
                return true;
        return false;
    }

    //INICIO METODOS Mavelin Ati
    //-------------------------------------------------------------------------------------------------------

    /**
     * Inicio CRUD Estacion - Usuario
     * ------------------------------
     */
    @RequestMapping(value = "/insertarActualizarEstacionUsuario_json", method = RequestMethod.POST)
    public @ResponseBody
    EstacionUsuario insertarActualizarEstacionUsuario(@RequestBody EstacionUsuario estacionUsuario, HttpSession session) {

        try {
            estacionUsuario.setEliminado(false);
            estacionUsuario.setModificaUsuario(getHostName());
            estacionUsuario.setModificaFecha(new Date());
            estacionUsuario.setModificaEquipo(getDireccionMac());

            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            if (estacionUsuario.getIdEstacionUsuario() == null) {
                estacionUsuario.setCreacionUsuario(getHostName());
                estacionUsuario.setCreacionFecha(new Date());
                estacionUsuario.setCreacionEquipo(getDireccionMac());
                client.insertarEstacionUsuario(estacionUsuario);
            } else {
                client.actualizarEstacionUsuario(estacionUsuario);
            }
        } catch (Exception ex) {
            logger.error("Error al insertarActualizar: EstacionUsuario", ex);
            //estacionUsuario.sete
            return estacionUsuario;
        }
        return estacionUsuario;
    }

    @RequestMapping(value = "/eliminarEstacionUsuario_json", method = RequestMethod.POST)
    public @ResponseBody
    EstacionUsuario eliminarEstacionUsuario(@RequestBody EstacionUsuario estacionUsuario, HttpSession session) {
        try {

            estacionUsuario.setEliminado(true);
            estacionUsuario.setModificaUsuario(getHostName());
            estacionUsuario.setModificaFecha(new Date());
            estacionUsuario.setModificaEquipo(getDireccionMac());

            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            client.actualizarEstacionUsuario(estacionUsuario);
        } catch (Exception ex) {
            logger.error("Error al eliminar EstacionUsuario ", ex);
            //estacionUsuario.setException(ex);
            return estacionUsuario;
        }
        return estacionUsuario;
    }

    public List<EstacionUsuario> listarTodosEstacionUsuario() {
        List<EstacionUsuario> estacionUsuarios = null;
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            estacionUsuarios = client.listarTodosEstacionUsuario();
        } catch (Exception ex) {
            logger.error("Error al listarTodosEstacionUsuario ", ex);
        }
        return estacionUsuarios;
    }

    public EstacionUsuario buscarEstacionUsuarioPorId(Integer id) {
        EstacionUsuario estacionUsuario = new EstacionUsuario();
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            estacionUsuario = client.buscarEstacionUsuarioPorId(id);
        } catch (Exception ex) {
            logger.error("Error al buscarEstacionUsuarioPorId ", ex);
        }
        return estacionUsuario;
    }

    public List<EstacionUsuario> listarEstacionUsuarioPorUsuario(String idUsuario) {
        List<EstacionUsuario> estacionUsuarios = null;
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            estacionUsuarios = client.listarEstacionUsuarioPorUsuario(idUsuario);
        } catch (Exception ex) {
            logger.error("Error al listarEstacionUsuarioPorUsuario ", ex);
        }
        return estacionUsuarios;
    }

    public PagedResult<EstacionUsuario> listarEstacionUsuarioNoEliminadoPorUsuario(String idUsuario, FilterParam filterParam) {
        PagedResult<EstacionUsuario> estacionUsuarioPagedResult = null;
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            estacionUsuarioPagedResult = client.listarEstacionUsuarioNoEliminadoPorUsuario(idUsuario, filterParam);
        } catch (Exception e) {
            logger.error("Error al listarEstacionUsuarioNoEliminadoPorUsuario", e);
        }
        return estacionUsuarioPagedResult;
    }

    /**
     * Inicio CRUD Grupo - Usuario
     * ------------------------------
     */
    @RequestMapping(value = "/insertarActualizarGrupoUsuario_json", method = RequestMethod.POST)
    public @ResponseBody
    GrupoUsuario insertarActualizarGrupoUsuario(@RequestBody GrupoUsuario grupoUsuario, HttpSession session) {

        try {
            grupoUsuario.setEliminado(false);
            grupoUsuario.setModificaUsuario(getHostName());
            grupoUsuario.setModificaFecha(new Date());
            grupoUsuario.setModificaEquipo(getDireccionMac());

            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            if (grupoUsuario.getIdGrupoUsuario() == null) {
                grupoUsuario.setCreacionUsuario(getHostName());
                grupoUsuario.setCreacionFecha(new Date());
                grupoUsuario.setCreacionEquipo(getDireccionMac());
                client.insertarGrupoUsuario(grupoUsuario);
            } else {
                client.actualizarGrupoUsuario(grupoUsuario);
            }
        } catch (Exception ex) {
            logger.error("Error al insertarActualizar: GrupoUsuario", ex);
            //estacionUsuario.sete
            return grupoUsuario;
        }
        return grupoUsuario;
    }

    @RequestMapping(value = "/eliminarGrupoUsuario_json", method = RequestMethod.POST)
    public @ResponseBody
    GrupoUsuario eliminarGrupoUsuario(@RequestBody GrupoUsuario grupoUsuario, HttpSession session) {
        try {
            grupoUsuario.setEliminado(true);
            grupoUsuario.setModificaUsuario(getHostName());
            grupoUsuario.setModificaFecha(new Date());
            grupoUsuario.setModificaEquipo(getDireccionMac());

            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            client.actualizarGrupoUsuario(grupoUsuario);
        } catch (Exception ex) {
            logger.error("Error al eliminar GrupoUsuario ", ex);
            //grupoUsuario.setException(ex);
            return grupoUsuario;
        }
        return grupoUsuario;
    }

    public List<GrupoUsuario> listarTodosGrupoUsuario() {
        List<GrupoUsuario> grupoUsuarios = null;
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            grupoUsuarios = client.listarTodosGrupoUsuario();
        } catch (Exception ex) {
            logger.error("Error metodo listarTodosGrupoUsuario ", ex);
        }
        return grupoUsuarios;
    }

    public GrupoUsuario buscarGrupoUsuarioPorId(Integer id) {
        GrupoUsuario grupoUsuario = new GrupoUsuario();
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            grupoUsuario = client.buscarGrupoUsuarioPorId(id);
        } catch (Exception ex) {
            logger.error("Error metodo buscarGrupoUsuarioPorId ", ex);
        }
        return grupoUsuario;
    }

    public List<GrupoUsuario> listarGrupoUsuarioPorUsuario(String idUsuario) {
        List<GrupoUsuario> grupoUsuarios = null;
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            grupoUsuarios = client.listarGrupoUsuarioPorUsuario(idUsuario);
        } catch (Exception ex) {
            logger.error("Error metodo listarGrupoUsuarioPorUsuario ", ex);
        }
        return grupoUsuarios;
    }

    public PagedResult<GrupoUsuario> listarGrupoUsuarioNoEliminadoPorUsuario(String idUsuario, FilterParam filterParam) {
        PagedResult<GrupoUsuario> grupoUsuarioPagedResult = null;
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            grupoUsuarioPagedResult = client.listarGrupoUsuarioNoEliminadoPorUsuario(idUsuario, filterParam);
        } catch (Exception e) {
            logger.error("Error metodo listarGrupoUsuarioNoEliminadoPorUsuario", e);
        }
        return grupoUsuarioPagedResult;
    }
    // FIN METODOS Mavelin Ati
    //---------------------------------------------------------------------------------


    public Map<String, Object> procUsuarioSolicitudCambioClave(Usuario usuario) {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        usuario.setModificaFecha(new Date());
        usuario.setModificaEquipo(getDireccionMac());
        Map<String, Object> resultado = null;
        try {
            resultado = usuarioServiceClient.procUsuarioSolicitudCambioClave(usuario);
        } catch (IsspolException e) {
            logger.error("Error", e);
        }
        return resultado;
    }

    /**
     * @param dato NOT NULL
     * @return
     * @title Buscar Token por Dato
     * @description Buscar Token para Cambio de Contrasena y validar fecha de Caducidad
     * @author carlos.calo
     * @date 27/04/2017
     */
    public Token buscarTokenPorDato(String dato) {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        Token token = new Token();
        try {
            if (isNullOrEmpty(dato))
                throw new Exception("Token no valido");
            token = usuarioServiceClient.buscarTokenPorDato(dato);
            logger.info("caduco " + new Date().after(token.getCaducidadFecha()));
            if (new Date().after(token.getCaducidadFecha()))
                throw new Exception("Token caducado");
        } catch (Exception e) {
            logger.error("Error buscarTokenPorDato", e);
            token.setException(e);
        }
        return token;
    }

    /**
     * @param usuario
     * @param clave
     * @return
     * @throws IsspolException
     * @title Cambiar clave del Usuario
     * @descripcion Cambiar clave de Ingreso al Portal
     * @author carlos.calo
     * @date 27/04/2017
     */
    public Map<String, Object> procUsuarioCambiarClave(Usuario usuario, String clave, String token) throws IsspolException {
        HashMap<String, Object> parametros = new HashMap<>();
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        usuario.setModificaFecha(new Date());
        usuario.setModificaEquipo(getDireccionMac());
        parametros.put(IsspolConstant.AI_USUARIO, usuario);
        parametros.put(IsspolConstant.AS_USU_CLAVE, clave);
        parametros.put(IsspolConstant.AS_TOKEN, token);
        return usuarioServiceClient.procUsuarioCambiarClave(parametros);
    }

    /**
     * @param usuario
     * @return
     * @throws IsspolException
     */
    public Map<String, Object> procUsuarioVerificarBloqueo(Usuario usuario) throws IsspolException {
        UsuarioServiceClient usuarioServiceClient = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        usuario.setModificaFecha(new Date());
        usuario.setModificaEquipo(getDireccionMac());
        return usuarioServiceClient.procUsuarioVerificarBloqueo(usuario);
    }
}

