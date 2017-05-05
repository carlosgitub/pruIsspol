package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.entities.security.EstacionUsuario;
import java.util.List;

/**
 * Created by mavelin.ati on 18/04/2017.
 */
public interface EstacionUsuarioSvc {

    void insertarEstacionUsuario(EstacionUsuario estacionUsuario) throws IsspolPersistException;
    void actualizarEstacionUsuario(EstacionUsuario estacionUsuario) throws IsspolPersistException;

    List<EstacionUsuario> listarTodosEstacionUsuario() throws IsspolSearchException;
    EstacionUsuario buscarEstacionUsuarioPorId(Integer id) throws IsspolSearchException;
    List<EstacionUsuario> listarEstacionUsuarioPorUsuario(String idUsuario) throws IsspolSearchException;
    PagedResult<EstacionUsuario> listarEstacionUsuarioNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException;
}
