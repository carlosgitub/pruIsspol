package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.TokenDao;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;
import ec.org.isspol.persistence.entities.security.Token;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.Collection;


/**
 * @author carlos.calo
 * @date 27/04/2017
 */
public class TokenDaoImpl extends GenericDaoImpl<Token, Integer> implements TokenDao {

    public TokenDaoImpl(){
        super(Token.class);
    }

    @Override
    public Token buscarTokenPorDato(String dato) {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(Token.class);

        criteria.add(Restrictions.eq("dato", dato));
        criteria.createAlias("usuario", "u", JoinType.INNER_JOIN);
        criteria.setFetchMode("u", FetchMode.JOIN);

        return (Token) criteria.setMaxResults(1).uniqueResult();
    }
}
