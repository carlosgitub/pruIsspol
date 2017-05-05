package ec.org.isspol.route.security.facade;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.security.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 22/3/17.
 */
public interface UsuarioServiceFacade {

    /**
     * Métodos para el mantenimiento de usuarios
     * Paul Salgado
     * 21/04/2017
     */
    List<Horario> listarHorario() throws IsspolSearchException;
    List<EstadoUsuario> listarEstadoUsuario() throws IsspolSearchException;
    List<Oficina> listarOficina() throws IsspolSearchException;
    List<Usuario> listarUsuario() throws IsspolSearchException;
    List<EstructuraOrganizacional> listaEstructuraOrganizacional() throws IsspolSearchException;
    Collection<EstructuraOrganizacional> listarEstrOrganizacional()throws IsspolSearchException;
    List<NivelEstructuraOrg> listarTodosNivelEstructuraOrg() throws IsspolSearchException;

    Map<String, Object> listarCargo() throws IsspolPersistException;
    Map<String, Object> procUsuarioInsertar(HashMap<String, Object> values) throws IsspolPersistException;
    Map<String, Object> procUsuarioValidarFormulario(HashMap<String, Object> values) throws IsspolPersistException;
    Map<String, Object> procUsuarioActualizar(HashMap<String, Object> values) throws IsspolPersistException;
    Map<String, Object> procUsuarioSolicitudCambioClave(HashMap<String, Object> values) throws IsspolPersistException ;
    Token buscarTokenPorDato(String dato) throws IsspolSearchException;
    Map<String, Object> procUsuarioCambiarClave(HashMap<String, Object> values) throws IsspolPersistException ;
    Map<String, Object> procUsuarioVerificarBloqueo(HashMap<String, Object> values) throws IsspolPersistException ;

    /**
     * Fin Métodos para el mantenimiento de usuarios
     */

    /**
     * Métodos para el mantenimiento de Carpetas
     * Paul Salgado
     * 26/04/2017
     */
    List<CarpetaOpcion> listarCarpetaOpcion() throws IsspolSearchException;
    List<CarpetaOpcion> listarCarpetaOpcionPorIdCarpetaPadre(Integer idCarpetaOpcion) throws IsspolSearchException;
    List<Opcion> listarOpcion() throws IsspolSearchException;
    List<Opcion> listarOpcionPorIdCarpetaOpcion(Integer idCarpetaOpcion) throws IsspolSearchException;
    List<Icono> listarIcono() throws IsspolSearchException;

    void insertarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException;
    void actualizarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException;
    void eliminarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException;

    void insertarOpcion(Opcion opcion) throws IsspolPersistException;
    void actualizarOpcion(Opcion opcion) throws IsspolPersistException;
    void eliminarOpcion(Opcion opcion) throws IsspolPersistException;

    CarpetaOpcion buscarCarpetaOpcionPorId(Integer id) throws IsspolSearchException;
    Opcion buscarOpcionPorId(Integer id) throws IsspolSearchException;
    Icono buscarIconoPorId(Integer id) throws IsspolSearchException;

    /**
     * Fin Métodos para el mantenimiento de Carpetas
     */

    /**
     * @title Actualizar Usuario
     * @description Actualizar Usuario por DAO
     * @author carlos.calo
     * @date 21/04/2017
     * @param usuario
     * @throws IsspolException
     * @throws IsspolPersistException
     */
    void actualizarUsuario(Usuario usuario) throws IsspolException, IsspolPersistException;


    /**
     * @title Creacion de estructura organizacion
     * @description Metodo que permite crear una estructura mediandte Store Procedure
     * @author santtiago.yacelga
     * @date 27/04/2017
     * @throws IsspolException
     */
    Map<String, Object> procEstructuraOrganizacionalGuardar(HashMap<String, Object> values) throws IsspolPersistException ;


    /**
     * @title Eliminacion de estructura organizacion
     * @description Metodo que permite eliminar una estructura mediandte Store Procedure
     * @author santtiago.yacelga
     * @date 27/04/2017
     * @throws IsspolException
     */
    Map<String, Object> procEstructuraOrganizacionalEliminar(HashMap<String, Object> values) throws IsspolPersistException ;


    /**
     * Agregados por Andres Campoverde : 17-04-2017
     * Procedimientos Almacenados
     */
    Map<String,Object>verificarSesion(HashMap<String,Object>values)throws IsspolPersistException;
    Map<String,Object>validarClaveUsuario(HashMap<String,Object>values)throws IsspolPersistException;
    Map<String,Object>obtenerInformacionSesion(HashMap<String,Object> values)throws IsspolPersistException;
    Map<String,Object>obtenerListaFavoritos(HashMap<String,Object>values) throws IsspolPersistException;
    Map<String,Object>obtenerOficinaNombreOficina(HashMap<String,Object>values) throws IsspolPersistException;
    Map<String,Object>obtenerSucursalOficina(HashMap<String,Object>values) throws IsspolPersistException;
    Map<String,Object>obtenerCarpetaOpcionPorGrupo(HashMap<String,Object>values) throws IsspolPersistException;
    Map<String,Object>obtenerOpcionUsoFrecuentes(HashMap<String,Object>values) throws IsspolPersistException;

    Usuario buscarUsuarioPorId(String idUsuario) throws IsspolSearchException;
    Oficina buscarOficinaPorId(Integer idOficina) throws IsspolSearchException;

	/**
     * Métodos para el mantenimiento de Sucursales, Oficinas por JPA (Javier Parada), Fecha: 2017-04-13
     */
    /**
     * insertarSucursal
     * Insertar Sucursales
     * Fecha: 2017-04-13
     * @autor Javier Parada
     * @param sucursal
     * @throws IsspolPersistException
     */
    void insertarSucursal(Sucursal sucursal) throws IsspolPersistException;

    /**
     * actualizarSucursal
     * Actualizar Sucursales
     * Fecha: 2017-04-13
     * @autor Javier Parada
     * @param sucursal
     * @throws IsspolPersistException
     */
    void actualizarSucursal(Sucursal sucursal) throws IsspolPersistException;

    /**
     * eliminarSucursal
     * Eliminar Sucursal
     * Fecha: 2017-04-13
     * @autor Javier Parada
     * @param sucursal indica que objeto se va actualizar
     * @throws IsspolPersistException
     */
    void eliminarSucursal(Sucursal sucursal) throws IsspolPersistException;

    /**
     * listarTodasSucursales
     * Listar todas las Sucursales
     * @return Retorna una lista de objetos tipo Sucursal
     * Fecha: 2017-04-13
     * @autor Javier Parada
     * @throws IsspolSearchException
     */
    List<Sucursal> listarTodasSucursales() throws IsspolSearchException;

    /**
     * buscarSucursalPorId
     * Buscar una Sucursal por ID (PK)
     * Fecha: 2017-04-13
     * @autor Javier Parada
     * @param id
     * @return
     * @throws IsspolSearchException
     */
    Sucursal buscarSucursalPorId(Integer id) throws IsspolSearchException;

    /**
     * listarSucursalPaginado
     * Lista las sucursales en forma paginada de acuerdo a los parametros enviados
     * Fecha: 2017-04-24
     * @autor Javier Parada
     * @param filterParam
     * @return retorna un objeto que contiene la lista de sucursales
     * @throws IsspolSearchException
     */
    PagedResult<Sucursal> listarSucursalPaginado (FilterParam filterParam) throws IsspolSearchException;

    /**
     * procOficinaInsertar
     * Mantenimiento de coordinaciones CRUD
     * Fecha: 2017-04-24
     * @autor Javier Parada
     * @param values
     * @autor Javier Parada
     * @return
     * @throws IsspolException
     */
    Map<String, Object> procOficinaCrud(HashMap<String, Object> values) throws IsspolPersistException;

    /**
     * Lista las oficinas paginado
     * Fecha: 2017-04-27
     * @autor Javier Parada
     * @param filterParam
     * @autor Javier Parada
     * @return
     * @throws IsspolSearchException
     */
    PagedResult<Oficina> listarOficinaPaginado (FilterParam filterParam) throws IsspolSearchException;

    /**
     * Lista los tipos de oficina
     * Fecha: 2017-04-28
     * @autor Javier Parada
     * @return
     * @throws IsspolSearchException
     */
    List<TipoOficina> listarTipoOficinas () throws IsspolSearchException;

    /**
     * FIN Métodos por JPA
     */

    /**
     * Métodos para administrar Grupo(Rol) by EA, Fecha: 2017-04-13
     */
    /**
     * insertarGrupo
     * Inserta o actualizar un grupo
     * Fecha: 2017-04-13
     * @autor Edison Aulestia
     * @param grupo objeto que sirve para ingresar o actualizar un grupo
     */
    void insertarActualizarGrupo(Grupo grupo) throws IsspolPersistException;

    /**
     * buscarGrupoPorId
     * Busca un grupo por id
     * Fecha: 2017-04-13
     * @autor Edison Aulestia
     * @param idGrupo busca un objeto grupo por id
     * @return Retorna un objeto de tipo grupo
     */
    Grupo buscarGrupoPorId(int idGrupo) throws IsspolSearchException;
    /**
     * eliminarGrupo
     * Eliminar un grupo
     * Fecha: 2017-04-13
     * @autor Edison Aulestia
     * @param grupo objeto que sirve para eliminar un grupo
     */
    void eliminarGrupo(Grupo grupo) throws IsspolPersistException;
    /**
     * listarTodos
     * Lista todos los grupos ingresados
     * Fecha: 2017-04-13
     * @autor Edison Aulestia
     * @return Retorna una lista de grupos
     */
    List<Grupo> listarTodos() throws IsspolSearchException;
    /**
     * buscarGrupoPorNombre
     * Busca un grupo por nombre
     * Fecha: 2017-04-13
     * @autor Edison Aulestia
     * @param nombre especifica que parametro se va utilizar para buscar
     * @return Retorna un objeto de tipo grupo
     */
    Grupo buscarGrupoPorNombre(String nombre) throws IsspolSearchException;
    /**
     * listarGrupoPaginado
     * Busca un grupo por el filtro
     * Fecha: 2017-04-25
     * @autor Edison Aulestia
     * @param filterParam especifica que parametro se va utilizar para filtrar
     * @return Retorna un objeto de tipo grupo
     */
    PagedResult<Grupo> listarGrupoPaginado (FilterParam filterParam) throws IsspolSearchException;

    // INICIO METODOS Mavelin Ati
    //-------------------------------------------------------------------------------------------
    /*
     * Mantenimiento Estacion
     */
    void insertarEstacion(Estacion estacion) throws IsspolPersistException;
    void actualizarEstacion(Estacion estacion) throws IsspolPersistException;

    List<Estacion> listarTodosEstacion() throws IsspolSearchException;
    Estacion buscarEstacionPorId(Integer id) throws IsspolSearchException;
    PagedResult<Estacion> listarEstacionNoEliminado (FilterParam filterParam) throws IsspolSearchException;

    /*
     * Mantenimiento Estacion-Usuario
     */
    void insertarEstacionUsuario(EstacionUsuario estacionUsuario) throws IsspolPersistException;
    void actualizarEstacionUsuario(EstacionUsuario estacionUsuario) throws IsspolPersistException;

    List<EstacionUsuario> listarTodosEstacionUsuario() throws IsspolSearchException;
    EstacionUsuario buscarEstacionUsuarioPorId(Integer id) throws IsspolSearchException;
    List<EstacionUsuario> listarEstacionUsuarioPorUsuario(String idUsuario) throws IsspolSearchException;
    PagedResult<EstacionUsuario> listarEstacionUsuarioNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException;

    /**
     * Mantenimiento Grupo-Usuario
     */
    void insertarGrupoUsuario(GrupoUsuario grupoUsuario) throws IsspolPersistException;
    void actualizarGrupoUsuario(GrupoUsuario grupoUsuario) throws IsspolPersistException;

    List<GrupoUsuario> listarTodosGrupoUsuario() throws IsspolSearchException;
    GrupoUsuario buscarGrupoUsuarioPorId(Integer id) throws IsspolSearchException;
    List<GrupoUsuario> listarGrupoUsuarioPorUsuario(String idUsuario) throws IsspolSearchException;
    PagedResult<GrupoUsuario> listarGrupoUsuarioNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException;

    /*
     * Mantenimiento UsuarioOficina
     */
    void insertarUsuarioOficina(UsuarioOficina usuarioOficina) throws IsspolPersistException;
    void actualizarUsuarioOficina(UsuarioOficina usuarioOficina) throws IsspolPersistException;

    List<UsuarioOficina> listarTodosUsuarioOficina() throws IsspolSearchException;
    UsuarioOficina buscarUsuarioOficinaPorId(Integer id) throws IsspolSearchException;
    List<UsuarioOficina> listarUsuarioOficinaPorUsuario(String idUsuario) throws IsspolSearchException;
    PagedResult<UsuarioOficina> listarUsuarioOficinaNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException;

    // FIN METODOS Mavelin Ati
    //-------------------------------------------------------------------------------------------------

}
