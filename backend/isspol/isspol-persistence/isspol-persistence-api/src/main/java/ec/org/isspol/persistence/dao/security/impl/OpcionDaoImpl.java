package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.OpcionDao;
import ec.org.isspol.persistence.entities.security.Opcion;

/**
 * Created by paul.salgado on 21/04/2017.
 */
public class OpcionDaoImpl extends GenericDaoImpl<Opcion, Integer> implements OpcionDao {

    public OpcionDaoImpl() {
        super(Opcion.class);
    }

}
