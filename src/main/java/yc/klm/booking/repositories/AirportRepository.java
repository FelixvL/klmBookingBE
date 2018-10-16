package yc.klm.booking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import yc.klm.booking.domain.Airport;

@Component
public interface AirportRepository extends CrudRepository<Airport, Long>  {

}
