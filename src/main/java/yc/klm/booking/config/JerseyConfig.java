package yc.klm.booking.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import yc.klm.booking.api.*;

import javax.ws.rs.ApplicationPath;


@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(AccountEndpoint.class);
        register(OrderEndpoint.class);
        register(AirportEndpoint.class);
        register(PassengerEndpoint.class);
        register(PlaneEndpoint.class);
        register(TrajectEndpoint.class);
        register(TripEndpoint.class);
    }

}
