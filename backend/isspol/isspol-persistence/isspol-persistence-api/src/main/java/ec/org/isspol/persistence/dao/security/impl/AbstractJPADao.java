package ec.org.isspol.persistence.dao.security.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by mauchilan on 20/3/17.
 */
public abstract class AbstractJPADao {

    protected EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

}
