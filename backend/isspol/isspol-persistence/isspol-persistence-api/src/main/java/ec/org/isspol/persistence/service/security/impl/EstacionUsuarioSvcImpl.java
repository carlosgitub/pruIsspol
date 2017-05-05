package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.security.EstacionUsuarioDao;
import ec.org.isspol.persistence.entities.security.EstacionUsuario;
import ec.org.isspol.persistence.service.security.EstacionUsuarioSvc;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by mavelin.ati on 18/04/2017.
 */
public class EstacionUsuarioSvcImpl implements EstacionUsuarioSvc {

    private EstacionUsuarioDao estacionUsuarioDao;

    @Override
    public void insertarEstacionUsuario(EstacionUsuario estacionUsuario) throws IsspolPersistException {
        estacionUsuarioDao.insertar(estacionUsuario);
    }

    @Override
    public void actualizarEstacionUsuario(EstacionUsuario estacionUsuario) throws IsspolPersistException {
        estacionUsuarioDao.actualizar(estacionUsuario);
    }

    @Override
    public List<EstacionUsuario> listarTodosEstacionUsuario() throws IsspolSearchException {
        return estacionUsuarioDao.listarTodosEstacionUsuario();
    }

    @Override
    public EstacionUsuario buscarEstacionUsuarioPorId(Integer id) throws IsspolSearchException {
        Criterion criterion = Restrictions.eq("idEstacionUsuario", id);
        EstacionUsuario estacionUsuario = null;
        try{
            estacionUsuario = estacionUsuarioDao.buscarPorCriterio(criterion);
        } catch (IsspolSearchException ex){
            throw  new IsspolSearchException(ex);
        }
        return estacionUsuario;
    }

    @Override
    public List<EstacionUsuario> listarEstacionUsuarioPorUsuario(String idUsuario) throws IsspolSearchException {
        return estacionUsuarioDao.listarEstacionUsuarioPorUsuario(idUsuario);
    }

    @Override
    public PagedResult<EstacionUsuario> listarEstacionUsuarioNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException {
        try{
            return estacionUsuarioDao.listarEstacionUsuarioNoEliminadoPorUsuario(idUsuario, filterParam);
        }catch (Exception e){
            throw new IsspolSearchException("ERROR al listar los registros: EstacionUsuario", e);
        }
    }


    public void setEstacionUsuarioDao(EstacionUsuarioDao estacionUsuarioDao) {
        this.estacionUsuarioDao = estacionUsuarioDao;
    }
}
