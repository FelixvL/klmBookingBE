package yc.klm.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.klm.booking.domain.Trip;
import yc.klm.booking.repositories.TripRepository;

import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    public Optional<Trip> findById(Long aLong) {
        return tripRepository.findById(aLong);
    }

    public Iterable<Trip> findAll() {
        return tripRepository.findAll();
    }

    public void deleteById(Long aLong) {
        tripRepository.deleteById(aLong);
    }
}
