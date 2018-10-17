package yc.klm.booking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import yc.klm.booking.domain.Passenger;

@Component
public interface PassengerRepository extends CrudRepository<Passenger, Long>  {

}
