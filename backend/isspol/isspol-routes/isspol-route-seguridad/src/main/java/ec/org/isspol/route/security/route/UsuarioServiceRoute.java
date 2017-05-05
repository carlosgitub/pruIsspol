package ec.org.isspol.route.security.route;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by mauchilan on 22/3/17.
 */
public class UsuarioServiceRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:usuario").to("bean:usuarioService?method=callRemoteService");
        from("activemq:afiliacionCola").to("bean:afiliacionServiceBean?method=callRemoteService");
    }

}
