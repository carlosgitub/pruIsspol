package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.entities.security.Sucursal;

import java.util.List;

/**
 * Created by Javier on 13/04/2017.
 */
public interface SucursalSvc {
    void insertarSucursal(Sucursal sucursal) throws IsspolPersistException;
    void actualizarSucursal(Sucursal sucursal) throws IsspolPersistException;
    void eliminarSucursal(Sucursal sucursal)throws IsspolPersistException;
    List<Sucursal> listarTodasSucursales() throws IsspolSearchException; /*Sin paginacion*/
    Sucursal buscarSucursalPorId(Integer id) throws IsspolSearchException;
    PagedResult<Sucursal> listarSucursalPaginado(FilterParam filterParam) throws IsspolSearchException;
}
