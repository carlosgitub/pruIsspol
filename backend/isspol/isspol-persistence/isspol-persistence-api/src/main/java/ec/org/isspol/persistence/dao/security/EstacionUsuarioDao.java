package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.EstacionUsuario;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * Created by mavelin.ati on 18/04/2017.
 */
public interface EstacionUsuarioDao extends GenericDao<EstacionUsuario, Integer> {

    /**
     * listarTodosEstacionUsuario()
     * Metodo que devuelve una lista de estacionUsuario incluidos las clases referenciadas como objetos
     * 24/04/2017
     * @autor: mavelin.ati
     * @param:
     * @return: List<EstacionUsuario>
     */
    public List<EstacionUsuario> listarTodosEstacionUsuario() throws IsspolSearchException;

    /**
     * listarEstacionUsuarioPorUsuario()
     * Metodo que devuelve una lista de estacionUsuario por idUsuario incluidos las clases referenciadas como objetos
     * 24/04/2017
     * @autor: mavelin.ati
     * @param:
     * @return: List<EstacionUsuario>
     */
    public List<EstacionUsuario> listarEstacionUsuarioPorUsuario(String idUsuario) throws IsspolSearchException;

    /**
     * listarEstacionUsuarioNoEliminadoPorUsuario()
     * Metodo que devuelve una lista de estacionUsuario No Eliminados, por idUsuario,
     * incluidos las clases referenciadas como objetos
     * 24/04/2017
     * @autor: mavelin.ati
     * @param:
     * @return: List<EstacionUsuario>
     */
    PagedResult<EstacionUsuario> listarEstacionUsuarioNoEliminadoPorUsuario
    (String idUsuario, FilterParam filterParam) throws IsspolSearchException;


}
