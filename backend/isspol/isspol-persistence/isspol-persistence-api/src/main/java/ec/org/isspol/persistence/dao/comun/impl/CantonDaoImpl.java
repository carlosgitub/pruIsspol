package ec.org.isspol.persistence.dao.comun.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.comun.CantonDao;
import ec.org.isspol.persistence.entities.comun.Canton;

/**
 * Created by Javier on 27/04/2017.
 */
public class CantonDaoImpl extends GenericDaoImpl<Canton, Integer> implements CantonDao {
    public CantonDaoImpl(){
        super(Canton.class);
    }
}
