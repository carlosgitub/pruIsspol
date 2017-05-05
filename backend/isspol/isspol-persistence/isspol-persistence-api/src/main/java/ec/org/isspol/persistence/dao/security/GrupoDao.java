package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.Grupo;

/**
 * GrupoDao
 * Es la interfaz Dao para declarar la firma de los metodos que administran la entidad Grupo
 * Fecha: 2017-04-13
 *
 * @autor Edison Aulestia
 */
public interface GrupoDao extends GenericDao<Grupo, Integer> {
    void insertarActualizarGrupo(Grupo grupo) throws IsspolPersistException;
    PagedResult<Grupo> listarGrupoPaginado(FilterParam filterParam) throws IsspolSearchException;
}
