package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FieldFilter;
import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.persistence.service.security.OficinaSvc;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class OficinaDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(OficinaDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void getAllOficina() throws IsspolSearchException {
        OficinaSvc oficinaSvc = (OficinaSvc) getBean("oficinaSvc");
        List<Oficina> oficinas = oficinaSvc.listarOficina();
        for (Oficina oficina : oficinas) {
            logger.info("Oficina: {} - {}", oficina.getNombre(), oficina.getDireccion());
        }
        Assert.assertNotNull(oficinas);
    }

    @Test
    public void testListarPaginado() throws IsspolSearchException {
        OficinaDao oficinaDao = (OficinaDao) getBean("oficinaDao");
        FilterParam filterParam = new FilterParam(3, 0);
        PagedResult<Oficina> pagedResult = oficinaDao.listarOficinaPaginado(filterParam);
        for (Oficina oficina : (List<Oficina>) pagedResult.getItems()) {
            logger.info("Resultado {}, {} ", oficina.getNombre(), oficina.getCanton().getNombre());
        }
        Assert.assertNotNull(pagedResult);
    }

    @Test
    public void testBuscarOficinaPorId() throws IsspolSearchException {
        OficinaSvc oficinaSvc = (OficinaSvc) getBean("oficinaSvc");
        Oficina oficina=oficinaSvc.buscarOficinaPorId(1);
        logger.info("Oficina {}",oficina.getNombre());
    }
}
