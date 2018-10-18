package yc.klm.booking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yc.klm.booking.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
