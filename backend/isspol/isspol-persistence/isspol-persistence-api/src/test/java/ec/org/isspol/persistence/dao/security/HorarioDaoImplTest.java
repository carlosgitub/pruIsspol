package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.Horario;
import ec.org.isspol.persistence.service.security.HorarioSvc;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class HorarioDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(HorarioDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void testHorariosGetAll() throws IsspolSearchException {
        HorarioSvc horarioSvc = (HorarioSvc) getBean("horarioSvc");
        List<Horario> horarios = horarioSvc.listarHorario();
        for (Horario horario: horarios){
            logger.info("Horarios {} --> {}", horario.getIdHorario(), horario.getDescripcion());
        }
        Assert.assertNotNull(horarios);
    }

}
