package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yc.klm.booking.domain.Plane;
import yc.klm.booking.services.AirTrafficService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("planes")
public class PlaneEndpoint {

    @Autowired
    private AirTrafficService airTrafficService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllPlanes() {
        Iterable<Plane> planes = airTrafficService.getAllPlanes();
        return Response.ok(planes).build();
    }
}
