package yc.klm.booking.config;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import yc.klm.booking.api.AirTrafficEndpoint;



@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(AirTrafficEndpoint.class);

    }

}
