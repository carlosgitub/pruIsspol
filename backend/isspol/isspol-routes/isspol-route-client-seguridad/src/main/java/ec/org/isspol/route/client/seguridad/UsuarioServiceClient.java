package ec.org.isspol.route.client.seguridad;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.security.*;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 23/3/17.
 */
public class UsuarioServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceClient.class);

    private CamelContext context;
    public void setContext(CamelContext context) {
        this.context = context;
    }

    private UsuarioService usuarioService;

    public List<EstructuraOrganizacional> listarEstructuraOrganizacional(){

        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<EstructuraOrganizacional> listaEstructura = null;
        try {
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURA);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            listaEstructura = (List<EstructuraOrganizacional>) peticionRespuesta.getResullt();


            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method f".concat(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURA), e);
        }

        return listaEstructura;
    }


    public Usuario obtenerUsuarioxID (String idUsuario)  {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Usuario usuario = null;
        try {
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METODO_BUSCAR_USUARIO_X_ID);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            usuario = (Usuario) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method f".concat(IsspolConstant.METODO_BUSCAR_USUARIO_X_ID), e);
        }
        return usuario;
    }

    /**
     * listaUsuario()
     * Metodo que devuelve una lista de usuarios incluidos las clases referenciadas como objetos
     * 19/04/2017
     * @autor: Paul Salgado
     * @param:
     * @return: List<Usuario>
     */
    public List<Usuario> listarUsuario(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Usuario> usuarios = null;
        try {
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_ALL_USUARIO);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            usuarios = (List<Usuario>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(IsspolConstant.METHOD_GET_ALL_USUARIO), e);
        }
        return usuarios;
    }

    /**
     * listarEstadoUsuario()
     * Metodo que devuelve una lista de estados del usuario
     * 19/04/2017
     * @autor: Paul Salgado
     * @param:
     * @return: List<EstadoUsuario>
     */
    public List<EstadoUsuario> listarEstadoUsuario(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<EstadoUsuario> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_ESTADO_USUARIO);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (List<EstadoUsuario>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method: ".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * listarOficina()
     * Metodo que devuelve una lista de oficinas
     * 19/04/2017
     * @autor: Paul Salgado
     * @param:
     * @return: List<Oficina>
     */
    public List<Oficina> listarOficina(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Oficina> oficinas = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_ALL_OFICINA);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            oficinas = (List<Oficina>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return oficinas;
    }

    /**
     * @return
     */
    public List<Horario> listarHorario(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Horario> horarios = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_ALL_HORARIO);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            horarios = (List<Horario>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return horarios;
    }

    /**
     * @param idEstadoUsuario
     * @return
     */
    public List<Usuario> listarUsuariosPorEstadoUsuario(int idEstadoUsuario ){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Usuario> usuarios = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_USUARIO_BY_ESTADO);
            peticionRespuesta.setParameters(new Object[]{idEstadoUsuario});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            usuarios = (List<Usuario>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return usuarios;
    }

    /**
     * @return
     */
    public Map<String, Object> listarCargo(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_ALL_CARGO);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * @param values
     * @return
     */
    public Map<String, Object> procUsuarioInsertar(HashMap<String, Object> values){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_USUARIO_INSERTAR);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * @param values
     * @return
     */
    public Map<String, Object> procUsuarioValidacionesFormulario(HashMap<String, Object> values){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_USUARIO_VALIDAR_FORMULARIO);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     *
     * @param values
     * @return
     */
    public Map<String, Object> procUsuarioActualizar(HashMap<String, Object> values){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_USUARIO_ACTUALIZAR);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    public Map<String, Object> procUsuarioSolicitudCambioClave(Usuario usuario) throws IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            Map<String, Object> values = new HashMap<>();
            values.put(IsspolConstant.AS_CORREO, usuario.getEmail());
            values.put(IsspolConstant.AS_DATO, Util.generarToken(usuario.getEmail().concat(usuario.getModificaFecha().toString())));
            values.put(IsspolConstant.AS_CODIGO_TIPO_TOKEN, IsspolConstant.TIPO_TOKEN_CAMBIO_CONTRASENA);
            values.put(IsspolConstant.AS_CODIGO_PROCESO_NOTIFICACION, IsspolConstant.PROCESO_NOT_CAMBIO_CONTRASENA);
            values.put(IsspolConstant.AS_USUARIO, usuario.getIdUsuario());
            values.put(IsspolConstant.AD_FECHA, usuario.getModificaFecha());
            values.put(IsspolConstant.AS_EQUIPO, usuario.getModificaEquipo());

            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_USUARIO_SOLICITUD_CAMBIO_CLAVE);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
            throw  e;
        }
        return response;
    }

    public Token buscarTokenPorDato(String dato) throws IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Token token = new Token();
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_TOKEN_PORDATO);
        peticionRespuesta.setParameters(new Object[]{dato});
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        token = (Token) peticionRespuesta.getResullt();
        if(peticionRespuesta.getException() != null)
            throw new IsspolException(peticionRespuesta.getException());
        return token;
    }

    public Map<String, Object> procUsuarioCambiarClave(HashMap<String, Object> parametros) throws IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            Map<String, Object> values = new HashMap<>();
            Usuario usuario = (Usuario) parametros.get(IsspolConstant.AI_USUARIO);
            values.put(IsspolConstant.AS_TOKEN, parametros.get(IsspolConstant.AS_TOKEN));
            values.put(IsspolConstant.AS_USU_CLAVE, parametros.get(IsspolConstant.AS_USU_CLAVE));
            values.put(IsspolConstant.AS_USUARIO, usuario.getIdUsuario());
            values.put(IsspolConstant.AD_FECHA, usuario.getModificaFecha());
            values.put(IsspolConstant.AS_EQUIPO, usuario.getModificaEquipo());

            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_USUARIO_CAMBIAR_CLAVE);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
            throw  e;
        }
        return response;
    }

    public Usuario buscarUsuarioporId(String idUsuario ){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Usuario usuario = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_USUARIO_ID);
            peticionRespuesta.setParameters(new Object[]{idUsuario});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            usuario = (Usuario) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return usuario;
    }

    public Map<String, Object> procUsuarioVerificarBloqueo(Usuario usuario) throws IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            Map<String, Object> values = new HashMap<>();
            values.put(IsspolConstant.AB_MANUAL, Boolean.TRUE);
            values.put(IsspolConstant.AI_USUARIO, usuario.getIdUsuario());
            values.put(IsspolConstant.AS_USUARIO, usuario.getIdUsuario());
            values.put(IsspolConstant.AD_FECHA, usuario.getModificaFecha());
            values.put(IsspolConstant.AS_EQUIPO, usuario.getModificaEquipo());

            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_USUARIO_VERIFICAR_BLOQUEO);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
            throw  e;
        }
        return response;
    }

    public Map<String, Object> procEstructuraOrganizacionalGuardar(HashMap<String, Object> values){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_ESTRUCTURA_ORGANIZACIONAL_GUARDAR);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    public Map<String, Object> procEstructuraOrganizacionalEliminar(HashMap<String, Object> values){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_ESTRUCTURA_ORGANIZACIONAL_ELIMINAR);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * @title Actualizar Usuario
     * @description Actualizar Usuario usando el DAO
     * @author carlos.calo
     * @date 19/04/2017
     * @param usuario NOT NULL
     */
    public void actualizarUsuario(Usuario usuario){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_UPDATE_USUARIO);
            peticionRespuesta.setParameters(new Object[]{usuario});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
    };

    /**
     * Métodos para administrar Grupo(Rol) by EA, Fecha: 2017-04-13
     */

    /**
     * Inserta un
     * @return
     */
    public Map<String, Object> insertarActualizarGrupo(Grupo grupo){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METODO_INSERTAR_ACTUALIZAR_GRUPO);
            peticionRespuesta.setParameters(new Object[]{grupo});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    public Map<String, Object> eliminarGrupo(Grupo grupo){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METODO_ELIMINAR_GRUPO);
            peticionRespuesta.setParameters(new Object[]{grupo});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    public List<Grupo> listarTodos(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Grupo> grupos = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_TODOS_GRUPOS);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            grupos = (List<Grupo>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return grupos;
    }

    public Grupo buscarGrupoPorNombre(String nombre){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Grupo grupo = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METODO_BUSCAR_GRUPO_POR_NOMBRE);
            peticionRespuesta.setParameters(new Object[]{nombre});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            grupo = (Grupo) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return grupo;
    }

    public Grupo buscarGrupoPorId(int idGrupo){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Grupo grupo = null;;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METODO_BUSCAR_GRUPO_POR_ID);
            peticionRespuesta.setParameters(new Object[]{idGrupo});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            grupo = (Grupo) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return grupo;
    }

    public PagedResult<Grupo> listarGrupoPaginado(FilterParam filterParam){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PagedResult pagedResult = null;
        try{
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_GRUPO_PAGINADO);
            peticionRespuesta.setParameters(new Object[]{filterParam});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            pagedResult = (PagedResult) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        }catch (IsspolException e){
            logger.error("Error llamando al método: ".concat(IsspolConstant.METODO_LISTAR_GRUPO_PAGINADO), e);
        }
        return  pagedResult;
    }


    /**
     * Creado por Andres Campoverde : 17-04-2017
     * @param values
     * @return
     */
    public Map<String, Object> verificarSesion(HashMap<String, Object> values) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_VERIFICAR_SESION_USUARIO);
            peticionRespuesta.setParameters(new Object[]{values});
            response = (Map<String, Object>) usuarioService.callRemoteService(peticionRespuesta);
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * Creado por Andres Campoverde : 17-04-2017
     * @param values
     * @return
     */
    public Map<String, Object> validarClaveUsuario(HashMap<String, Object> values) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_USUARIO_VALIDA_CLAVE);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta=usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }


    /**
     * Creado por Andres Campoverde : 17-04-2017
     * @param values
     * @return
     */
    public Map<String, Object> obtenerInformacionSesion(HashMap<String, Object> values) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_USUARIO_OBTENER_INFORMACION_SESION);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta=usuarioService.callRemoteService(peticionRespuesta);
            response= (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * Creador por Andres Campoverde : 18-04-2017
     * @param values
     * @return
     */
    public Map<String,Object>obtenerListaFavoritos(HashMap<String,Object>values) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_FAVORITOS_LISTA);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta=usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    public Map<String,Object>obtenerOficinaNombreOficina(HashMap<String,Object>values) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_OBTENER_OFICINA_NOMBRE_OFICINA);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta=usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    public Map<String,Object>obtenerSucursalOficina(HashMap<String,Object>values) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_OBTENER_SUCURSAL_OFICINA);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta=usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    public Map<String, Object> obtenerCarpetaOpcionPorGrupo(HashMap<String, Object> values) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_OBTENER_CARPETA_OPCION_GRUPO);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta=usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    public Map<String, Object> obtenerOpcionUsoFrecuentes(HashMap<String, Object> values) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_OBTENER_OPCION_USO_FRECUENTE);
            peticionRespuesta.setParameters(new Object[]{values});
            peticionRespuesta=usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    // INICIO METODOS Mavelin Ati
    //-------------------------------------------------------------------------------------------------
    /**
     * @title Insertar Estacion
     * @description Crea un nuevo registro Estacion
     * @author mavelin.ati
     * @date 21/04/2017
     * @param estacion NOT NULL
     */
    public Map<String, Object> insertarEstacion(Estacion estacion){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_INSERTAR_ESTACION);
            peticionRespuesta.setParameters(new Object[]{estacion});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * @title Actualizar Estacion
     * @description Actualiza un registro Estacion
     * @author mavelin.ati
     * @date 21/04/2017
     * @param estacion NOT NULL
     */
    public Map<String, Object> actualizarEstacion(Estacion estacion){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_ACTUALIZAR_ESTACION);
            peticionRespuesta.setParameters(new Object[]{estacion});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * @title Listar todos Estacion
     * @description Lista todos los registros Estacion
     * @author mavelin.ati
     * @date 21/04/2017
     * @param
     */
    public List<Estacion> listarTodosEstacion(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Estacion> estacions = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_TODOS_ESTACION);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            estacions = (List<Estacion>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);}
        return estacions;
    }

    /**
     * @title Buscar Estacion por Id
     * @description Buscar un registro Estacion por el idEstacion
     * @author mavelin.ati
     * @date 21/04/2017
     * @param id NOT NULL
     */
    public Estacion buscarEstacionPorId(Integer id) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Estacion estacion = new Estacion();
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_ESTACION_PORID);
            peticionRespuesta.setParameters(new Object[]{id});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            estacion = (Estacion) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return estacion;
    }

    /**
     * @title Listar Estacion No eliminado
     * @description listar los registros de Estacion no eliminados con paginacion
     * @author mavelin.ati
     * @date 21/04/2017
     * @param
     */
    public PagedResult<Estacion> listarEstacionNoEliminado(FilterParam filterParam)
            throws IsspolSearchException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PagedResult pagedResult = null;

        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_ESTACION_NO_ELIMINADO);
            peticionRespuesta.setParameters(new Object[]{filterParam});
            peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
            pagedResult = (PagedResult) peticionRespuesta.getResullt();
            if (peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return pagedResult;
    }

    /**
     * @title Insertar Estacion-Usuario
     * @description Crea un nuevo registro Estacion-Usuario
     * @author mavelin.ati
     * @date 19/04/2017
     * @param estacionUsuario NOT NULL
     */
    public Map<String, Object> insertarEstacionUsuario(EstacionUsuario estacionUsuario){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_INSERTAR_ESTACION_USUARIO);
            peticionRespuesta.setParameters(new Object[]{estacionUsuario});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response= (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * @title Actualizar Estacion-Usuario
     * @description Actualiza un registro Estacion-Usuario
     * @author mavelin.ati
     * @date 19/04/2017
     * @param estacionUsuario NOT NULL
     */
    public Map<String, Object> actualizarEstacionUsuario(EstacionUsuario estacionUsuario){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_ACTUALIZAR_ESTACION_USUARIO);
            peticionRespuesta.setParameters(new Object[]{estacionUsuario});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * @title Listar todos Estacion-Usuario
     * @description Lista todos los registros Estacion-Usuario
     * @author mavelin.ati
     * @date 19/04/2017
     * @param
     */
    public List<EstacionUsuario> listarTodosEstacionUsuario(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<EstacionUsuario> estacionUsuarios = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_TODOS_ESTACION_USUARIO);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            estacionUsuarios = (List<EstacionUsuario>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);}
        return estacionUsuarios;
    }

    /**
     * @title Buscar Estacion-Usuario por Id
     * @description Buscar un registro Estacion-Usuario por el idEstacionUsuario
     * @author mavelin.ati
     * @date 19/04/2017
     * @param id NOT NULL
     */
    public EstacionUsuario buscarEstacionUsuarioPorId(Integer id) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        EstacionUsuario estacionUsuario = new EstacionUsuario();
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_ESTACION_USUARIO_PORID);
            peticionRespuesta.setParameters(new Object[]{id});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            estacionUsuario = (EstacionUsuario) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return estacionUsuario;
    }

    /**
     * @title Listar Estacion-Usuario por Usuario
     * @description Lista los registros Estacion-Usuario por idUsuario
     * @author mavelin.ati
     * @date 19/04/2017
     * @param
     */
    public List<EstacionUsuario> listarEstacionUsuarioPorUsuario(String idUsuario){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<EstacionUsuario> estacionUsuarios = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_ESTACION_USUARIO_POR_USUARIO);
            peticionRespuesta.setParameters(new Object[]{idUsuario});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            estacionUsuarios = (List<EstacionUsuario>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);}
        return estacionUsuarios;
    }

    /**
     * @title Listar EstacionUsuario No eliminado por idUsuario
     * @description listar los registros de EstacionUsuario no eliminados con paginacion, segun el usuario
     * @author mavelin.ati
     * @date 21/04/2017
     * @param
     */
    public PagedResult<EstacionUsuario> listarEstacionUsuarioNoEliminadoPorUsuario(String idUsuario, FilterParam filterParam)
            throws IsspolSearchException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PagedResult pagedResult = null;

        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_ESTACION_USUARIO_NO_ELIMINADO_POR_USUARIO);
            peticionRespuesta.setParameters(new Object[]{idUsuario, filterParam});
            peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
            pagedResult = (PagedResult) peticionRespuesta.getResullt();
            if (peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return pagedResult;
    }

    /**
     * @title Insertar Grupo-Usuario
     * @description Crea un nuevo registro Grupo-Usuario
     * @author mavelin.ati
     * @date 19/04/2017
     * @param grupoUsuario NOT NULL
     */
    public Map<String, Object> insertarGrupoUsuario(GrupoUsuario grupoUsuario){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_INSERTAR_GRUPO_USUARIO);
            peticionRespuesta.setParameters(new Object[]{grupoUsuario});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * @title Actualizar Grupo-Usuario
     * @description Actualiza un registro Grupo-Usuario
     * @author mavelin.ati
     * @date 19/04/2017
     * @param grupoUsuario NOT NULL
     */
    public Map<String, Object> actualizarGrupoUsuario(GrupoUsuario grupoUsuario){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_ACTUALIZAR_GRUPO_USUARIO);
            peticionRespuesta.setParameters(new Object[]{grupoUsuario});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * @title Listar todos Grupo-Usuario
     * @description Lista todos los registros Grupo-Usuario
     * @author mavelin.ati
     * @date 19/04/2017
     * @param
     */
    public List<GrupoUsuario> listarTodosGrupoUsuario(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<GrupoUsuario> grupoUsuarios = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_TODOS_GRUPO_USUARIO);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            grupoUsuarios = (List<GrupoUsuario>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);}
        return grupoUsuarios;
    }

    /**
     * @title Buscar Grupo-Usuario por Id
     * @description Buscar un registro Grupo-Usuario por el idGrupoUsuario
     * @author mavelin.ati
     * @date 19/04/2017
     * @param id NOT NULL
     */
    public GrupoUsuario buscarGrupoUsuarioPorId(Integer id){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        GrupoUsuario grupoUsuario = new GrupoUsuario();
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_GRUPO_USUARIO_PORID);
            peticionRespuesta.setParameters(new Object[]{id});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            grupoUsuario = (GrupoUsuario)peticionRespuesta.getResullt();
            
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return grupoUsuario;
    }

    /**
     * @title Listar Grupo-Usuario por Usuario
     * @description Lista todos los registros Grupo-Usuario por el idUsuario
     * @author mavelin.ati
     * @date 19/04/2017
     * @param
     */
    public List<GrupoUsuario> listarGrupoUsuarioPorUsuario(String idUsuario){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<GrupoUsuario> grupoUsuarios = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_GRUPO_USUARIO_POR_USUARIO);
            peticionRespuesta.setParameters(new Object[]{idUsuario});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            grupoUsuarios = (List<GrupoUsuario>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);}
        return grupoUsuarios;
    }

    /**
     * @title Listar GrupoUsuario No eliminado por idUsuario
     * @description listar los registros de GrupoUsuario no eliminados con paginacion, segun el usuario
     * @author mavelin.ati
     * @date 21/04/2017
     * @param
     */
    public PagedResult<GrupoUsuario> listarGrupoUsuarioNoEliminadoPorUsuario(String idUsuario, FilterParam filterParam)
            throws IsspolSearchException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PagedResult pagedResult = null;

        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_GRUPO_USUARIO_NO_ELIMINADO_POR_USUARIO);
            peticionRespuesta.setParameters(new Object[]{idUsuario, filterParam});
            peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
            pagedResult = (PagedResult) peticionRespuesta.getResullt();
            if (peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return pagedResult;
    }

    /**
     * @title Insertar Usuario-Oficina
     * @description Crea un nuevo registro Usuario-Oficina
     * @author mavelin.ati
     * @date 05/05/2017
     * @param usuarioOficina NOT NULL
     */
    public Map<String, Object> insertarUsuarioOficina(UsuarioOficina usuarioOficina){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_INSERTAR_USUARIO_OFICINA);
            peticionRespuesta.setParameters(new Object[]{usuarioOficina});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response= (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }


    /**
     * @title Actualizar Usuario-Oficina
     * @description Actualiza un registro Usuario-Oficina
     * @author mavelin.ati
     * @date 05/05/2017
     * @param usuarioOficina NOT NULL
     */
    public Map<String, Object> actualizarUsuarioOficina(UsuarioOficina usuarioOficina){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_ACTUALIZAR_USUARIO_OFICINA);
            peticionRespuesta.setParameters(new Object[]{usuarioOficina});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            response = (Map<String, Object>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return response;
    }

    /**
     * @title Listar todos Usuario-Oficina
     * @description Lista todos los registros Usuario-Oficina
     * @author mavelin.ati
     * @date 05/05/2017
     * @param
     */
    public List<UsuarioOficina> listarTodosUsuarioOficina(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<UsuarioOficina> usuarioOficinas = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_TODOS_USUARIO_OFICINA);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            usuarioOficinas = (List<UsuarioOficina>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);}
        return usuarioOficinas;
    }

    /**
     * @title Buscar Usuario-Oficina por Id
     * @description Buscar un registro Usuario-Oficina por el idUsuarioOficina
     * @author mavelin.ati
     * @date 05/05/2017
     * @param id NOT NULL
     */
    public UsuarioOficina buscarUsuarioOficinaPorId(Integer id) {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        UsuarioOficina usuarioOficina = new UsuarioOficina();
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_USUARIO_OFICINA_PORID);
            peticionRespuesta.setParameters(new Object[]{id});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            usuarioOficina = (UsuarioOficina) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return usuarioOficina;
    }

    /**
     * @title Listar Usuario-Oficina por Usuario
     * @description Lista los registros Usuario-Oficina por idUsuario
     * @author mavelin.ati
     * @date 05/05/2017
     * @param
     */
    public List<UsuarioOficina> listarUsuarioOficinaPorUsuario(String idUsuario){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<UsuarioOficina> usuarioOficinas = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_USUARIO_OFICINA_POR_USUARIO);
            peticionRespuesta.setParameters(new Object[]{idUsuario});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            usuarioOficinas = (List<UsuarioOficina>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);}
        return usuarioOficinas;
    }

    /**
     * @title Listar UsuarioOficina No eliminado por idUsuario
     * @description listar los registros de UsuarioOficina no eliminados con paginacion, segun el usuario
     * @author mavelin.ati
     * @date 21/04/2017
     * @param
     */
    public PagedResult<UsuarioOficina> listarUsuarioOficinaNoEliminadoPorUsuario(String idUsuario, FilterParam filterParam)
            throws IsspolSearchException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PagedResult pagedResult = null;

        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_USUARIO_OFICINA_NO_ELIMINADO_POR_USUARIO);
            peticionRespuesta.setParameters(new Object[]{idUsuario, filterParam});
            peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
            pagedResult = (PagedResult) peticionRespuesta.getResullt();
            if (peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(peticionRespuesta.getMethod()), e);
        }
        return pagedResult;
    }

    // FIN METODOS Mavelin Ati
    //------------------------------------------------------------------------------------------------------

}
