package yc.klm.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yc.klm.booking.domain.*;
import yc.klm.booking.repositories.*;

import java.util.Optional;

@Service
@Transactional
public class AirTrafficService {
	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private PlaneRepository planeRepository;

	@Autowired
	private TrajectRepository trajectRepository;
	
	public Iterable<Airport> getAllAirports(){
		return airportRepository.findAll();
	}
	
	public Iterable<Flight> getAllFlights(){
		return flightRepository.findAll();
	}
	
	public Airport addAirport(Airport airport){
		 airport = airportRepository.save(airport);
		return airport;
	}
	
	public Flight addFlight(Flight flight){
		 flight = flightRepository.save(flight);
		return flight;
	}
	
	public Iterable<Passenger> getAllPassengers(){
		return passengerRepository.findAll();
	}
	
	public Iterable<Plane> getAllPlanes(){
		return planeRepository.findAll();
	}

	public Iterable<Traject> getAllTrajects() {
		return this.trajectRepository.findAll();
	}

	public Optional<Airport> findAirportById(long id) {
		return this.airportRepository.findById(id);
	}

}
