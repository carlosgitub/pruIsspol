package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.entities.security.Oficina;
import org.hibernate.criterion.Criterion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 21/3/17.
 */
public interface OficinaSvc {
    PagedResult<Oficina> listarOficinaPaginado(FilterParam filterParam) throws IsspolSearchException;
    Oficina buscarPorCriterio(Criterion criterion)throws IsspolSearchException;
    List<Oficina> listarOficina()throws IsspolSearchException;
    Oficina buscarOficinaPorId(Integer id) throws IsspolSearchException;

    public Map<String, Object> procOficinaCrud(HashMap<String, Object> values) throws IsspolPersistException;

    public Map<String, Object> obtenerOficinaNombreOficina(HashMap<String, Object> values) throws IsspolPersistException;

    public Map<String, Object> obtenerSucursalOficina(HashMap<String, Object> values) throws IsspolPersistException;
}
