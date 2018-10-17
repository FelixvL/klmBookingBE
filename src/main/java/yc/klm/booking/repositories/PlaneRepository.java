package yc.klm.booking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import yc.klm.booking.domain.Plane;

@Component
public interface PlaneRepository extends CrudRepository<Plane, Long>  {

}
