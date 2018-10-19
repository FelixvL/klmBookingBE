package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import yc.klm.booking.domain.Order;
import yc.klm.booking.domain.Passenger;
import yc.klm.booking.services.AirTrafficService;
import yc.klm.booking.services.PassengerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Component
@Path("passengers")
public class PassengerEndpoint {

    @Autowired
    private AirTrafficService airTrafficService;

    @Autowired
    private PassengerService passengerService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@RequestBody Passenger passenger) {
        return Response.ok(this.passengerService.save(passenger)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllPassengers() {
        Iterable<Passenger> passengers = airTrafficService.getAllPassengers();
        return Response.ok(passengers).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTrajects(@PathParam("id") long id) {

        Optional<Passenger> optionalPassenger = this.passengerService.findById(id);
        if (optionalPassenger.isPresent()) {
            return Response.ok(optionalPassenger.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listTrajects(@PathParam("id") long id, @RequestBody Passenger input) {

        Optional<Passenger> passengerOptional = this.passengerService.findById(id);
        if (passengerOptional.isPresent()) {
            Passenger passenger = passengerOptional.get();
            passenger.setName(input.getName());
            passenger.setTrips(input.getTrips());

            this.passengerService.save(passenger);

            return Response.ok(passenger).build();

        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {

        Optional<Passenger> passengerOptional = this.passengerService.findById(id);

        // NB: If id is not present the removing will fail in throwing an Exception since Spring Boot 2.0,
        // hence this check!
        if (passengerOptional.isPresent()) {
            this.passengerService.deleteById(id);

            return Response.noContent().build();
        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
