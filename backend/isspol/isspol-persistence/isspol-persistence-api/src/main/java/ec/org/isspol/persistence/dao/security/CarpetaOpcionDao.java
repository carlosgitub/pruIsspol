package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.CarpetaOpcion;
import java.util.List;

/**
 * Created by paul.salgado on 21/04/2017.
 */
public interface CarpetaOpcionDao extends GenericDao<CarpetaOpcion, Integer> {

    public List<CarpetaOpcion> listarCarpetaOpcion() throws IsspolSearchException;
}
