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




}