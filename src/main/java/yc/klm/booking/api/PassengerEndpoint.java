package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yc.klm.booking.domain.Passenger;
import yc.klm.booking.services.AirTrafficService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("passengers")
public class PassengerEndpoint {

    @Autowired
    private AirTrafficService airTrafficService;

    @Path("passengers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllPassengers() {
        Iterable<Passenger> passengers = airTrafficService.getAllPassengers();
        return Response.ok(passengers).build();
    }
}
