package ec.org.isspol.route.comun.route;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by andres.campoverde on 18/04/2017.
 */
public class ComunServicioRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:comun")
                .to("bean:comunServicio?method=callRemoteService");
    }
}
