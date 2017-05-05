package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.security.GrupoDao;
import ec.org.isspol.persistence.entities.security.Grupo;
import ec.org.isspol.persistence.service.security.GrupoSvc;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * GrupoSvcImpl
 * Es la clase que implementa la interfaz GrupoSvc con sus metodos que administran la entidad Grupo
 * Fecha: 2017-04-13
 * @autor Edison Aulestia
 **/
public class GrupoSvcImpl implements GrupoSvc {

    private GrupoDao grupoDao;

    @Override
    public void insertarActualizarGrupo(Grupo grupo) throws IsspolPersistException {
        grupoDao. insertarActualizarGrupo(grupo);
    }

    @Override
    public void eliminarGrupo(Grupo grupo) throws IsspolPersistException {
        grupoDao.actualizar(grupo);
    }

    @Override
    public Grupo buscarGrupoPorId(int idGrupo) throws IsspolSearchException {
        Criterion criterion = Restrictions.eq("idGrupo", idGrupo);
        return grupoDao.buscarPorCriterio(criterion);
    }

    @Override
    public List<Grupo> listarTodos() throws IsspolSearchException {
        boolean estadoEliminado= false;
        Criterion criterion = Restrictions.eq("eliminado", estadoEliminado);
        return grupoDao.listarPorCriterio(criterion);
    }

    @Override
    public Grupo buscarGrupoPorNombre(String nombre) throws IsspolSearchException {
        Criterion criterion = Restrictions.eq("nombre", nombre);
        return grupoDao.buscarPorCriterio(criterion);
    }

    @Override
    public PagedResult<Grupo> listarGrupoPaginado(FilterParam filterParam) throws IsspolSearchException {
        try{
            return grupoDao.listarGrupoPaginado(filterParam);
        }catch (Exception e){
            throw new IsspolSearchException("ERROR al listar los registros paginados", e);
        }
    }

    public void setGrupoDao(GrupoDao grupoDao) {
        this.grupoDao = grupoDao;
    }
}
