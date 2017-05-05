package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 21/3/17.
 */
public interface UsuarioSvc {

    void insertarUsuario(Usuario usuario)throws IsspolPersistException ;

    Usuario buscarUsuarioxId (String idUsuario) throws IsspolSearchException;

    Usuario buscarPorIdUsuario(String idUsuario) throws IsspolSearchException;

    void actualizarUsuario(Usuario usuario)throws IsspolPersistException;

    void eliminarUsuario(Usuario usuario)throws IsspolPersistException;

    List<Usuario> listarUsuario()throws IsspolSearchException;

    List<Usuario> listarUsuariosPorEstadoUsuario(Integer idEstadoUsuario)throws IsspolSearchException;

    Map<String, Object> procUsuarioInsertar(HashMap<String, Object> values) throws IsspolPersistException;

    Map<String, Object> procUsuarioValidarFormulario(HashMap<String, Object> values) throws IsspolPersistException;

    Map<String, Object> procUsuarioActualizar(HashMap<String, Object> values) throws IsspolPersistException;

    Map<String, Object> procUsuarioSolicitudCambioClave(HashMap<String, Object> values) throws IsspolPersistException;

    Map<String, Object> procUsuarioCambiarClave(HashMap<String, Object> values) throws IsspolPersistException;

    Map<String, Object> procUsuarioVerificarBloqueo(HashMap<String, Object> values) throws IsspolPersistException;

    Map<String, Object> procEstructuraOrganizacionalGuardar(HashMap<String, Object> values) throws IsspolPersistException;

    Map<String, Object> verificarSesion(HashMap<String, Object> values) throws IsspolPersistException;

    public Map<String, Object> validarClaveUsuario(HashMap<String, Object> values) throws IsspolPersistException;

    public Map<String, Object> obtenerInformacionSesion(HashMap<String, Object> values) throws IsspolPersistException;

    public Map<String, Object> obtenerListaFavoritos(HashMap<String, Object> values) throws IsspolPersistException;
}
