package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Response listAllAirports(){
        Iterable <Airport> airports = airTrafficService.getAllAirports();
        return Response.ok(airports).build();
    }

    @Path("flights")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllFlights(){
        Iterable <Flight> flights = airTrafficService.getAllFlights();
        return Response.ok(flights).build();
    }
    
    @Path("passengers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllPassengers(){
        Iterable <Passenger> passengers = airTrafficService.getAllPassengers();
        return Response.ok(passengers).build();
    }
    
    @Path("planes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllPlanes(){
        Iterable <Plane> planes = airTrafficService.getAllPlanes();
        return Response.ok(planes).build();
    }
    
    
    @Path("airport/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAirport(@RequestBody Airport airport){
        airport = airTrafficService.addAirport(airport);
        return Response.ok(airport).build();
    }
    
    @Path("flight/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAirport(@RequestBody Flight flight){
        flight = airTrafficService.addFlight(flight);
        return Response.ok(flight).build();
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
    public Response addTraject(@PathVariable("departureId") long departureId,
                               @PathVariable("arrivalId") long arrivalId,
                               @RequestBody Traject traject){

        Optional<Airport> departureAirportOptional = this.airTrafficService.findAirportById(departureId);
        if(departureAirportOptional.isPresent()) {

        }

        Traject newTraject = new Traject();


    }


}