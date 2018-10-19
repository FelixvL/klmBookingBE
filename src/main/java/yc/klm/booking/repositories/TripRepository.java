package yc.klm.booking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import yc.klm.booking.domain.Trip;

@Component
public interface TripRepository extends CrudRepository<Trip, Long> {

}
