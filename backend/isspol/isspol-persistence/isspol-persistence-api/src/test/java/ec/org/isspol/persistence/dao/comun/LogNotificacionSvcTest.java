package ec.org.isspol.persistence.dao.comun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public class LogNotificacionSvcTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ParametroSvcTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

}
