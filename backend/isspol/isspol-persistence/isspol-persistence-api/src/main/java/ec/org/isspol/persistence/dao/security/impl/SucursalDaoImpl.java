package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.SucursalDao;
import ec.org.isspol.persistence.entities.security.Sucursal;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * SucursalDaoImpl
 * Clase que implementa la interfaz SucursalDao para el mantenimiento de Sucursal principal
 * Fecha: 13/04/2017
 * Autor: Javier Parada
 */
public class SucursalDaoImpl extends GenericDaoImpl<Sucursal, Integer> implements SucursalDao {

    public SucursalDaoImpl() {
        super(Sucursal.class);
    }

    @Override
    public void insertarSucursal(Sucursal sucursal) throws IsspolPersistException {
        Calendar calendar = Calendar.getInstance();
        Timestamp nowTimestamp = new Timestamp(calendar.getTime().getTime());
        try {
            if (sucursal.getIdSucursal() == null) {
                sucursal.setCreacionFecha(nowTimestamp);
                insertar(sucursal);
            } else {
                sucursal.setModificaFecha(nowTimestamp);
                actualizar(sucursal);
            }
        }catch (IsspolPersistException ex) {
            throw new IsspolPersistException("ERROR EN DAO PER...", ex);
        }
    }

    @Override
    public PagedResult<Sucursal> listarSucursalPaginado(FilterParam filterParam) throws IsspolSearchException {
        PagedResult<Sucursal> result = null;
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteriaCount = sessionHibernate.createCriteria(Sucursal.class);
        Long numRows = (Long) criteriaCount.setProjection(Projections.rowCount()).uniqueResult();
        if(numRows!=null && numRows >0){
            result = new PagedResult<Sucursal>();
            Criteria criteria = sessionHibernate.createCriteria(Sucursal.class);

            criteria.add(Restrictions.eq("eliminado", Boolean.FALSE));
            criteria.addOrder(Order.asc("idSucursal"));
            criteria.setFirstResult(filterParam.getFirstResult());
            criteria.setMaxResults(filterParam.getItemsPerPage());
            result.setItems(criteria.list());
            result.setTotalCount(numRows);
        }

        return result;
    }
}
