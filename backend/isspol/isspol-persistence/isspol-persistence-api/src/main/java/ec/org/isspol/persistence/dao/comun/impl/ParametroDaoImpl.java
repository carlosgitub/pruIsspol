package ec.org.isspol.persistence.dao.comun.impl;

import ec.org.isspol.persistence.dao.comun.ParametroDao;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.entities.comun.Parametro;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public class ParametroDaoImpl extends GenericDaoImpl<Parametro, String> implements ParametroDao {

    public ParametroDaoImpl() {
        super(Parametro.class);
    }
}
