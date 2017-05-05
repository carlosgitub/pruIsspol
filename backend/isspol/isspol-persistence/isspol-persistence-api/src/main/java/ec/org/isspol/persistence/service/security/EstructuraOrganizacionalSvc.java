package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul.salgado on 18/04/2017.
 */
public interface EstructuraOrganizacionalSvc {
    /**
     * Este metodo permite trae todas las estructuras organizacionales
     * junto con su nivel correspondiente
     * @return Collection<EstructuraOrganizacional>
     * @throws IsspolSearchException
     * @Author santiago.yacelga
     */
    Collection<EstructuraOrganizacional> listarEstructuraOrg()throws IsspolSearchException;

    /**
     * Este metodo permite trae todas las estructuras organizacionales
     * sin tomar en cuenta los niveles
     * @return Collection<EstructuraOrganizacional>
     * @throws IsspolSearchException
     */
    List<EstructuraOrganizacional> listarTodosEstructuraOrganizacional() throws IsspolSearchException;

    public Map<String, Object> listarCargo() throws IsspolPersistException;

    public Map<String, Object> procEstructuraOrganizacionalGuardar(HashMap<String, Object> values) throws IsspolPersistException, IsspolPersistException;

    public Map<String, Object> procEstructuraOrganizacionalEliminar(HashMap<String, Object> values) throws IsspolPersistException, IsspolPersistException;
}
