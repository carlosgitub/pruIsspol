package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.security.EstadoUsuarioDao;
import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import ec.org.isspol.persistence.service.security.EstadoUsuarioSvc;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class EstadoUsuarioSvcImpl implements EstadoUsuarioSvc {

    private EstadoUsuarioDao estadoUsuarioDao;

    @Override
    public EstadoUsuario buscarPorCriterio(Criterion criterion)throws IsspolSearchException{
        return estadoUsuarioDao.buscarPorCriterio(criterion);
    }

    @Override
    public List<EstadoUsuario> listarEstadoUsuario() throws IsspolSearchException {
        return estadoUsuarioDao.listarPorCriterio(null);
    }

    public void setEstadoUsuarioDao(EstadoUsuarioDao estadoUsuarioDao) {
        this.estadoUsuarioDao = estadoUsuarioDao;
    }

}
