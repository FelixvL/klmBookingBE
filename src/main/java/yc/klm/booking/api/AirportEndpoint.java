package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import yc.klm.booking.domain.Airport;
import yc.klm.booking.services.AirTrafficService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("airports")
public class AirportEndpoint {

    @Autowired
    private AirTrafficService airTrafficService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllAirports() {
        Iterable<Airport> airports = airTrafficService.getAllAirports();
        return Response.ok(airports).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAirport(@RequestBody Airport airport) {
        airport = airTrafficService.addAirport(airport);
        return Response.ok(airport).build();
    }
}
