package ec.org.isspol.persistence.service.comun.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.ParametroDao;
import ec.org.isspol.persistence.service.comun.ParametroSvc;
import ec.org.isspol.persistence.entities.comun.Parametro;
import org.hibernate.criterion.Restrictions;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public class ParametroSvcImpl implements ParametroSvc {
    ParametroDao parametroDao;

    @Override
    public Parametro buscarParametroPorId(String idParametro) throws IsspolSearchException {
        return parametroDao.buscarPorCriterio(Restrictions.eq("parametro", idParametro));
    }

    /**
     *
     * @param parametroDao
     */
    public void setParametroDao(ParametroDao parametroDao) {
        this.parametroDao = parametroDao;
    }
}
