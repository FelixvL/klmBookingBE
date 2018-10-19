package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import yc.klm.booking.domain.Trip;
import yc.klm.booking.services.TripService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Component
@Path("trips")
public class TripEndpoint {

    @Autowired
    private TripService tripService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@RequestBody Trip trip) {

        return Response.ok(this.tripService.save(trip)).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        Iterable<Trip> flights = tripService.findAll();
        return Response.ok(flights).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") long id) {

        Optional<Trip> tripOptional = this.tripService.findById(id);
        if (tripOptional.isPresent()) {
            return Response.ok(tripOptional.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") long id, @RequestBody Trip input) {

        Optional<Trip> tripOptional = this.tripService.findById(id);
        if (tripOptional.isPresent()) {
            Trip trip = tripOptional.get();
            trip.setOrigin(input.getOrigin());
            trip.setDestination(input.getDestination());
            trip.setDuration(input.getDuration());

            this.tripService.save(trip);

            return Response.ok(trip).build();

        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {

        Optional<Trip> tripOptional = this.tripService.findById(id);

        // NB: If id is not present the removing will fail in throwing an Exception since Spring Boot 2.0,
        // hence this check!
        if (tripOptional.isPresent()) {
            this.tripService.deleteById(id);

            return Response.noContent().build();
        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
