package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.Token;
import ec.org.isspol.persistence.service.security.TokenSvc;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by carlos.calo on 27/04/2017.
 */
public class TokenSvImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(TokenSvImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }


    @Test
    @Ignore
    public void testBuscarTokenPorDato() throws IsspolSearchException {
        TokenSvc tokenSvc = (TokenSvc) getBean("tokenSvc");
        Token token = tokenSvc.buscarTokenPorDato("6da3ac6a-a1af-3064-9293-108e3bda80f4");
        logger.info("Token {} Usuario {}", token, token.getUsuario().getIdUsuario());
    }
}
