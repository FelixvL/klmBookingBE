package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import yc.klm.booking.domain.Airport;
import yc.klm.booking.domain.Traject;
import yc.klm.booking.services.AirTrafficService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Component
@Path("trajects")
public class TrajecEndpoint {

    @Autowired
    private AirTrafficService airTrafficService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTrajects() {
        return Response.ok(this.airTrafficService.getAllTrajects()).build();
    }

    @Path("add/departure/{departureId}/arrival/{arrivalId}")
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
