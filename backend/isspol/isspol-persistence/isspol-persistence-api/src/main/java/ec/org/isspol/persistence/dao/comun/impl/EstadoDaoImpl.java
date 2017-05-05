package ec.org.isspol.persistence.dao.comun.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.comun.EstadoDao;
import ec.org.isspol.persistence.entities.comun.Estado;

/**
 * Created by Javier on 03/05/2017.
 */
public class EstadoDaoImpl extends GenericDaoImpl<Estado, Integer> implements EstadoDao{
    public EstadoDaoImpl() {
        super(Estado.class);
    }
}
