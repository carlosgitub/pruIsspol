package ec.org.isspol.test.seguridad.route;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;
import ec.org.isspol.persistence.entities.security.NivelEstructuraOrg;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by santiago.yacelga on 21/04/2017.
 */
public class EstrucutruraTst extends CamelSpringTestSupport {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceClientTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
    }


    @Test
    public void testProcEstructuraOrganizacionalEliminar() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AI_ID_ESTRUCTURA, 46);
        in.put(IsspolConstant.AS_USUARIO, "yo");
        in.put(IsspolConstant.AS_MSJ , "Root B");
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METHOD_PROC_ESTRUCTURA_ORGANIZACIONAL_ELIMINAR);
        peticionRespuesta.setParameters(new Object[]{in});
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        Map<String, Object> response = (Map<String, Object>) peticionRespuesta.getResullt();
        for (Map.Entry<String, Object> entry : response.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    @Test
    public void listarEstructuraOrgan(){

        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        List<EstructuraOrganizacional> lstEstr = null;
        try {
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURANIVEL);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lstEstr = (List<EstructuraOrganizacional>) peticionRespuesta.getResullt();

            for(EstructuraOrganizacional iterador:lstEstr){
                System.out.println(iterador.getCodigo());
            };

            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method f".concat(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURANIVEL), e);
        }
    }


    @Test
    public void listarEstructuraOrganizacional(){

        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        List<EstructuraOrganizacional> lstEstr = null;
        try {
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURA);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lstEstr = (List<EstructuraOrganizacional>) peticionRespuesta.getResullt();

            for(EstructuraOrganizacional iterador:lstEstr){
                System.out.println(iterador.getCodigo());
            };

            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method f".concat(IsspolConstant.METHOD_GET_ALL_ESTRUCUTURA), e);
        }
    }

    @Test
    public void listarTodosNivelEstructuraOrg(){

        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        List<NivelEstructuraOrg> lstNivelEstr = null;
        try {
            PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTA_NIVEL_ESTRUCUTURA_ORG);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lstNivelEstr = (List<NivelEstructuraOrg>) peticionRespuesta.getResullt();

            for(NivelEstructuraOrg iterador:lstNivelEstr){
                System.out.println(iterador.getDescripcion());
            };

            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method f".concat(IsspolConstant.METHOD_LISTA_NIVEL_ESTRUCUTURA_ORG), e);
        }
    }
}
