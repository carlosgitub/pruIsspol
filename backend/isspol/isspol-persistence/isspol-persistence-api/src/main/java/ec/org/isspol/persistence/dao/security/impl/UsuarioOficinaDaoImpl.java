package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.UsuarioOficinaDao;
import ec.org.isspol.persistence.entities.security.Sucursal;
import ec.org.isspol.persistence.entities.security.UsuarioOficina;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mavelin.ati on 05/05/2017.
 */
public class UsuarioOficinaDaoImpl extends GenericDaoImpl<UsuarioOficina, Integer> implements UsuarioOficinaDao {

    public UsuarioOficinaDaoImpl() {
        super(UsuarioOficina.class);
    }

    public List<UsuarioOficina> listarTodosUsuarioOficina() throws IsspolSearchException {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(UsuarioOficina.class);

        criteria.createAlias("oficina", "oficinaA");
        criteria.setFetchMode("oficinaA", FetchMode.JOIN);

        criteria.createAlias("usuario", "usuarioA");
        criteria.setFetchMode("usuarionA", FetchMode.JOIN);

        return criteria.list();
    }

    public List<UsuarioOficina> listarUsuarioOficinaPorUsuario(String idUsuario) throws IsspolSearchException {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(UsuarioOficina.class);

        criteria.createAlias("oficina", "oficinaA");
        criteria.setFetchMode("oficinaA", FetchMode.JOIN);

        criteria.createAlias("usuario", "usuarioA");
        criteria.setFetchMode("usuarionA", FetchMode.JOIN)
                .add(Restrictions.eq("usuario.idUsuario", idUsuario));

        criteria.add(Restrictions.eq("eliminado", Boolean.FALSE));
        criteria.addOrder(Order.asc("idUsuarioOficina"));

        return criteria.list();
    }

    @Override
    public PagedResult<UsuarioOficina> listarUsuarioOficinaNoEliminadoPorUsuario(
            String idUsuario, FilterParam filterParam) throws IsspolSearchException {

        PagedResult<UsuarioOficina> result = null;
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteriaCount = sessionHibernate.createCriteria(UsuarioOficina.class);
        Long numRows = (Long) criteriaCount.setProjection(Projections.rowCount()).uniqueResult();

        if(numRows!=null && numRows >0){
            result = new PagedResult<UsuarioOficina>();
            Criteria criteria = sessionHibernate.createCriteria(UsuarioOficina.class);

            criteria.createAlias("oficina", "oficinaA");
            criteria.setFetchMode("oficinaA", FetchMode.JOIN);

            criteria.createAlias("usuario", "usuarioA");
            criteria.setFetchMode("usuarionA", FetchMode.JOIN)
                    .add(Restrictions.eq("usuario.idUsuario", idUsuario));

            criteria.add(Restrictions.eq("eliminado", Boolean.FALSE));
            criteria.addOrder(Order.asc("idUsuarioOficina"));
            criteria.setFirstResult(filterParam.getFirstResult());
            criteria.setMaxResults(filterParam.getItemsPerPage());
            result.setItems(criteria.list());
            result.setTotalCount(numRows);
        }
        return result;
    }

}
