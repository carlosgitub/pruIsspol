package ec.org.isspol.route.security.facade.impl;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.security.*;
import ec.org.isspol.persistence.service.security.*;
import ec.org.isspol.route.security.facade.UsuarioServiceFacade;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.*;

/**
 * Created by mauchilan on 22/3/17.
 */
public class UsuarioServiceFacadeImpl implements UsuarioServiceFacade {

    /**
     * Variables SVC
     */
    private UsuarioSvc usuarioSvc;
    private EstadoUsuarioSvc estadoUsuarioSvc;
    private OficinaSvc oficinaSvc;
    private HorarioSvc horarioSvc;
    private GrupoSvc grupoSvc;
    private SucursalSvc sucursalSvc;
    private EstacionSvc estacionSvc;
    private EstacionUsuarioSvc estacionUsuarioSvc;
    private GrupoUsuarioSvc grupoUsuarioSvc;
    private EstructuraOrganizacionalSvc estructuraOrganizacionalSvc;
    private NivelEstructuraOrgSvc nivelEstructuraOrgSvc;
    private UsuarioOficinaSvc usuarioOficinaSvc;
    private CarpetaOpcionSvc carpetaOpcionSvc;
    private OpcionSvc opcionSvc;
    private IconoSvc iconoSvc;
    private TokenSvc tokenSvc;
    private TipoOficinaSvc tipoOficinaSvc;

    /**
     * Set de variables SVC
     */
    public void setUsuarioSvc(UsuarioSvc usuarioSvc) {
        this.usuarioSvc = usuarioSvc;
    }

    public void setEstadoUsuarioSvc(EstadoUsuarioSvc estadoUsuarioSvc) {
        this.estadoUsuarioSvc = estadoUsuarioSvc;
    }

    public void setOficinaSvc(OficinaSvc oficinaSvc) {
        this.oficinaSvc = oficinaSvc;
    }

    public void setHorarioSvc(HorarioSvc horarioSvc) {
        this.horarioSvc = horarioSvc;
    }

    public void setSucursalSvc(SucursalSvc sucursalSvc) {
        this.sucursalSvc = sucursalSvc;
    }

    public void setEstacionSvc(EstacionSvc estacionSvc) {
        this.estacionSvc = estacionSvc;
    }

    public void setEstacionUsuarioSvc(EstacionUsuarioSvc estacionUsuarioSvc) {
        this.estacionUsuarioSvc = estacionUsuarioSvc;
    }

    public void setGrupoUsuarioSvc(GrupoUsuarioSvc grupoUsuarioSvc) {
        this.grupoUsuarioSvc = grupoUsuarioSvc;
    }

    public void setEstructuraOrganizacionalSvc(EstructuraOrganizacionalSvc estructuraOrganizacionalSvc) {
        this.estructuraOrganizacionalSvc = estructuraOrganizacionalSvc;
    }

    public void setGrupoSvc(GrupoSvc grupoSvc) {
        this.grupoSvc = grupoSvc;
    }

    public void setUsuarioOficinaSvc(UsuarioOficinaSvc usuarioOficinaSvc) {
        this.usuarioOficinaSvc = usuarioOficinaSvc;
    }

    public void setNivelEstructuraOrgSvc(NivelEstructuraOrgSvc nivelEstructuraOrgSvc) {
        this.nivelEstructuraOrgSvc = nivelEstructuraOrgSvc;
    }

    public void setCarpetaOpcionSvc(CarpetaOpcionSvc carpetaOpcionSvc) {
        this.carpetaOpcionSvc = carpetaOpcionSvc;
    }

    public void setOpcionSvc(OpcionSvc opcionSvc) {
        this.opcionSvc = opcionSvc;
    }

    public void setIconoSvc(IconoSvc iconoSvc) {
        this.iconoSvc = iconoSvc;
    }

    public void setTokenSvc(TokenSvc tokenSvc) {
        this.tokenSvc = tokenSvc;
    }

    public void setTipoOficinaSvc(TipoOficinaSvc tipoOficinaSvc) {
        this.tipoOficinaSvc = tipoOficinaSvc;
    }

    /**
     * Metodos implementados
     */

    @Override
    public List<Horario> listarHorario() throws IsspolSearchException {
        return horarioSvc.listarHorario();
    }

    @Override
    public List<EstadoUsuario> listarEstadoUsuario() throws IsspolSearchException {
        return estadoUsuarioSvc.listarEstadoUsuario();
    }

    @Override
    public List<Oficina> listarOficina() throws IsspolSearchException {
        return oficinaSvc.listarOficina();
    }

    @Override
    public List<Usuario> listarUsuario() throws IsspolSearchException {
        return usuarioSvc.listarUsuario();
    }

    @Override
    public List<EstructuraOrganizacional> listaEstructuraOrganizacional() throws IsspolSearchException {
        return estructuraOrganizacionalSvc.listarTodosEstructuraOrganizacional();
    }

    @Override
    public Collection<EstructuraOrganizacional> listarEstrOrganizacional() throws IsspolSearchException {
        return estructuraOrganizacionalSvc.listarEstructuraOrg();
    }

    @Override
    public List<NivelEstructuraOrg> listarTodosNivelEstructuraOrg() throws IsspolSearchException {
        return nivelEstructuraOrgSvc.listarTodosNivelEstructuraOrg();
    }

    @Override
    public Map<String, Object> listarCargo() throws IsspolPersistException {
        return estructuraOrganizacionalSvc.listarCargo();
    }

    @Override
    public Map<String, Object> procUsuarioInsertar(HashMap<String, Object> values) throws IsspolPersistException {
        return usuarioSvc.procUsuarioInsertar(values);
    }

    @Override
    public Map<String, Object> procUsuarioValidarFormulario(HashMap<String, Object> values) throws IsspolPersistException {
        return usuarioSvc.procUsuarioValidarFormulario(values);
    }

    @Override
    public Map<String, Object> procUsuarioActualizar(HashMap<String, Object> values) throws IsspolPersistException {
        return usuarioSvc.procUsuarioActualizar(values);
    }

    public Map<String, Object> procUsuarioSolicitudCambioClave(HashMap<String, Object> values) throws IsspolPersistException {
        return usuarioSvc.procUsuarioSolicitudCambioClave(values);
    }

    public Token buscarTokenPorDato(String dato) throws IsspolSearchException {
        return tokenSvc.buscarTokenPorDato(dato);
    }

    public Map<String, Object> procUsuarioCambiarClave(HashMap<String, Object> values) throws IsspolPersistException {
        return usuarioSvc.procUsuarioCambiarClave(values);
    }

    public Map<String, Object> procUsuarioVerificarBloqueo(HashMap<String, Object> values) throws IsspolPersistException {
        return usuarioSvc.procUsuarioVerificarBloqueo(values);
    }

    @Override
    public List<CarpetaOpcion> listarCarpetaOpcion() throws IsspolSearchException {
        return carpetaOpcionSvc.listarTodosCarpetaOpcion();
    }

    @Override
    public List<CarpetaOpcion> listarCarpetaOpcionPorIdCarpetaPadre(Integer idCarpetaOpcion) throws IsspolSearchException {
        return carpetaOpcionSvc.listarCarpetaOpcionPorIdCarpetaPadre(idCarpetaOpcion);
    }

    @Override
    public List<Opcion> listarOpcion() throws IsspolSearchException {
        return opcionSvc.listarTodosOpcion();
    }

    @Override
    public List<Opcion> listarOpcionPorIdCarpetaOpcion(Integer idCarpetaOpcion) throws IsspolSearchException {
        return opcionSvc.listarOpcionPorIdCarpetaOpcion(idCarpetaOpcion);
    }

    @Override
    public List<Icono> listarIcono() throws IsspolSearchException {
        return iconoSvc.listarTodosIcono();
    }

    @Override
    public void insertarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException {
        carpetaOpcionSvc.insertarCarpetaOpcion(carpetaOpcion);
    }

    @Override
    public void actualizarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException {
        carpetaOpcionSvc.actualizarCarpetaOpcion(carpetaOpcion);
    }

    @Override
    public void eliminarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException {
        carpetaOpcionSvc.eliminarCarpetaOpcion(carpetaOpcion);
    }

    @Override
    public void insertarOpcion(Opcion opcion) throws IsspolPersistException {
        opcionSvc.insertarOpcion(opcion);
    }

    @Override
    public void actualizarOpcion(Opcion opcion) throws IsspolPersistException {
        opcionSvc.actualizarOpcion(opcion);
    }

    @Override
    public void eliminarOpcion(Opcion opcion) throws IsspolPersistException {
        opcionSvc.eliminarOpcion(opcion);
    }

    @Override
    public CarpetaOpcion buscarCarpetaOpcionPorId(Integer id) throws IsspolSearchException {
        return carpetaOpcionSvc.buscarCarpetaOpcionPorId(id);
    }

    @Override
    public Opcion buscarOpcionPorId(Integer id) throws IsspolSearchException {
        return opcionSvc.buscarOpcionPorId(id);
    }

    @Override
    public Icono buscarIconoPorId(Integer id) throws IsspolSearchException {
        return iconoSvc.buscarIconoPorId(id);
    }

    public void actualizarUsuario(Usuario usuario) throws IsspolException, IsspolPersistException {
        usuarioSvc.actualizarUsuario(usuario);
    }

    @Override
    public Map<String, Object> procEstructuraOrganizacionalGuardar(HashMap<String, Object> values) throws IsspolPersistException {
        return estructuraOrganizacionalSvc.procEstructuraOrganizacionalGuardar(values);
    }

    @Override
    public Map<String, Object> procEstructuraOrganizacionalEliminar(HashMap<String, Object> values) throws IsspolPersistException {
        return estructuraOrganizacionalSvc.procEstructuraOrganizacionalEliminar(values);
    }


    /**
     * Métodos para el mantenimiento de Sucursales by JPA
     */

    @Override
    public void insertarSucursal(Sucursal sucursal) throws IsspolPersistException {
        sucursalSvc.insertarSucursal(sucursal);
    }

    @Override
    public void actualizarSucursal(Sucursal sucursal) throws IsspolPersistException {
        sucursalSvc.actualizarSucursal(sucursal);
    }

    @Override
    public void eliminarSucursal(Sucursal sucursal) throws IsspolPersistException {
        sucursalSvc.eliminarSucursal(sucursal);
    }

    @Override
    public List<Sucursal> listarTodasSucursales() throws IsspolSearchException {
        return sucursalSvc.listarTodasSucursales();
    }

    @Override
    public Sucursal buscarSucursalPorId(Integer id) throws IsspolSearchException {
        return sucursalSvc.buscarSucursalPorId(id);
    }

    @Override
    public PagedResult<Sucursal> listarSucursalPaginado(FilterParam filterParam) throws IsspolSearchException {
        return sucursalSvc.listarSucursalPaginado(filterParam);
    }

    /**
     * Métodos para el mantenimiento de Oficinas by JPA
     */
    @Override
    public Map<String, Object> procOficinaCrud(HashMap<String, Object> values) throws IsspolPersistException {
        return oficinaSvc.procOficinaCrud(values);
    }

    @Override
    public PagedResult<Oficina> listarOficinaPaginado(FilterParam filterParam) throws IsspolSearchException {
        return oficinaSvc.listarOficinaPaginado(filterParam);
    }

    @Override
    public List<TipoOficina> listarTipoOficinas() throws IsspolSearchException {
        return tipoOficinaSvc.listarTipoOficinas();
    }

    /**
     * Métodos para administrar Grupo(Rol) by EA, Fecha: 2017-04-13
     */
    @Override
    public void insertarActualizarGrupo(Grupo grupo) throws IsspolPersistException {
        grupoSvc.insertarActualizarGrupo(grupo);
    }

    @Override
    public Grupo buscarGrupoPorId(int idGrupo) throws IsspolSearchException {
        return grupoSvc.buscarGrupoPorId(idGrupo);
    }

    @Override
    public void eliminarGrupo(Grupo grupo) throws IsspolPersistException {
        grupoSvc.eliminarGrupo(grupo);
    }

    @Override
    public List<Grupo> listarTodos() throws IsspolSearchException {
        return grupoSvc.listarTodos();
    }

    @Override
    public Grupo buscarGrupoPorNombre(String nombre) throws IsspolSearchException {
        return grupoSvc.buscarGrupoPorNombre(nombre);
    }

    @Override
    public PagedResult<Grupo> listarGrupoPaginado(FilterParam filterParam) throws IsspolSearchException {
        return grupoSvc.listarGrupoPaginado(filterParam);
    }

    /**
     * Creado por Andres Campoverde : 17-04-2017
     *
     * @param values
     * @return
     * @AS_USUARIO VARCHAR(15)
     * @AS_MSJ VARCHAR(100)
     */
    public Map<String, Object> verificarSesion(HashMap<String, Object> values) throws IsspolPersistException {
        return usuarioSvc.verificarSesion(values);
    }

    /**
     * Creado por Andres Campoverde : 17-04-2017
     *
     * @param values
     * @return
     * @AS_USU_USUARIO VARCHAR(15)
     * @AB_VALIDA_HOSTNAME BIT
     * @AS_HOSTNAME VARCHAR(50)
     * @AS_CLAVE VARCHAR(15)
     * @AI_INTENTO INT
     * @AI_USUARIO INT = NULL
     * @AB_REQ_CAMBIO_PWD int OUTPUT
     * @AS_MSJ VARCHAR(100) OUTPUT
     */
    @Override
    public Map<String, Object> validarClaveUsuario(HashMap<String, Object> values) throws IsspolPersistException {
        return usuarioSvc.validarClaveUsuario(values);
    }

    @Override
    public Map<String, Object> obtenerInformacionSesion(HashMap<String, Object> values) throws IsspolPersistException {
        return usuarioSvc.obtenerInformacionSesion(values);
    }

    /**
     * Creado por Andres Campoverde el 18-04-2017
     *
     * @param values
     * @return
     * @AS_USUARIO VARCHAR(15)
     */
    @Override
    public Map<String, Object> obtenerListaFavoritos(HashMap<String, Object> values) throws IsspolPersistException {
        return usuarioSvc.obtenerListaFavoritos(values);
    }

    @Override
    public Map<String, Object> obtenerOficinaNombreOficina(HashMap<String, Object> values) throws IsspolPersistException {
        return oficinaSvc.obtenerOficinaNombreOficina(values);
    }

    @Override
    public Map<String, Object> obtenerSucursalOficina(HashMap<String, Object> values) throws IsspolPersistException {
        return oficinaSvc.obtenerSucursalOficina(values);
    }

    @Override
    public Map<String, Object> obtenerCarpetaOpcionPorGrupo(HashMap<String, Object> values) throws IsspolPersistException {
        return carpetaOpcionSvc.obtenerCarpetaOpcionPorGrupo(values);
    }

    @Override
    public Map<String, Object> obtenerOpcionUsoFrecuentes(HashMap<String, Object> values) throws IsspolPersistException {
        return opcionSvc.obtenerOpcionUsoFrecuentes(values);
    }

    @Override
    public Usuario buscarUsuarioPorId(String idUsuario) throws IsspolSearchException {
        return usuarioSvc.buscarPorIdUsuario(idUsuario);
    }

    @Override
    public Oficina buscarOficinaPorId(Integer idOficina) throws IsspolSearchException {
        return oficinaSvc.buscarOficinaPorId(idOficina);
    }

    // INICIO METODOS Mavelin Ati
    //-------------------------------------------------------------------------------------------

    /**
     * Mantenimiento Estacion
     */

    @Override
    public void insertarEstacion(Estacion estacion) throws IsspolPersistException {
        estacionSvc.insertarEstacion(estacion);
    }

    @Override
    public void actualizarEstacion(Estacion estacion) throws IsspolPersistException {
        estacionSvc.actualizarEstacion(estacion);
    }

    @Override
    public List<Estacion> listarTodosEstacion() throws IsspolSearchException {
        return estacionSvc.listarTodosEstacion();
    }

    @Override
    public Estacion buscarEstacionPorId(Integer id) throws IsspolSearchException {
        return estacionSvc.buscarEstacionPorId(id);
    }

    @Override
    public PagedResult<Estacion> listarEstacionNoEliminado(FilterParam filterParam) throws IsspolSearchException {
        return estacionSvc.listarEstacionNoEliminado(filterParam);
    }

    /**
     * Mantenimiento Estacion-Usuario
     */
    @Override
    public void insertarEstacionUsuario(EstacionUsuario estacionUsuario) throws IsspolPersistException {
        estacionUsuarioSvc.insertarEstacionUsuario(estacionUsuario);
    }

    @Override
    public void actualizarEstacionUsuario(EstacionUsuario estacionUsuario) throws IsspolPersistException {
        estacionUsuarioSvc.actualizarEstacionUsuario(estacionUsuario);
    }

    @Override
    public List<EstacionUsuario> listarTodosEstacionUsuario() throws IsspolSearchException {
        return estacionUsuarioSvc.listarTodosEstacionUsuario();
    }

    @Override
    public EstacionUsuario buscarEstacionUsuarioPorId(Integer id) throws IsspolSearchException {
        return estacionUsuarioSvc.buscarEstacionUsuarioPorId(id);
    }

    @Override
    public List<EstacionUsuario> listarEstacionUsuarioPorUsuario(String idUsuario) throws IsspolSearchException {
        return estacionUsuarioSvc.listarEstacionUsuarioPorUsuario(idUsuario);
    }

    @Override
    public PagedResult<EstacionUsuario> listarEstacionUsuarioNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException {
        return estacionUsuarioSvc.listarEstacionUsuarioNoEliminadoPorUsuario(idUsuario, filterParam);
    }

    /**
     * Mantenimiento Grupo-Usuario
     */

    @Override
    public void insertarGrupoUsuario(GrupoUsuario grupoUsuario) throws IsspolPersistException {
        grupoUsuarioSvc.insertarGrupoUsuario(grupoUsuario);
    }

    @Override
    public void actualizarGrupoUsuario(GrupoUsuario grupoUsuario) throws IsspolPersistException {
        grupoUsuarioSvc.actualizarGrupoUsuario(grupoUsuario);
    }

    @Override
    public List<GrupoUsuario> listarTodosGrupoUsuario() throws IsspolSearchException {
        return grupoUsuarioSvc.listarTodosGrupoUsuario();
    }

    @Override
    public GrupoUsuario buscarGrupoUsuarioPorId(Integer id) throws IsspolSearchException {
        return grupoUsuarioSvc.buscarGrupoUsuarioPorId(id);
    }

    @Override
    public List<GrupoUsuario> listarGrupoUsuarioPorUsuario(String idUsuario) throws IsspolSearchException {
        return grupoUsuarioSvc.listarGrupoUsuarioPorUsuario(idUsuario);
    }

    @Override
    public PagedResult<GrupoUsuario> listarGrupoUsuarioNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException {
        return grupoUsuarioSvc.listarGrupoUsuarioNoEliminadoPorUsuario(idUsuario, filterParam);
    }

    /**
     * Mantenimiento Usuario-Oficina
     */
    @Override
    public void insertarUsuarioOficina(UsuarioOficina usuarioOficina) throws IsspolPersistException {
        usuarioOficinaSvc.insertarUsuarioOficina(usuarioOficina);
    }

    @Override
    public void actualizarUsuarioOficina(UsuarioOficina usuarioOficina) throws IsspolPersistException {
        usuarioOficinaSvc.actualizarUsuarioOficina(usuarioOficina);
    }

    @Override
    public List<UsuarioOficina> listarTodosUsuarioOficina() throws IsspolSearchException {
        return usuarioOficinaSvc.listarTodosUsuarioOficina();
    }

    @Override
    public UsuarioOficina buscarUsuarioOficinaPorId(Integer id) throws IsspolSearchException {
        return usuarioOficinaSvc.buscarUsuarioOficinaPorId(id);
    }

    @Override
    public List<UsuarioOficina> listarUsuarioOficinaPorUsuario(String idUsuario) throws IsspolSearchException {
        return usuarioOficinaSvc.listarUsuarioOficinaPorUsuario(idUsuario);
    }

    @Override
    public PagedResult<UsuarioOficina> listarUsuarioOficinaNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException {
        return usuarioOficinaSvc.listarUsuarioOficinaNoEliminadoPorUsuario(idUsuario, filterParam);
    }
    // FIN METODOS Mavelin Ati
    //-------------------------------------------------------------------------------------------------

}
