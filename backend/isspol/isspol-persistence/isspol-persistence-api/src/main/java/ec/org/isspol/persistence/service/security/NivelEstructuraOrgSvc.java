package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.NivelEstructuraOrg;

import java.util.List;

/**
 * Created by paul.salgado on 18/04/2017.
 */
public interface NivelEstructuraOrgSvc {

    List<NivelEstructuraOrg> listarTodosNivelEstructuraOrg() throws IsspolSearchException;
}
