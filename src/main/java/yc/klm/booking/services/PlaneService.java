package yc.klm.booking.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.klm.booking.domain.Plane;
import yc.klm.booking.repositories.PlaneRepository;

import java.util.Optional;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    public Plane save(Plane plane) {
        return planeRepository.save(plane);
    }

    public Optional<Plane> findById(Long aLong) {
        return planeRepository.findById(aLong);
    }

    public Iterable<Plane> findAll() {
        return planeRepository.findAll();
    }

    public void deleteById(Long aLong) {
        planeRepository.deleteById(aLong);
    }
}
