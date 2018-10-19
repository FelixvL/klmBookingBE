package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import yc.klm.booking.domain.Order;
import yc.klm.booking.services.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Component
@Path("orders")
public class OrderEndpoint {

    @Autowired
    private OrderService orderService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@RequestBody Order order) {
        return Response.ok(this.orderService.save(order)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        Iterable<Order> orders = this.orderService.findAll();
        return Response.ok(orders).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") long id) {

        Optional<Order> optionalOrder = this.orderService.findById(id);
        if (optionalOrder.isPresent()) {
            return Response.ok(optionalOrder.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, @RequestBody Order input) {

        Optional<Order> optionalOrder = this.orderService.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setLuggage(input.getLuggage()); // from input => order

            // rloman more here

            this.orderService.save(order);

            return Response.ok(order).build();

        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {

        Optional<Order> optionalOrder = this.orderService.findById(id);

        // NB: If id is not present the removing will fail in throwing an Exception since Spring Boot 2.0,
        // hence this check!
        if (optionalOrder.isPresent()) {
            this.orderService.deleteById(id);

            return Response.noContent().build();
        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
