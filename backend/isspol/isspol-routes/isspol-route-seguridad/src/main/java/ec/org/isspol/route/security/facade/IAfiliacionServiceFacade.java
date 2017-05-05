package ec.org.isspol.route.security.facade;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.Usuario;

/**
 * Created by roberto.chasipanta on 5/5/2017.
 */
public interface IAfiliacionServiceFacade {
    Usuario buscarUsuarioPorId(String idUsuario) throws IsspolSearchException;
}
