package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;

import java.util.Collection;


/**
 * Created by paul.salgado on 21/3/17.
 */
public interface EstructuraOrganizacionalDao extends GenericDao<EstructuraOrganizacional, Integer> {

    Collection<EstructuraOrganizacional> listarEstructuraOrg()throws IsspolSearchException;

}
