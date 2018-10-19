package yc.klm.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.klm.booking.domain.Order;
import yc.klm.booking.repositories.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order o) {
        return orderRepository.save(o);
    }

    public Optional<Order> findById(Long aLong) {
        return orderRepository.findById(aLong);
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public void deleteById(Long aLong) {
        orderRepository.deleteById(aLong);
    }
}
