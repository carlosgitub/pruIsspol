package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.TipoOficina;

import java.util.List;

/**
 * Created by Javier on 28/04/2017.
 */
public interface TipoOficinaSvc {
    List<TipoOficina> listarTipoOficinas() throws IsspolSearchException;
}
