package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.CarpetaOpcion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul.salgado on 21/04/2017.
 */
public interface CarpetaOpcionSvc {

    void insertarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException;
    void actualizarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException;
    void eliminarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException;
    List<CarpetaOpcion> listarTodosCarpetaOpcion() throws IsspolSearchException;
    List<CarpetaOpcion> listarCarpetaOpcionPorIdCarpetaPadre(Integer id) throws IsspolSearchException;
    CarpetaOpcion buscarCarpetaOpcionPorId(Integer id) throws IsspolSearchException;

    public Map<String, Object> obtenerCarpetaOpcionPorGrupo(HashMap<String, Object> values) throws IsspolPersistException;
}
