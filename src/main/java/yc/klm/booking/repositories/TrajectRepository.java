package yc.klm.booking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yc.klm.booking.domain.Traject;

@Repository
public interface TrajectRepository extends CrudRepository<Traject, Long> {

}
