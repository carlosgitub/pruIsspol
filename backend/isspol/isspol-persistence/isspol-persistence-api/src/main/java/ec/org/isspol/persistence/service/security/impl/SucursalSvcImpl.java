package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.security.SucursalDao;
import ec.org.isspol.persistence.entities.security.Sucursal;
import ec.org.isspol.persistence.service.security.SucursalSvc;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Javier on 13/04/2017.
 */
public class SucursalSvcImpl implements SucursalSvc {

    private SucursalDao sucursalDao;


    @Override

    public void insertarSucursal(Sucursal sucursal) throws IsspolPersistException {
        try{
            sucursalDao.insertarSucursal(sucursal);
        }catch (Exception e){
            throw new IsspolPersistException("ERROR al insertar el registro",e);
        }
    }

    @Override
    public void actualizarSucursal(Sucursal sucursal) throws IsspolPersistException {
        try{
            sucursalDao.actualizar(sucursal);
        }catch (Exception e){
            throw new IsspolPersistException("ERROR al actualizar el registro", e);
        }
    }

    @Override
    public void eliminarSucursal(Sucursal sucursal) throws IsspolPersistException {
        try {
            //sucursalDao.eliminar(sucursal);/*eliminacion física*/
            sucursalDao.actualizar(sucursal);/*eliminacion lógica*/
        }catch (Exception e){
            throw new IsspolPersistException("ERROR al eliminar el registro", e);
        }
    }

    @Override
    public List<Sucursal> listarTodasSucursales() throws IsspolSearchException {
        Boolean estadoEliminado = false;
        Criterion criterion = Restrictions.eq("eliminado", estadoEliminado);
        try{
            return sucursalDao.listarPorCriterio(criterion);
        }catch (IsspolSearchException e){
            throw new IsspolSearchException("ERROR al listar los registros", e);
        }
    }


    @Override
    public Sucursal buscarSucursalPorId(Integer id) throws IsspolSearchException {
        Criterion criterion = Restrictions.eq("idSucursal", id);
        try {
            return sucursalDao.buscarPorCriterio(criterion);
        }catch (IsspolSearchException ex){
            throw  new IsspolSearchException("",ex);
        }
    }

    @Override
    public PagedResult<Sucursal> listarSucursalPaginado(FilterParam filterParam) throws IsspolSearchException {
        try{
            return sucursalDao.listarSucursalPaginado(filterParam);
        }catch (Exception e){
            throw new IsspolSearchException("ERROR al listar los registros paginados", e);
        }
    }

    public void setSucursalDao(SucursalDao sucursalDao) {
        this.sucursalDao = sucursalDao;
    }
}
