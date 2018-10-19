package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import yc.klm.booking.domain.Trip;
import yc.klm.booking.services.AirTrafficService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("trips")
public class TripEndpoint {

    @Autowired
    private AirTrafficService airTrafficService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAirport(@RequestBody Trip trip) {
        trip = airTrafficService.addFlight(trip);
        return Response.ok(trip).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllFlights() {
        Iterable<Trip> flights = airTrafficService.getAllFlights();
        return Response.ok(flights).build();
    }


}
