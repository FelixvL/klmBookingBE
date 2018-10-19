package yc.klm.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.klm.booking.domain.Airport;
import yc.klm.booking.repositories.AirportRepository;

import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    public Optional<Airport> findById(Long aLong) {
        return airportRepository.findById(aLong);
    }

    public Iterable<Airport> findAll() {
        return airportRepository.findAll();
    }

    public void deleteById(Long aLong) {
        airportRepository.deleteById(aLong);
    }
}
