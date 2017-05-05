package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.Token;

/**
 * @author carlos.calo
 * @date 27/04/2017
 */
public interface TokenSvc {

    Token buscarTokenPorDato(String dato) throws IsspolSearchException;

}
