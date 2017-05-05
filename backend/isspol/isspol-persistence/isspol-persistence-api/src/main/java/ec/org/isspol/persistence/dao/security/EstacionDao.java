package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.Estacion;

import java.util.List;

/**
 * Created by mavelin.ati on 21/04/2017.
 */
public interface EstacionDao extends GenericDao<Estacion, Integer> {

    /**
     * listarTodosEstacion()
     * Metodo que devuelve una lista de estacion No Eliminados
     * 24/04/2017
     * @autor: mavelin.ati
     * @param:
     * @return: List<EstacionUsuario>
     */
    public List<Estacion> listarTodosEstacion() throws IsspolSearchException;

    /**
     * listarEstacionNoEliminado()
     * Metodo que devuelve una lista de estacion No Eliminados paginado,
     *
     * 24/04/2017
     * @autor: mavelin.ati
     * @param:
     * @return: List<Estacion>
     */
    PagedResult<Estacion> listarEstacionNoEliminado(FilterParam filterParam) throws IsspolSearchException;

}
