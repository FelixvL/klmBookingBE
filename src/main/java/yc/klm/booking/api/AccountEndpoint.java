package yc.klm.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import yc.klm.booking.domain.Account;
import yc.klm.booking.services.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Component
@Path("accounts")
public class AccountEndpoint {

    @Autowired
    private AccountService accountService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@RequestBody Account account) {
        return Response.ok(this.accountService.save(account)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        Iterable<Account> accounts = this.accountService.findAll();
        return Response.ok(accounts).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") long id) {

        Optional<Account> optionalAccount = this.accountService.findById(id);
        if (optionalAccount.isPresent()) {
            return Response.ok(optionalAccount.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") long id, @RequestBody Account input) {

        Optional<Account> optionalAccount = this.accountService.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setCity(input.getCity());// from input => account
            account.setCountry(input.getCountry());
            account.setEmail(input.getEmail());
            account.setFirstName(input.getFirstName());
            account.setLastName(input.getLastName());
            account.setPassportNumber(input.getPassportNumber());
            account.setPhoneNumber(input.getPhoneNumber());
            account.setPostalCode(input.getPostalCode());
            account.setStreet(input.getStreet());
            account.setStreetNumber(input.getStreetNumber());
            account.setType(input.getType());

            this.accountService.save(account);

            return Response.ok(account).build();

        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {

        Optional<Account> optionalAccount = this.accountService.findById(id);

        // NB: If id is not present the removing will fail in throwing an Exception since Spring Boot 2.0,
        // hence this check!
        if (optionalAccount.isPresent()) {
            this.accountService.deleteById(id);

            return Response.noContent().build();
        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
