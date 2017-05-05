package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.EstacionDao;
import ec.org.isspol.persistence.entities.security.Estacion;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by mavelin.ati on 21/04/2017.
 */
public class EstacionDaoImpl extends GenericDaoImpl<Estacion, Integer> implements EstacionDao {

    public EstacionDaoImpl() {
        super(Estacion.class);
    }


    @Override
    public List<Estacion> listarTodosEstacion() throws IsspolSearchException {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(Estacion.class);

        criteria.add(Restrictions.eq("eliminado", Boolean.FALSE));
        criteria.addOrder(Order.asc("hostname"));

        return criteria.list();
    }

    @Override
    public PagedResult<Estacion> listarEstacionNoEliminado(FilterParam filterParam) throws IsspolSearchException {
        PagedResult<Estacion> result = null;
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteriaCount = sessionHibernate.createCriteria(Estacion.class);

        Long numRows = (Long) criteriaCount.setProjection(Projections.rowCount()).uniqueResult();
        if(numRows!=null && numRows >0){
            result = new PagedResult<Estacion>();
            Criteria criteria = sessionHibernate.createCriteria(Estacion.class);

            criteria.add(Restrictions.eq("eliminado", Boolean.FALSE));
            criteria.addOrder(Order.asc("hostname"));
            criteria.setFirstResult(filterParam.getFirstResult());
            criteria.setMaxResults(filterParam.getItemsPerPage());
            result.setItems(criteria.list());
            result.setTotalCount(numRows);
        }
        return result;
    }
}
