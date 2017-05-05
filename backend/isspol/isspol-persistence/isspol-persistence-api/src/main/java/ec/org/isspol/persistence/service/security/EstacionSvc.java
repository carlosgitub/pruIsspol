package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.entities.security.Estacion;

import java.util.List;

/**
 * Created by mavelin.ati on 21/04/2017.
 */
public interface EstacionSvc {

    void insertarEstacion(Estacion estacion) throws IsspolPersistException;
    void actualizarEstacion(Estacion estacion) throws IsspolPersistException;

    List<Estacion> listarTodosEstacion() throws IsspolSearchException;
    Estacion buscarEstacionPorId(Integer id) throws IsspolSearchException;
    PagedResult<Estacion> listarEstacionNoEliminado(FilterParam filterParam) throws IsspolSearchException;
}
