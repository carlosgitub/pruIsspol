package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.Oficina;

/**
 * Created by mauchilan on 20/3/17.
 */
public interface OficinaDao extends GenericDao<Oficina, Integer> {
    PagedResult<Oficina> listarOficinaPaginado(FilterParam filterParam) throws IsspolSearchException;
}
