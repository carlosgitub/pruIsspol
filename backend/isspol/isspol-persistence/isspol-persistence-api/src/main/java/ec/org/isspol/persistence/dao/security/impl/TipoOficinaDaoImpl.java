package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.TipoOficinaDao;
import ec.org.isspol.persistence.entities.security.TipoOficina;

/**
 * Created by Javier on 28/04/2017.
 */
public class TipoOficinaDaoImpl extends GenericDaoImpl<TipoOficina, Integer> implements TipoOficinaDao{
    public TipoOficinaDaoImpl(){
        super(TipoOficina.class);
    }

}
