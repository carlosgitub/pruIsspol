package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.IconoDao;
import ec.org.isspol.persistence.entities.security.Icono;

/**
 * Created by paul.salgado on 21/04/2017.
 */
public class IconoDaoImpl extends GenericDaoImpl<Icono, Integer> implements IconoDao {

    public IconoDaoImpl() {
        super(Icono.class);
    }

}
