package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.Sucursal;

/**
 * SucursalDao para el mantenimiento de sucursales principales
 * Interfaz donde se definen los métodos para el mantenimiento de las Sucursales principales *
 * Fecha: 13/04/2017
 * Autor: Javier Parada
 */

public interface SucursalDao extends GenericDao<Sucursal, Integer>{
    void insertarSucursal(Sucursal sucursal) throws IsspolPersistException;
    PagedResult<Sucursal> listarSucursalPaginado(FilterParam filterParam) throws IsspolSearchException;

}
