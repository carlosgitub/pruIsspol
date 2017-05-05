package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.entities.security.GrupoUsuario;
import java.util.List;

/**
 * Created by mavelin.ati on 18/04/2017.
 */
public interface GrupoUsuarioSvc {

    void insertarGrupoUsuario(GrupoUsuario grupoUsuario) throws IsspolPersistException;
    void actualizarGrupoUsuario(GrupoUsuario grupoUsuario) throws IsspolPersistException;

    List<GrupoUsuario> listarTodosGrupoUsuario() throws IsspolSearchException;
    GrupoUsuario buscarGrupoUsuarioPorId(Integer id) throws IsspolSearchException;
    List<GrupoUsuario> listarGrupoUsuarioPorUsuario(String idUsuario) throws IsspolSearchException;
    PagedResult<GrupoUsuario> listarGrupoUsuarioNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException;
}
