package ec.org.isspol.common;

/**
 * Created by mauchilan on 24/3/17.
 */
public class IsspolConstant {

    /***
     * Campos para SMTP
     * @author carlos.calo
     * @date 25/04/2017
     */
    public final static String TIMEOUT_SMTP = "TIMEOUT_SMTP";
    public final static String USER_SMTP = "USER_SMTP";
    public final static String PASSWORD_SMTP = "PASSWORD_SMTP";
    public final static String HOST_SMTP = "HOST_SMTP";
    public final static String PORT_SMTP = "PORT_SMTP";
    public final static String FROM_SMTP = "FROM_SMTP";
    public final static String AUTH_SMTP = "AUTH_SMTP";
    public final static String TLS_SMTP = "TLS_SMTP";

    /**
     * Identificador para Proceso de Notificacion
     */
    public final static String PROCESO_NOT_CAMBIO_CONTRASENA = "cambio-contrasena";


    public final static String METHOD_GET_ALL_OFICINA = "listarOficina";
    public final static String METHOD_GET_ALL_USUARIO = "listarUsuario";
    public final static String METHOD_GET_ALL_HORARIO = "listarHorario";
    public final static String METHOD_GET_ALL_CARGO = "listarCargo";
    public final static String METHOD_GET_USUARIO_BY_ESTADO = "listarUsuariosPorEstadoUsuario";
    public final static String METHOD_GET_ESTADO_USUARIO = "listarEstadoUsuario";
    public final static String METHOD_GET_ALL_ESTRUCUTURA = "listaEstructuraOrganizacional";
    public final static String METHOD_GET_ALL_ESTRUCUTURANIVEL = "listarEstrOrganizacional";
    public final static String METHOD_LISTA_NIVEL_ESTRUCUTURA_ORG = "listarTodosNivelEstructuraOrg";

    public final static String METHOD_PROC_ESTRUCTURA_ORGANIZACIONAL_GUARDAR= "procEstructuraOrganizacionalGuardar";
    public final static String METHOD_PROC_ESTRUCTURA_ORGANIZACIONAL_ELIMINAR = "procEstructuraOrganizacionalEliminar";
    public final static String METHOD_PROC_USUARIO_ACTUALIZAR = "procUsuarioActualizar";
    public final static String METHOD_PROC_USUARIO_SOLICITUD_CAMBIO_CLAVE = "procUsuarioSolicitudCambioClave";

    public final static String METHOD_PROC_USUARIO_INSERTAR = "procUsuarioInsertar";
    public final static String METHOD_PROC_USUARIO_VALIDAR_FORMULARIO = "procUsuarioValidarFormulario";
    public final static String METHOD_BUSCAR_TOKEN_PORDATO = "buscarTokenPorDato";
    public final static String METHOD_UPDATE_USUARIO = "actualizarUsuario";

    //agregados por Andres Campoverde el 17-04-2017
    public final static String METHOD_VERIFICAR_SESION_USUARIO = "verificarSesion";
    public final static String METHOD_USUARIO_VALIDA_CLAVE = "validarClaveUsuario";
    public final static String METHOD_USUARIO_OBTENER_INFORMACION_SESION = "obtenerInformacionSesion";

    //agregados por Andres Campoverde el 18-04-2017
    public final static String METHOD_LISTA_PAISES = "listaPaises";
    public final static String METHOD_PROC_FECHAHORASISTEMA = "fechaHoraSistema";
    public final static String METHOD_FAVORITOS_LISTA = "obtenerListaFavoritos";
    public final static String METHOD_PROC_LOG = "logAuditoria";
    public final static String METHOD_OBTENER_OFICINA_NOMBRE_OFICINA = "obtenerOficinaNombreOficina";
    public final static String METHOD_OBTENER_SUCURSAL_OFICINA = "obtenerSucursalOficina";
    public final static String METHOD_OBTENER_CARPETA_OPCION_GRUPO = "obtenerCarpetaOpcionPorGrupo";
    public final static String METHOD_OBTENER_OPCION_USO_FRECUENTE = "obtenerOpcionUsoFrecuentes";
    public final static String METHOD_BUSCAR_USUARIO_ID = "buscarUsuarioPorId";
    public final static String METHOD_BUSCAR_OFICINA_ID="buscarOficinaPorId";

    /**
     * Constantes de la entidad Grupo (Rol), para identificar los métodos para el mantenimiento
     * Fecha: 2017-04-13
     *
     * @autor Edison Aulestia
     **/
    public final static String METODO_LISTAR_TODOS_GRUPOS = "listarTodos";
    public final static String METODO_BUSCAR_GRUPO_POR_NOMBRE = "buscarGrupoPorNombre";
    public final static String METODO_BUSCAR_GRUPO_POR_ID = "buscarGrupoPorId";
    public final static String METODO_BUSCAR_USUARIO_X_ID = "buscarUsuarioxId";
    public final static String METODO_INSERTAR_ACTUALIZAR_GRUPO = "insertarActualizarGrupo";
    public final static String METODO_ELIMINAR_GRUPO = "eliminarGrupo";
    public final static String METODO_LISTAR_GRUPO_PAGINADO = "listarGrupoPaginado";

    /**
     * Constantes CRUD del mantenimiento Estacion
     */
    public final static String METHOD_INSERTAR_ESTACION = "insertarEstacion";
    public final static String METHOD_ACTUALIZAR_ESTACION = "actualizarEstacion";
    public final static String METHOD_LISTAR_TODOS_ESTACION = "listarTodosEstacion";
    public final static String METHOD_BUSCAR_ESTACION_PORID = "buscarEstacionPorId";
    public final static String METHOD_LISTAR_ESTACION_NO_ELIMINADO = "listarEstacionNoEliminado";

    /**
     * Constantes CRUD del mantenimiento Estacion-Usuario
     */
    public final static String METHOD_INSERTAR_ESTACION_USUARIO = "insertarEstacionUsuario";
    public final static String METHOD_ACTUALIZAR_ESTACION_USUARIO = "actualizarEstacionUsuario";
    public final static String METHOD_LISTAR_TODOS_ESTACION_USUARIO = "listarTodosEstacionUsuario";
    public final static String METHOD_BUSCAR_ESTACION_USUARIO_PORID = "buscarEstacionUsuarioPorId";
    public final static String METHOD_LISTAR_ESTACION_USUARIO_POR_USUARIO = "listarEstacionUsuarioPorUsuario";
    public final static String METHOD_LISTAR_ESTACION_USUARIO_NO_ELIMINADO_POR_USUARIO = "listarEstacionUsuarioNoEliminadoPorUsuario";

    /**
     * Constantes CRUD del mantenimiento Grupo-Usuario
     */
    public final static String METHOD_INSERTAR_GRUPO_USUARIO = "insertarGrupoUsuario";
    public final static String METHOD_ACTUALIZAR_GRUPO_USUARIO = "actualizarGrupoUsuario";
    public final static String METHOD_LISTAR_TODOS_GRUPO_USUARIO = "listarTodosGrupoUsuario";
    public final static String METHOD_BUSCAR_GRUPO_USUARIO_PORID = "buscarGrupoUsuarioPorId";
    public final static String METHOD_LISTAR_GRUPO_USUARIO_POR_USUARIO = "listarGrupoUsuarioPorUsuario";
    public final static String METHOD_LISTAR_GRUPO_USUARIO_NO_ELIMINADO_POR_USUARIO = "listarGrupoUsuarioNoEliminadoPorUsuario";

    /**
     * Constantes CRUD del mantenimiento Usuario-Oficina
     */
    public final static String METHOD_INSERTAR_USUARIO_OFICINA = "insertarUsuarioOficina";
    public final static String METHOD_ACTUALIZAR_USUARIO_OFICINA = "actualizarUsuarioOficina";
    public final static String METHOD_LISTAR_TODOS_USUARIO_OFICINA = "listarTodosUsuarioOficina";
    public final static String METHOD_BUSCAR_USUARIO_OFICINA_PORID = "buscarUsuarioOficinaPorId";
    public final static String METHOD_LISTAR_USUARIO_OFICINA_POR_USUARIO = "listarUsuarioOficinaPorUsuario";
    public final static String METHOD_LISTAR_USUARIO_OFICINA_NO_ELIMINADO_POR_USUARIO = "listarUsuarioOficinaNoEliminadoPorUsuario";


    /**
     * Constantes CRUD del mantenimiento Carpeta-Opcion
     */
    public static final String METHOD_INSERTAR_CARPETA_OPCION = "insertarCarpetaOpcion";
    public static final String METHOD_ACTUALIZAR_CARPETA_OPCION = "actualizarCarpetaOpcion";
    public static final String METHOD_ELIMINAR_CARPETA_OPCION = "eliminarCarpetaOpcion";

    public static final String METHOD_INSERTAR_OPCION = "insertarOpcion";
    public static final String METHOD_ACTUALIZAR_OPCION = "actualizarOpcion";
    public static final String METHOD_ELIMINAR_OPCION = "eliminarOpcion";

    public static final String METHOD_LISTAR_CARPETA_OPCION = "listarCarpetaOpcion";
    public static final String METHOD_LISTAR_OPCION = "listarOpcion";
    public static final String METHOD_LISTAR_ICONO = "listarIcono";

    public static final String METHOD_BUSCAR_CARPETA_OPCION_POR_ID = "buscarCarpetaOpcionPorId";
    public static final String METHOD_BUSCAR_OPCION_POR_ID = "buscarOpcionPorId";
    public static final String METHOD_BUSCAR_ICONO_POR_ID = "buscarIconoPorId";

    public static final String METHOD_LISTAR_CARPETA_OPCION_POR_ID_CARPETA_PADRE = "listarCarpetaOpcionPorIdCarpetaPadre";
    public static final String METHOD_LISTAR_OPCION_POR_ID_CARPETA_OPCION = "listarOpcionPorIdCarpetaOpcion";

    /**
     * Constantes del Procedimiento Almacenado Seguridad.ProcUsuarioInsertar
     */
    public final static String PROC_USUARIO_INSERTAR = "seguridad.proc_usuario_insertar";
    public final static String AS_USU_USUARIO = "AS_USU_USUARIO";
    public final static String AI_ID_OFICINA = "AI_ID_OFICINA";
    public final static String AI_ID_PERSONA_SUBTIPO_AFILIACION = "AI_ID_PERSONA_SUBTIPO_AFILIACION";
    public final static String AI_ESTADO = "AI_ESTADO";
    public final static String AS_EMAIL = "AS_EMAIL";
    public final static String AS_IDENTIFICACION = "AS_IDENTIFICACION";
    public final static String AI_SECUENCIAL = "AI_SECUENCIAL";
    public final static String AB_CUALQUIER_ESTACION = "AB_CUALQUIER_ESTACION";
    public final static String AI_ID_HORARIO = "AI_ID_HORARIO";
    public final static String AI_ID_ESTRUCTURA = "AI_ID_ESTRUCTURA";
    public final static String AS_USUARIO_SUPERIOR = "AS_USUARIO_SUPERIOR";
    public final static String AI_ID_DASHBOARD_INICIO = "AI_ID_DASHBOARD_INICIO";
    public final static String AS_USUARIO = "AS_USUARIO";
    public final static String AS_DIRECCION_FISICA = "AS_DIRECCION_FISICA";
    public final static String AS_ESTADO = "AS_ESTADO";
    public final static String AS_MSJ = "AS_MSJ";

    /**
     * Constantes del Procedimiento Almacenado Seguridad.ProcUsuarioValidarFormulario
     */
    public final static String PROC_USUARIO_VALIDAR_FORMULARIO = "seguridad.proc_usuario_validar_formulario";
    public final static String AI_IDPERSONASUBTIPO = "AI_IDPERSONASUBTIPO";
    public final static String AS_APELLIDOPATERNO = "AS_APELLIDOPATERNO";
    public final static String AS_APELLIDOMATERNO = "AS_APELLIDOMATERNO";
    public final static String AS_NOMBRES = "AS_NOMBRES";
    public final static String AS_IDUSUARIO = "AS_IDUSUARIO";
    public final static String AS_CORREO = "AS_CORREO";

    /**
     * Constantes del Procedimiento Almacendado Seguridad.ProcUsuarioActualizar
     */
    public final static String PROC_USUARIO_ACTUALIZAR = "seguridad.proc_usuario_actualizar";
    public final static String AS_OFICINA = "AS_OFICINA";
    public final static String AS_NOMBRE = "AS_NOMBRE";
    public final static String AB_CAMBIAR_PWD_PRX_LOGON = "AB_CAMBIAR_PWD_PRX_LOGON";
    public final static String AB_NO_PUEDE_CAMBIAR_PWD = "AB_NO_PUEDE_CAMBIAR_PWD";
    public final static String AB_PWD_NUNCA_EXPIRA = "AB_PWD_NUNCA_EXPIRA";
    public final static String AB_BLOQUEADA = "AB_BLOQUEADA";
    public final static String AI_ID = "AI_ID";
    public final static String AI_TIEMPO_INACTIVIDAD = "AI_TIEMPO_INACTIVIDAD";
    public final static String AS_USUARIO_ACT = "AS_USUARIO_ACT";

    public final static String PROC_DDDW_ESTRUCTURA_ORGANIZACIONAL = "seguridad.proc_dddw_estructura_organizacional";

    /**
     * Constantes para CRUD del mantenimiento de sucursales
     */
    public final static String METODO_INSERTAR_SUCURSAL = "insertarSucursal";
    public final static String METODO_ACTUALIZAR_SUCURSAL = "actualizarSucursal";
    public final static String METODO_ELIMINAR_SUCURSAL = "eliminarSucursal";
    public final static String METODO_LISTAR_TODAS_SUCURSAL = "listarTodasSucursales";
    public final static String METODO_BUSCAR_SUCURSAL_POR_ID = "buscarSucursalPorId";
    public final static String METODO_LISTAR_SUCURSAL_PAGINADO = "listarSucursalPaginado";

    /**
     * Constantes para el mantenimiento de Estructura Organizacional
     */

    public final static String PROC_ESTRUCTURA_ORGANIZACIONAL_GUARDAR = "seguridad.proc_estructura_organizacional_guardar";
    public final static String PROC_ESTRUCTURA_ORGANIZACIONAL_ELIMINAR = "seguridad.proc_estructura_organizacional_borrar";


    /**
     * Constantes del Procedimiento Almacendado Seguridad.ProcUsuarioActualizar
     */

    public final static String AI_ID_ESTRUCTURA_PADRE = "AI_ID_ESTRUCTURA_PADRE";
    public final static String AI_NIVEL = "AI_NIVEL";
    public final static String AI_ORDEN = "AI_ORDEN";
    public final static String AS_DESCRIPCION = "AS_DESCRIPCION";
    public final static String AS_CODIGO = "AS_CODIGO";

    //agregados por Andres Campoverde el 17-04-2017
    public final static String PROC_VERIFICAR_SESION_USUARIO = "seguridad.proc_verificar_sesion_usuario";

    /**
     * Constantes para Procedimiento Almacenado Seguridad.proc_usuario_valida_clave
     */
    public final static String PROC_USUARIO_VALIDA_CLAVE = "seguridad.proc_usuario_valida_clave";
    public final static String AB_VALIDA_HOSTNAME = "AB_VALIDA_HOSTNAME";
    public final static String AS_HOSTNAME = "AS_HOSTNAME";
    public final static String AS_CLAVE = "AS_CLAVE";
    public final static String AI_USUARIO = "AI_USUARIO";
    public final static String AB_REQ_CAMBIO_PWD = "AB_REQ_CAMBIO_PWD";

    public final static String PROC_USUARIO_OBTENER_INFORMACION_SESION = "seguridad.proc_usuario_obtener_informacion_sesion";


    /**
     * Constantes para Procedimiento Almacenado Comun.proc_fechahorasistema
     */
    public final static String PROC_FECHAHORASISTEMA = "comun.proc_fechahorasistema";
    public final static String FECHA = "FECHA";

    /**
     * Constantes para Procedimiento Almacenado Seguridad.proc_favorito_lista
     */
    public final static String PROC_FAVORITO_LISTA = "seguridad.proc_favorito_lista";

    /**
     * Constantes para Procedimiento Almacenado auditoria.proc_log
     */
    public final static String PROC_LOG = "auditoria.proc_log";
    public final static String AS_REFERENCIA = "AS_REFERENCIA";
    public final static String AS_TIPO = "AS_TIPO";
    public final static String AS_MAQUINA = "AS_MAQUINA";
    public final static String AS_APLICACION = "AS_APLICACION";

    /**
     * Constantes para CRUD del mantenimiento de usuariosOficina
     */
    public final static String METODO_INSERTAR_USUARIO_OFICINA = "insertarUsuarioOficina";
    public final static String METODO_LISTAR_TODAS_USUARIO_OFICINA = "listarTodasUsuarioOficinas";
    public final static String METODO_BUSCAR_USUARIO_OFICINA_POR_ID = "buscarUsuarioOficinaPorId";
    public final static String METODO_LISTAR_USUARIO_OFICINA_POR_USUARIO = "listarUsuarioOficinaPorUsuario";


    /**
     * Constantes para procedimiento almacenado seguridad.proc_usuario_obtener_oficina_nombre_oficina
     */
    public final static String AS_SUCURSAL = "AS_SUCURSAL";
    public final static String PROC_USUARIO_OBTENER_OFICINA_NOMBRE_OFICINA = "seguridad.proc_usuario_obtener_oficina_nombre_oficina";

    public final static String PROC_USUARIO_OBTENER_SUCURSAL_OFICINA = "seguridad.proc_usuario_obtener_sucursal_oficina";

    /**
     * Constantes para procedimiento almacenado seguridad.proc_carpeta_opcion_por_grupo
     */
    public final static String PROC_CARPETA_OPCION_POR_GRUPO = "seguridad.proc_carpeta_opcion_por_grupo";
    public final static String AS_GRUPO = "AS_GRUPO";

    public final static String PROC_OPCION_USO_FRECUENTE = "seguridad.proc_opcion_uso_frecuente";

    /**
     * Constantes para procedimiento almacenado seguridad.proc_usuario_solicitud_cambio_clave
     */
    public final static String PROC_USUARIO_SOLICITUD_CAMBIO_CLAVE = "seguridad.proc_usuario_solicitud_cambio_clave";
    public final static String AS_DATO = "AS_DATO";
    public final static String AS_CODIGO_TIPO_TOKEN = "AS_CODIGO_TIPO_TOKEN";
    public final static String AS_CODIGO_PROCESO_NOTIFICACION = "AS_CODIGO_PROCESO_NOTIFICACION";
    public final static String AD_FECHA = "AD_FECHA";
    public final static String AS_EQUIPO = "AS_EQUIPO";
    public final static String TIPO_TOKEN_CAMBIO_CONTRASENA = "cambio-contrasena";

    /**
     * Constantes para procedimiento almacenado seguridad.proc_usuario_cambiar_clave
     */
    public final static String METHOD_PROC_USUARIO_CAMBIAR_CLAVE = "procUsuarioCambiarClave";
    public final static String PROC_USUARIO_CAMBIAR_CLAVE = "seguridad.proc_usuario_cambiar_clave";
    public final static String AS_USU_CLAVE = "AS_USU_CLAVE";

    /**
     * Constantes para procedimiento almacenado seguridad.proc_usuario_cambiar_clave
     */
    public final static String METHOD_PROC_USUARIO_VERIFICAR_BLOQUEO = "procUsuarioVerificarBloqueo";
    public final static String PROC_USUARIO_VERIFICAR_BLOQUEO = "seguridad.proc_usuario_verificar_bloqueo";
    public final static String AS_TOKEN = "AS_TOKEN";
    public final static String AB_MANUAL = "AB_MANUAL";
    /**
     * Constantes del Procedimiento Almacenado seguridad.proc_oficina_crud
     */

    public final static String AS_OPERACION = "AS_OPERACION";
    public final static String PROC_OFICINA_CRUD = "seguridad.proc_oficina_crud";
    public final static String AI_ID_SUCURSAL = "AI_ID_SUCURSAL";
    public final static String AI_ID_TIPO_OFICINA = "AI_ID_TIPO_OFICINA";
    public final static String AS_DIRECCION = "AS_DIRECCION";
    public final static String AS_TELEFONO = "AS_TELEFONO";
    public final static String AI_ID_PROVINCIA = "AI_ID_PROVINCIA";
    public final static String AI_ID_CANTON = "AI_ID_CANTON";
    public final static String AI_HABILITADO = "AI_HABILITADO";
    public final static String AI_ID_EMPRESA = "AI_ID_EMPRESA";
    public final static String AS_CODIGO_2 = "AS_CODIGO_2";
    public final static String AS_TEL_CODIGO_AREA = "AS_TEL_CODIGO_AREA";
    public final static String AS_TEL_CODIGO_REGION = "AS_TEL_CODIGO_REGION";
    public final static String AS_OTRO_TELEFONO = "AS_OTRO_TELEFONO";
    public final static String AF_LATITUD = "AF_LATITUD";
    public final static String AF_LONGITUD = "AF_LONGITUD";
    public final static String AS_CREACION_USUARIO = "AS_CREACION_USUARIO";
    public final static String AS_CREACION_EQUIPO = "AS_CREACION_EQUIPO";

    /**
     * Métodos para Oficinas y tipos
     */
    public final static String METODO_LISTAR_OFICINA_PAGINADO = "listarOficinaPaginado";
    public final static String METODO_PROC_OFICINA_CRUD = "procOficinaCrud";
    public final static String METODO_LISTAR_TIPO_OFICINAS = "listarTipoOficinas";

    /**
     * Métodos comunes
     */
    public final static String METODO_LISTAR_PROVINCIAS = "listarProvincias";
    public final static String METODO_LISTAR_CANTONES_POR_PROVINCIA = "listarCantonesPorProvincia";
    public final static String METODO_LISTAR_ESTADOS = "listarEstados";

}