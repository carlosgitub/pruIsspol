package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.Icono;

import java.util.List;

/**
 * Created by paul.salgado on 21/04/2017.
 */
public interface IconoSvc {

    void insertarIcono(Icono icono) throws IsspolPersistException;
    void actualizarIcono(Icono icono) throws IsspolPersistException;
    void eliminarIcono(Icono icono) throws IsspolPersistException;
    List<Icono> listarTodosIcono() throws IsspolSearchException;
    Icono buscarIconoPorId(Integer id) throws IsspolSearchException;
}
