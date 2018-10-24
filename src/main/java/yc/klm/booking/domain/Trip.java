package yc.klm.booking.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int duration;
	
	@ManyToOne
	private Airport origin;
	
	@ManyToOne
	private Airport destination;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "trip")
	private Set<Order> orders = new HashSet<>();

	public long getId() {
		return id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Airport getOrigin() {
		return origin;
	}

	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public void addOrder(Order o) {
		this.orders.add(o);
		o.setTrip(this);
	}
	
	

}
