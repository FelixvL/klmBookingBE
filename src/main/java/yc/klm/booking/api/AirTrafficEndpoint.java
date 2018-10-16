package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yc.klm.booking.domain.Airport;
import yc.klm.booking.domain.Flight;
import yc.klm.booking.services.AirTrafficService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


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


}