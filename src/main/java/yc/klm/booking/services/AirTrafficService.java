package yc.klm.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yc.klm.booking.domain.Airport;
import yc.klm.booking.repositories.AirportRepository;

@Service
@Transactional
public class AirTrafficService {
	@Autowired
	private AirportRepository airportRepository;
	
	public Iterable<Airport> getAllAirports(){
		return airportRepository.findAll();
	}

}
