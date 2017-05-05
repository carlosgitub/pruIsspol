package ec.org.isspol.persistence.dao.comun.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.comun.ProvinciaDao;
import ec.org.isspol.persistence.entities.comun.Provincia;

/**
 * Created by Javier on 27/04/2017.
 */
public class ProvinciaDaoImpl extends GenericDaoImpl<Provincia, Integer> implements ProvinciaDao {
    public ProvinciaDaoImpl(){
        super(Provincia.class);
    }
}
