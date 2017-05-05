package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.GrupoUsuario;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * Created by mavelin.ati on 18/04/2017.
 */
public interface GrupoUsuarioDao extends GenericDao<GrupoUsuario, Integer> {

    /**
     * listarTodosGrupoUsuario()
     * Metodo que devuelve una lista de grupoUsuario incluidos las clases referenciadas como objetos
     * 24/04/2017
     * @autor: mavelin.ati
     * @param:
     * @return: List<GrupoUsuario>
     */
    public List<GrupoUsuario> listarTodosGrupoUsuario() throws IsspolSearchException;

    /**
     * listarEstacionUsuarioPorUsuario()
     * Metodo que devuelve una lista de estacionUsuario por idUsuario incluidos las clases referenciadas como objetos
     * 24/04/2017
     * @autor: mavelin.ati
     * @param:
     * @return: List<EstacionUsuario>
     */
    public List<GrupoUsuario> listarGrupoUsuarioPorUsuario(String idUsuario) throws IsspolSearchException;

    /**
     * listarGrupoUsuarioNoElimiandoPorUsuario()
     * Metodo que devuelve una lista de grupoUsuario No Eliminados,
     * por idUsuario incluidos las clases referenciadas como objetos
     * 24/04/2017
     * @autor: mavelin.ati
     * @param:
     * @return: List<EstacionUsuario>
     */
    PagedResult<GrupoUsuario> listarGrupoUsuarioNoElimiandoPorUsuario
    (String idUsuario, FilterParam filterParam) throws IsspolSearchException;

}
