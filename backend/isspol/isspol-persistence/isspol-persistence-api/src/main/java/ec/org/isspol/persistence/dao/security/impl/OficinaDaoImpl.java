package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.OficinaDao;
import ec.org.isspol.persistence.entities.security.Oficina;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Created by mauchilan on 20/3/17.
 */
public class OficinaDaoImpl extends GenericDaoImpl<Oficina, Integer> implements OficinaDao {

    public OficinaDaoImpl() {
        super(Oficina.class);
    }

    @Override
    public PagedResult<Oficina> listarOficinaPaginado(FilterParam filterParam) throws IsspolSearchException {
        PagedResult<Oficina> result = null;
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteriaCount = sessionHibernate.createCriteria(Oficina.class);
        Long numRows = (Long) criteriaCount.setProjection(Projections.rowCount()).uniqueResult();
        if(numRows!=null && numRows >0){
            result = new PagedResult<Oficina>();
            Criteria criteria = sessionHibernate.createCriteria(Oficina.class);

            criteria.createAlias("tipoOficina", "tipoOficinaA");
            criteria.setFetchMode("tipoOficinaA", FetchMode.JOIN);

            criteria.createAlias("estado", "estadoA");
            criteria.setFetchMode("estadoA", FetchMode.JOIN);

            criteria.createAlias("sucursal", "sucursalA");
            criteria.setFetchMode("sucursalA", FetchMode.JOIN);

            criteria.createAlias("empresa", "empresaA");
            criteria.setFetchMode("empresaA", FetchMode.JOIN);

            criteria.createAlias("provincia", "provinciaA");
            criteria.setFetchMode("provinciaA", FetchMode.JOIN);

            criteria.createAlias("canton", "cantonA");
            criteria.setFetchMode("cantonA", FetchMode.JOIN);

            criteria.add(Restrictions.eq("eliminado", Boolean.FALSE));
            criteria.addOrder(Order.asc("nombre"));
            criteria.setFirstResult(filterParam.getFirstResult());
            criteria.setMaxResults(filterParam.getItemsPerPage());
            result.setItems(criteria.list());
            result.setTotalCount(numRows);
        }
        return result;
    }
}
