package ec.org.isspol.test.seguridad.route;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.security.*;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by santiago.yacelga on 21/04/2017.
 */
public class UsuarioOficinaTest extends CamelSpringTestSupport {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceClientTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
    }

    @Test
    @Ignore
    public void testInsertarSucursal() throws IsspolPersistException {
        UsuarioOficina usuarioOficina = new UsuarioOficina();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("afierro");
        usuarioOficina.setUsuario(usuario);
        Oficina  oficina = new Oficina();
        oficina.setIdOficina(1);
        usuarioOficina.setOficina(oficina);

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        usuarioOficina.setCreacionFecha(ts);
        usuarioOficina.setCreacionEquipo("PC-JPA");
        usuarioOficina.setCreacionUsuario("ADM");
        usuarioOficina.setModificaUsuario("JPA");
        usuarioOficina.setModificaFecha(ts);
        usuarioOficina.setEliminado(Boolean.FALSE);
        usuarioOficina.setModificaEquipo("PC-MODIFICA");
        logger.info("Creating Sucursal {} {}", usuarioOficina.getUsuario(),usuarioOficina.getOficina());

        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_INSERTAR_USUARIO_OFICINA);
        peticionRespuesta.setParameters(new Object[]{usuarioOficina});
        try {
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            if (peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (Exception ex) {
            throw new IsspolPersistException("------Existe un error-----", ex);
        }


    }

    @Test
    @Ignore
    public void testListarUsuarioOficinaPorId() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_USUARIO_OFICINA_POR_USUARIO);
        peticionRespuesta.setParameters(new Object[]{"jnunez"});
        peticionRespuesta = usuarioService.callRemoteService((peticionRespuesta));
        List<UsuarioOficina> usuarioOficinas= new ArrayList<>();
        usuarioOficinas=(List<UsuarioOficina>) peticionRespuesta.getResullt();
        for(UsuarioOficina uo:usuarioOficinas){
            logger.info("ID usuario: {}", uo.getUsuario().getIdUsuario());
            logger.info("NOMBRE oficina: {}", uo.getOficina().getIdOficina());
        }

        //return grupo;
    }


}
