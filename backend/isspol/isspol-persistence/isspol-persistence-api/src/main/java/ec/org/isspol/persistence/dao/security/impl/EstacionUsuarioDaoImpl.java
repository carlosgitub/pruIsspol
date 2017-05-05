package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.EstacionUsuarioDao;
import ec.org.isspol.persistence.entities.security.EstacionUsuario;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by mavelin.ati on 18/04/2017.
 */
public class EstacionUsuarioDaoImpl extends GenericDaoImpl<EstacionUsuario, Integer> implements EstacionUsuarioDao {

    public EstacionUsuarioDaoImpl() {
        super(EstacionUsuario.class);
    }

    public List<EstacionUsuario> listarTodosEstacionUsuario() throws IsspolSearchException {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(EstacionUsuario.class);

        criteria.createAlias("estacion", "estacionA");
        criteria.setFetchMode("estacionA", FetchMode.JOIN);

        criteria.createAlias("usuario", "usuarioA");
        criteria.setFetchMode("usuarionA", FetchMode.JOIN);

        return criteria.list();
    }

    public List<EstacionUsuario> listarEstacionUsuarioPorUsuario(String idUsuario) throws IsspolSearchException {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(EstacionUsuario.class);

        criteria.createAlias("estacion", "estacionA");
        criteria.setFetchMode("estacionA", FetchMode.JOIN);

        criteria.createAlias("usuario", "usuarioA");
        criteria.setFetchMode("usuarionA", FetchMode.JOIN)
                .add(Restrictions.eq("usuario.idUsuario", idUsuario));

        criteria.add(Restrictions.eq("eliminado", Boolean.FALSE));
        criteria.addOrder(Order.asc("idEstacionUsuario"));

        return criteria.list();
    }

    @Override
    public PagedResult<EstacionUsuario> listarEstacionUsuarioNoEliminadoPorUsuario(
            String idUsuario, FilterParam filterParam) throws IsspolSearchException {

        PagedResult<EstacionUsuario> result = null;
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteriaCount = sessionHibernate.createCriteria(EstacionUsuario.class);
        Long numRows = (Long) criteriaCount.setProjection(Projections.rowCount()).uniqueResult();

        if(numRows!=null && numRows >0){
            result = new PagedResult<EstacionUsuario>();
            Criteria criteria = sessionHibernate.createCriteria(EstacionUsuario.class);

            criteria.createAlias("estacion", "estacionA");
            criteria.setFetchMode("estacionA", FetchMode.JOIN);

            criteria.createAlias("usuario", "usuarioA");
            criteria.setFetchMode("usuarionA", FetchMode.JOIN)
                    .add(Restrictions.eq("usuario.idUsuario", idUsuario));

            criteria.add(Restrictions.eq("eliminado", Boolean.FALSE));
            criteria.addOrder(Order.asc("idEstacionUsuario"));
            criteria.setFirstResult(filterParam.getFirstResult());
            criteria.setMaxResults(filterParam.getItemsPerPage());
            result.setItems(criteria.list());
            result.setTotalCount(numRows);
        }
        return result;
    }
}