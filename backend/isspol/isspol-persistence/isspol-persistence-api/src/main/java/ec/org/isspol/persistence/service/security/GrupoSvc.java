package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.entities.security.Grupo;

import java.util.List;

/**
 * GrupoSvc
 * Es la interfaz servicio para declarar la firma de los metodos que administran la entidad Grupo
 * Fecha: 2017-04-13
 * @autor Edison Aulestia
 * */
public interface GrupoSvc {

    void insertarActualizarGrupo(Grupo grupo) throws IsspolPersistException;
    void eliminarGrupo(Grupo grupo) throws IsspolPersistException;
    Grupo buscarGrupoPorId(int idGrupo) throws IsspolSearchException;
    List<Grupo> listarTodos()throws IsspolSearchException;
    Grupo buscarGrupoPorNombre(String nombre)throws IsspolSearchException;
    PagedResult<Grupo> listarGrupoPaginado(FilterParam filterParam) throws IsspolSearchException;

}
