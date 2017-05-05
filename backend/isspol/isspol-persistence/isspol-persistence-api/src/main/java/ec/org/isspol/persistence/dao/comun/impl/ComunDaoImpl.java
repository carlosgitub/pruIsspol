package ec.org.isspol.persistence.dao.comun.impl;

import ec.org.isspol.persistence.dao.comun.ComunDao;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.entities.comun.Canton;
import ec.org.isspol.persistence.entities.comun.Pais;
import ec.org.isspol.persistence.entities.comun.Provincia;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by andres.campoverde on 17/04/2017.
 */
public class ComunDaoImpl extends GenericDaoImpl<Pais,Integer> implements ComunDao {
    public ComunDaoImpl() {
        super(Pais.class);
    }

    @Override
    public List<Pais> getAllPais() {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(Pais.class);
        return criteria.list();
    }


}
