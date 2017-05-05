package ec.org.isspol.persistence.dao.common.impl;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.common.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    private static final Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> type;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    public void insertar(T entity) throws IsspolPersistException {
        try {
            entityManager.persist(entity);
            entityManager.flush();
        } catch (Exception ex) {
            throw new IsspolPersistException("Error al guardar", ex);
        }
    }

    public void actualizar(T entity) throws IsspolPersistException {
        try {
            entityManager.merge(entity);
            entityManager.flush();
        } catch (Exception ex) {
            throw new IsspolPersistException("Error al actualizar", ex);
        }
    }

    public void eliminar(T entity) throws IsspolPersistException {
        try {
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            entityManager.flush();
        } catch (Exception ex) {
            throw new IsspolPersistException("Error al eliminar", ex);
        }
    }

    public T buscarPorCriterio(Criterion criterion) throws IsspolSearchException {
        T entity = null;
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        try {
            entity = (T) sessionHibernate.createCriteria(type)
                    .setMaxResults(1).add(criterion).uniqueResult();
        } catch (Exception e) {
            logger.error("Error ", e);
            throw new IsspolSearchException("Error al buscar ", e);
        }
        return entity;
    }

    public List<T> listarPorCriterio(Criterion criterion) {
        List<T> lista = new ArrayList<T>();
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        try {
            Criteria criteria = sessionHibernate.createCriteria(type);
            if (criterion != null)
                criteria.add(criterion);
            lista = criteria.list();
        } catch (Exception e) {
            logger.error("Error ", e);
        }
        return lista;
    }

    public List<T> listarPorCriterioOrden(Criterion criterion, List<Order> orden) {
        List<T> lista = new ArrayList<T>();
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        try {
            Criteria criteria = sessionHibernate.createCriteria(type);
            if (criterion != null)
                criteria.add(criterion);

            for (Order o : orden) {
                criteria.addOrder(o);
            }
            lista = criteria.list();
        } catch (Exception e) {
            logger.error("Error ", e);
        }
        return lista;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
