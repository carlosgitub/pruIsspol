package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.security.NivelEstructuraOrgDao;
import ec.org.isspol.persistence.entities.security.NivelEstructuraOrg;
import ec.org.isspol.persistence.service.security.NivelEstructuraOrgSvc;

import java.util.List;

/**
 * Created by paul.salgado on 18/04/2017.
 */
public class NivelEstructuraOrgSvcImpl implements NivelEstructuraOrgSvc {

    private NivelEstructuraOrgDao nivelEstructuraOrgDao;

    @Override
    public List<NivelEstructuraOrg> listarTodosNivelEstructuraOrg() throws IsspolSearchException {
        return nivelEstructuraOrgDao.listarPorCriterio(null);
    }

    public void setNivelEstructuraOrgDao(NivelEstructuraOrgDao nivelEstructuraOrgDao) {
        this.nivelEstructuraOrgDao = nivelEstructuraOrgDao;
    }
}
