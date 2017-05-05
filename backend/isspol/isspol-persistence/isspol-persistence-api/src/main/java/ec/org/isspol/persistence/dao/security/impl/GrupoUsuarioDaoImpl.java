package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.GrupoUsuarioDao;
import ec.org.isspol.persistence.entities.security.GrupoUsuario;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by mavelin.ati on 18/04/2017.
 */
public class GrupoUsuarioDaoImpl extends GenericDaoImpl<GrupoUsuario, Integer> implements GrupoUsuarioDao{

    public GrupoUsuarioDaoImpl(){
        super(GrupoUsuario.class);
    }

    public List<GrupoUsuario> listarTodosGrupoUsuario() throws IsspolSearchException {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(GrupoUsuario.class);

        criteria.createAlias("grupo", "grupoA");
        criteria.setFetchMode("grupoA", FetchMode.JOIN);

        criteria.createAlias("usuario", "usuarioA");
        criteria.setFetchMode("usuarionA", FetchMode.JOIN);

        return criteria.list();
    }

    @Override
    public List<GrupoUsuario> listarGrupoUsuarioPorUsuario(String idUsuario) throws IsspolSearchException {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(GrupoUsuario.class);

        criteria.createAlias("grupo", "grupoA");
        criteria.setFetchMode("grupoA", FetchMode.JOIN);

        criteria.createAlias("usuario", "usuarioA");
        criteria.setFetchMode("usuarionA", FetchMode.JOIN)
                .add(Restrictions.eq("usuario.idUsuario", idUsuario));

        criteria.add(Restrictions.eq("eliminado", Boolean.FALSE));
        criteria.addOrder(Order.asc("idGrupoUsuario"));

        return criteria.list();
    }

    @Override
    public PagedResult<GrupoUsuario> listarGrupoUsuarioNoElimiandoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException {

        PagedResult<GrupoUsuario> result = null;
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteriaCount = sessionHibernate.createCriteria(GrupoUsuario.class);
        Long numRows = (Long) criteriaCount.setProjection(Projections.rowCount()).uniqueResult();

        if(numRows!=null && numRows >0){
            result = new PagedResult<GrupoUsuario>();
            Criteria criteria = sessionHibernate.createCriteria(GrupoUsuario.class);

            criteria.createAlias("grupo", "grupoA");
            criteria.setFetchMode("grupoA", FetchMode.JOIN);

            criteria.createAlias("usuario", "usuarioA");
            criteria.setFetchMode("usuarionA", FetchMode.JOIN)
                    .add(Restrictions.eq("usuario.idUsuario", idUsuario));

            criteria.add(Restrictions.eq("eliminado", Boolean.FALSE));
            criteria.addOrder(Order.asc("idGrupoUsuario"));
            criteria.setFirstResult(filterParam.getFirstResult());
            criteria.setMaxResults(filterParam.getItemsPerPage());
            result.setItems(criteria.list());
            result.setTotalCount(numRows);
        }
        return result;
    }
}
