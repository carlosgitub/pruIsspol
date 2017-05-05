package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.GrupoDao;
import ec.org.isspol.persistence.entities.security.Grupo;
import ec.org.isspol.persistence.entities.security.Sucursal;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import java.sql.Timestamp;
import java.util.Date;

/**
 * GrupoDaoImpl
 * Es la clase que implementa la interfaz GrupoDao con sus metodos que administran la entidad Grupo
 * Fecha: 2017-04-13
 *
 * @autor Edison Aulestia
 **/
public class GrupoDaoImpl extends GenericDaoImpl<Grupo, Integer> implements GrupoDao {

    public GrupoDaoImpl() {
        super(Grupo.class);
    }


    @Override
    public void insertarActualizarGrupo(Grupo grupo) throws IsspolPersistException {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        grupo.setCreacionFecha(ts);

        if (grupo.getIdGrupo() == null) {
            grupo.setCreacionFecha(ts);
            insertar(grupo);
        }else
        {
            grupo.setModificaFecha(ts);
            actualizar(grupo);
        }
    }

    @Override
    public PagedResult<Grupo> listarGrupoPaginado(FilterParam filterParam) throws IsspolSearchException {
        PagedResult<Grupo> result = null;
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteriaCount = sessionHibernate.createCriteria(Grupo.class);
        Long numRows = (Long) criteriaCount.setProjection(Projections.rowCount()).uniqueResult();
        if(numRows!=null && numRows >0){
            result = new PagedResult<Grupo>();
            Criteria criteria = sessionHibernate.createCriteria(Grupo.class);
            criteria.addOrder(Order.asc("idGrupo"));
            criteria.setFirstResult(filterParam.getFirstResult());
            criteria.setMaxResults(filterParam.getItemsPerPage());
            result.setItems(criteria.list());
            result.setTotalCount(numRows);
        }

        return result;
    }
}
