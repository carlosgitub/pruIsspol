package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.NivelEstructuraOrgDao;
import ec.org.isspol.persistence.entities.security.NivelEstructuraOrg;

/**
 * Created by Edison Aulestia on 24/4/17.
 */
public class NivelEstructuraOrgDaoImpl extends GenericDaoImpl<NivelEstructuraOrg, Integer> implements NivelEstructuraOrgDao {

    public NivelEstructuraOrgDaoImpl() {
        super(NivelEstructuraOrg.class);
    }

}
