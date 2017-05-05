package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import ec.org.isspol.persistence.service.security.EstadoUsuarioSvc;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class EstadoUsuarioDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(EstadoUsuarioDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void getAllEstadoUsuario() throws IsspolSearchException {
        EstadoUsuarioSvc estadoUsuarioSvc = (EstadoUsuarioSvc) getBean("estadoUsuarioSvc");
        List<EstadoUsuario> estadoUsuarios = estadoUsuarioSvc.listarEstadoUsuario();
        for (EstadoUsuario estadoUsuario: estadoUsuarios){
            logger.info("Estado Usuario {} --> {}", estadoUsuario.getIdEstadoUsuario(), estadoUsuario.getDescripcion());
        }
        Assert.assertNotNull(estadoUsuarios);
    }

}
