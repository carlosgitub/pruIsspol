package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;
import ec.org.isspol.persistence.service.security.EstructuraOrganizacionalSvc;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by santiago.yacelga on 19/04/2017.
 */
public class EstrOrganizacionalTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(EstrOrganizacionalTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void testListarEstructuraOrganizacional () throws IsspolSearchException{
        EstructuraOrganizacionalDao estructuraOrganizacionalDao = (EstructuraOrganizacionalDao) getBean("estructuraOrganizacionalDao");
        Collection<EstructuraOrganizacional> lst = estructuraOrganizacionalDao.listarEstructuraOrg();
        for(EstructuraOrganizacional iterado: lst){
            System.out.println(iterado.getCodigo());
        }

    }

    @Test
    public void testEliminarEstructuraOrganizacional() throws IsspolPersistException, IsspolException {
        EstructuraOrganizacionalSvc estructuraOrganizacionalSvc = (EstructuraOrganizacionalSvc) getBean("estructuraOrganizacionalSvc");

        HashMap<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AI_ID_ESTRUCTURA, 73);
        in.put(IsspolConstant.AS_USUARIO, "yo");
        in.put(IsspolConstant.AS_MSJ , "Root B");

        Map<String, Object> result = estructuraOrganizacionalSvc.procEstructuraOrganizacionalEliminar(in);
        Assert.assertNotNull(result);
        logger.info("{}",result);
        Assert.assertNotNull(result);



    }

    @Test
    public void testEstrucuturaActualizar() throws IsspolException, IsspolPersistException {
        EstructuraOrganizacionalSvc estructuraOrganizacionalSvc = (EstructuraOrganizacionalSvc) getBean("estructuraOrganizacionalSvc");

        HashMap<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AI_ID_ESTRUCTURA, 1);
        in.put(IsspolConstant.AS_CODIGO, "32");
        in.put(IsspolConstant.AS_DESCRIPCION , "Root B");
        in.put(IsspolConstant.AI_ORDEN, 1);
        in.put(IsspolConstant.AI_NIVEL, 1);
        in.put(IsspolConstant.AI_ID_ESTRUCTURA_PADRE, null);
        in.put(IsspolConstant.AS_USUARIO, "455");
        in.put(IsspolConstant.AS_MSJ, "455");
        in.put(IsspolConstant.AS_USUARIO_ACT, "SYACELGA");


        Map<String, Object> result = estructuraOrganizacionalSvc.procEstructuraOrganizacionalGuardar(in);
        Assert.assertNotNull(result);
        logger.info("{}",result);
        Assert.assertNotNull(result);
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

    }


}
