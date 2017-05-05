package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public interface EstadoUsuarioSvc {

    EstadoUsuario buscarPorCriterio(Criterion criterion) throws IsspolSearchException;

    List<EstadoUsuario> listarEstadoUsuario() throws  IsspolSearchException;

}
