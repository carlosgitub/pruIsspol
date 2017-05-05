package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.security.EstacionDao;
import ec.org.isspol.persistence.entities.security.Estacion;
import ec.org.isspol.persistence.service.security.EstacionSvc;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by mavelin.ati on 21/04/2017.
 */
public class EstacionSvcImpl implements EstacionSvc{

    private EstacionDao estacionDao;

    @Override
    public void insertarEstacion(Estacion estacion) throws IsspolPersistException {
        estacionDao.insertar(estacion);
    }

    @Override
    public void actualizarEstacion(Estacion estacion) throws IsspolPersistException {
        estacionDao.actualizar(estacion);
    }

    @Override
    public List<Estacion> listarTodosEstacion() throws IsspolSearchException {
        return estacionDao.listarTodosEstacion();
    }

    @Override
    public Estacion buscarEstacionPorId(Integer id) throws IsspolSearchException {
        Criterion criterion = Restrictions.eq("idEstacion", id);
        Estacion estacion = null;
        try{
            estacion = estacionDao.buscarPorCriterio(criterion);
        } catch (IsspolSearchException ex){
            throw  new IsspolSearchException(ex);
        }
        return estacion;
    }

    @Override
    public PagedResult<Estacion> listarEstacionNoEliminado(FilterParam filterParam) throws IsspolSearchException {
        try {
            return estacionDao.listarEstacionNoEliminado(filterParam);
        } catch (Exception e){
            throw new IsspolSearchException("ERROR al listar los registros paginados de Estacion", e);
        }
    }

    public void setEstacionDao(EstacionDao estacionDao) {
        this.estacionDao = estacionDao;
    }
}
