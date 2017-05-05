package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.security.TokenDao;
import ec.org.isspol.persistence.entities.security.Token;
import ec.org.isspol.persistence.service.security.TokenSvc;
import org.hibernate.criterion.Restrictions;


/**
 * @author carlos.calo
 * @date 27/04/2017
 */
public class TokenSvcImpl implements TokenSvc {

    private TokenDao tokenDao;

    public Token buscarTokenPorDato(String dato) throws IsspolSearchException {
        return tokenDao.buscarTokenPorDato(dato);
    }

    public void setTokenDao(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }
}
