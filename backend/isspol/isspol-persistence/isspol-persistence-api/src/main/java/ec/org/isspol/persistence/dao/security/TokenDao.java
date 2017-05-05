package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.Token;


/**
 * @author carlos.calo
 * @date 27/04/2017
 */
public interface TokenDao extends GenericDao<Token, Integer> {

    public Token buscarTokenPorDato(String dato);
}
