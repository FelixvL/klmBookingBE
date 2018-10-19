package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import yc.klm.booking.domain.Airport;
import yc.klm.booking.services.AirTrafficService;
import yc.klm.booking.services.AirportService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Component
@Path("airports")
public class AirportEndpoint {

    @Autowired
    private AirportService airportService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAirport(@RequestBody Airport airport) {
        airport = this.airportService.save(airport);
        return Response.ok(airport).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        Iterable<Airport> airports = this.airportService.findAll();
        return Response.ok(airports).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") long id) {

        Optional<Airport> optionalAirport = this.airportService.findById(id);
        if (optionalAirport.isPresent()) {
            return Response.ok(optionalAirport.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listTrajects(@PathParam("id") long id, @RequestBody Airport input) {

        Optional<Airport> optionalAirport = this.airportService.findById(id);
        if (optionalAirport.isPresent()) {
            Airport airport = optionalAirport.get();
            airport.setAbbreviation(input.getAbbreviation());// from input => airport

            // rloman more here

            this.airportService.save(airport);

            return Response.ok(airport).build();

        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {

        Optional<Airport> optionalAirport = this.airportService.findById(id);

        // NB: If id is not present the removing will fail in throwing an Exception since Spring Boot 2.0,
        // hence this check!
        if (optionalAirport.isPresent()) {
            this.airportService.deleteById(id);

            return Response.noContent().build();
        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
