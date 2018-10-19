package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import yc.klm.booking.domain.Plane;
import yc.klm.booking.services.AirTrafficService;
import yc.klm.booking.services.PlaneService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Component
@Path("planes")
public class PlaneEndpoint {

    @Autowired
    private PlaneService planeService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@RequestBody Plane plane) {
        plane.setId(0);
        return Response.ok(this.planeService.save(plane)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        Iterable<Plane> planes =this.planeService.findAll();
        return Response.ok(planes).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") long id) {

        Optional<Plane> planeOptional = this.planeService.findById(id);
        if (planeOptional.isPresent()) {
            return Response.ok(planeOptional.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, @RequestBody Plane input) {

        Optional<Plane> planeOptional = this.planeService.findById(id);
        if (planeOptional.isPresent()) {
            Plane plane = planeOptional.get();
            plane.setTrips(input.getTrips());
            plane.setBrand(input.getBrand());
            plane.setName(input.getName());
            plane.setModel(input.getModel());
            plane.setCapacity(input.getCapacity());

            this.planeService.save(plane);

            return Response.ok(plane).build();

        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {

        Optional<Plane> planeOptional = this.planeService.findById(id);

        // NB: If id is not present the removing will fail in throwing an Exception since Spring Boot 2.0,
        // hence this check!
        if (planeOptional.isPresent()) {
            this.planeService.deleteById(id);

            return Response.noContent().build();
        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
