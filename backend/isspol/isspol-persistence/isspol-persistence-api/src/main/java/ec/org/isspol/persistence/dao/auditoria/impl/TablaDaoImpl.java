package ec.org.isspol.persistence.dao.auditoria.impl;

import ec.org.isspol.persistence.dao.auditoria.TablaDao;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.entities.auditoria.Tabla;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public class TablaDaoImpl extends GenericDaoImpl<Tabla,Integer> implements TablaDao {
    public TablaDaoImpl() {
        super(Tabla.class);
    }

    @Override
    public List<Tabla> listaTabla() {
        Session sessionHibernate = entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(Tabla.class);

        return criteria.list();
    }
}
