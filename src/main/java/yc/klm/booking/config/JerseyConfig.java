package yc.klm.booking.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import yc.klm.booking.api.AccountEndpoint;
import yc.klm.booking.api.AirTrafficEndpoint;
import yc.klm.booking.api.OrderEndpoint;

import javax.ws.rs.ApplicationPath;


@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(AirTrafficEndpoint.class);
        register(AccountEndpoint.class);
        register(OrderEndpoint.class);

    }

}
