package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.CarpetaOpcionDao;
import ec.org.isspol.persistence.entities.security.CarpetaOpcion;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import java.util.List;

/**
 * Created by paul.salgado on 21/04/2017.
 */
public class CarpetaOpcionDaoImpl extends GenericDaoImpl<CarpetaOpcion, Integer> implements CarpetaOpcionDao {

    public CarpetaOpcionDaoImpl() {
        super(CarpetaOpcion.class);
    }

    @Override
    public List<CarpetaOpcion> listarCarpetaOpcion() throws IsspolSearchException {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(CarpetaOpcion.class);

        criteria.add(Restrictions.isNull("carpetaOpcion"));

        criteria.createAlias("carpetaOpcions", "carpetaOpcionsA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("carpetaOpcionsA", FetchMode.JOIN);

        criteria.createAlias("opcions", "opcionsA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("opcionsA", FetchMode.JOIN);

        //criteria.add(Restrictions.eq("eliminado",Boolean.FALSE));
        //criteria.add(Restrictions.eq("childrenA.eliminado",Boolean.FALSE));

        criteria.createAlias("carpetaOpcion", "carpetaOpcionA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("carpetaOpcionA", FetchMode.JOIN);

        criteria.createAlias("icono", "iconoA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("iconoA", FetchMode.JOIN);

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<CarpetaOpcion> lista= criteria.list();

        return lista ;
    }

}
