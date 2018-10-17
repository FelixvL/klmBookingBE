package yc.klm.booking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yc.klm.booking.domain.Airport;
import yc.klm.booking.domain.Flight;
import yc.klm.booking.domain.Passenger;
import yc.klm.booking.domain.Plane;
import yc.klm.booking.repositories.AirportRepository;
import yc.klm.booking.repositories.FlightRepository;
import yc.klm.booking.repositories.PassengerRepository;
import yc.klm.booking.repositories.PlaneRepository;

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
}
