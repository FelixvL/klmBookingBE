package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import yc.klm.booking.domain.*;
import yc.klm.booking.services.AirTrafficService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;


@Path("airtraffic")
@Component
public class AirTrafficEndpoint {

    @Autowired
    private AirTrafficService airTrafficService;

    @Path("airports")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllAirports() {
        Iterable<Airport> airports = airTrafficService.getAllAirports();
        return Response.ok(airports).build();
    }

    @Path("flights")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllFlights() {
        Iterable<Trip> flights = airTrafficService.getAllFlights();
        return Response.ok(flights).build();
    }

    @Path("passengers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllPassengers() {
        Iterable<Passenger> passengers = airTrafficService.getAllPassengers();
        return Response.ok(passengers).build();
    }

    @Path("planes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllPlanes() {
        Iterable<Plane> planes = airTrafficService.getAllPlanes();
        return Response.ok(planes).build();
    }


    @Path("airport/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAirport(@RequestBody Airport airport) {
        airport = airTrafficService.addAirport(airport);
        return Response.ok(airport).build();
    }

    @Path("trip/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAirport(@RequestBody Trip trip) {
        trip = airTrafficService.addFlight(trip);
        return Response.ok(trip).build();
    }

    @Path("trajects")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTrajects() {
        return Response.ok(this.airTrafficService.getAllTrajects()).build();
    }

    @Path("trajects/add/departure/{departureId}/arrival/{arrivalId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes
    public Response addTraject(@PathParam("departureId") long departureId,
                               @PathParam("arrivalId") long arrivalId,
                               @RequestBody Traject traject) { // should be TrajectModel or some

        Optional<Airport> departureAirportOptional = this.airTrafficService.findAirportById(departureId);
        if (departureAirportOptional.isPresent()) {
            Optional<Airport> arrivalAirportOptional = this.airTrafficService.findAirportById(arrivalId);
            if (arrivalAirportOptional.isPresent()) {
                Traject newTraject = new Traject();
                newTraject.setDepartureAirport(departureAirportOptional.get());
                newTraject.setArrivalAirport(arrivalAirportOptional.get());
                newTraject.setInactiveStartdate(traject.getInactiveStartdate());
                newTraject.setInactiveEnddate(traject.getInactiveEnddate());

                this.airTrafficService.save(newTraject);

                return Response.ok(newTraject).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}