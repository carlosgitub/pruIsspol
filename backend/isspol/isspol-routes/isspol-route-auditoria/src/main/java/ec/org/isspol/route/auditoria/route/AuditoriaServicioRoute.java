package ec.org.isspol.route.auditoria.route;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by mauchilan on 22/3/17.
 */
public class AuditoriaServicioRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:auditoria")
                .to("bean:auditoriaServicio?method=callRemoteService");
    }

}
