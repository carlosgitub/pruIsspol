package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.EstructuraOrganizacionalDao;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.Collection;

/**
 * Created by paul.salgado on 21/3/17.
 */
public class EstructuraOrganizacionalDaoImpl extends GenericDaoImpl<EstructuraOrganizacional, Integer> implements EstructuraOrganizacionalDao {

    public EstructuraOrganizacionalDaoImpl() {
        super(EstructuraOrganizacional.class);
    }

    @Override
    public Collection<EstructuraOrganizacional> listarEstructuraOrg() throws IsspolSearchException {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(EstructuraOrganizacional.class);

        criteria.add(Restrictions.isNull("padreEstructuraOrganizacional.id"));
        criteria.createAlias("children", "childrenA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("childrenA", FetchMode.JOIN);
        criteria.add(Restrictions.eq("eliminado",Boolean.FALSE));
        criteria.add(Restrictions.eq("childrenA.eliminado",Boolean.FALSE));

        criteria.createAlias("nivel", "_nivel", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("_nivel", FetchMode.JOIN);

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        Collection<EstructuraOrganizacional> lista= criteria.list();

        return lista ;
    }
}
