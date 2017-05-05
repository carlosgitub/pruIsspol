package ec.org.isspol.persistence.dao.comun;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.service.comun.ParametroSvc;
import ec.org.isspol.persistence.entities.comun.Parametro;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public class ParametroSvcTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ParametroSvcTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void testBuscarParametroPorId() throws IsspolException, IsspolSearchException {
        ParametroSvc parametroSvc = (ParametroSvc) getBean("parametroSvc");
        Parametro parametro = parametroSvc.buscarParametroPorId(IsspolConstant.HOST_SMTP);
        logger.info("Parametro {}", parametro);
    }
}
