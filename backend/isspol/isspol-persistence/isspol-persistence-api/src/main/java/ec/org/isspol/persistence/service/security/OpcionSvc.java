package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.Opcion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul.salgado on 21/04/2017.
 */
public interface OpcionSvc {

    void insertarOpcion(Opcion opcion) throws IsspolPersistException;
    void actualizarOpcion(Opcion opcion) throws IsspolPersistException;
    void eliminarOpcion(Opcion opcion) throws IsspolPersistException;
    List<Opcion> listarTodosOpcion() throws IsspolSearchException;
    List<Opcion> listarOpcionPorIdCarpetaOpcion(Integer id) throws IsspolSearchException;
    Opcion buscarOpcionPorId(Integer id) throws IsspolSearchException;

    public Map<String, Object> obtenerOpcionUsoFrecuentes(HashMap<String, Object> values) throws IsspolPersistException;
}
