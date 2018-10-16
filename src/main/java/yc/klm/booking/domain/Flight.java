package yc.klm.booking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int duration;
	
	@ManyToOne
	private Airport origin;
	
	@ManyToOne
	private Airport destination;

}
