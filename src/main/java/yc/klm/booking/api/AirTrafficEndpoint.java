package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yc.klm.booking.domain.Airport;
import yc.klm.booking.services.AirTrafficService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("airports")
@Component
public class AirTrafficEndpoint {

    @Autowired
    private AirTrafficService airTrafficService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGroep(){
        Iterable <Airport> airports = airTrafficService.getAllAirports();
        return Response.ok(airports).build();
    }



}