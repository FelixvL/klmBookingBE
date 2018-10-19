package yc.klm.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.klm.booking.domain.Passenger;
import yc.klm.booking.repositories.PassengerRepository;

import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Optional<Passenger> findById(Long aLong) {
        return passengerRepository.findById(aLong);
    }

    public Iterable<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public void deleteById(Long aLong) {
        passengerRepository.deleteById(aLong);
    }
}
