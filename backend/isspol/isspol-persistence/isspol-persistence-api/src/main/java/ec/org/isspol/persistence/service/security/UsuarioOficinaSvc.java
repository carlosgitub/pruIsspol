package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.entities.security.UsuarioOficina;

import java.util.List;

/**
 * Created by mavelin.ati on 05/05/2017.
 */
public interface UsuarioOficinaSvc {

    void insertarUsuarioOficina(UsuarioOficina usuarioOficina) throws IsspolPersistException;
    void actualizarUsuarioOficina(UsuarioOficina usuarioOficina) throws IsspolPersistException;

    List<UsuarioOficina> listarTodosUsuarioOficina() throws IsspolSearchException;
    UsuarioOficina buscarUsuarioOficinaPorId(Integer id) throws IsspolSearchException;
    List<UsuarioOficina> listarUsuarioOficinaPorUsuario(String idUsuario) throws IsspolSearchException;
    PagedResult<UsuarioOficina> listarUsuarioOficinaNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException;

}
