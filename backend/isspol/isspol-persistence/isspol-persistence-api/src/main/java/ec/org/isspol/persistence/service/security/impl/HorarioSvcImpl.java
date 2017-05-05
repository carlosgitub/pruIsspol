package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.security.HorarioDao;
import ec.org.isspol.persistence.entities.security.Horario;
import ec.org.isspol.persistence.service.security.HorarioSvc;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class HorarioSvcImpl implements HorarioSvc {

    private HorarioDao horarioDao;

    @Override
    public Horario buscarPorCriterio(Criterion criterion) throws IsspolSearchException {
        return horarioDao.buscarPorCriterio(criterion);
    }

    @Override
    public List<Horario> listarHorario() throws IsspolSearchException {
        return horarioDao.listarPorCriterio(null);
    }

    public void setHorarioDao(HorarioDao horarioDao) {
        this.horarioDao = horarioDao;
    }

}
