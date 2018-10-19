package yc.klm.booking.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Traject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Airport departureAirport;

    @OneToOne
    private Airport arrivalAirport;

    private LocalDate inactiveStartdate;

    private LocalDate inactiveEnddate;

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDate getInactiveStartdate() {
        return inactiveStartdate;
    }

    public void setInactiveStartdate(LocalDate inactiveStartdate) {
        this.inactiveStartdate = inactiveStartdate;
    }

    public LocalDate getInactiveEnddate() {
        return inactiveEnddate;
    }

    public void setInactiveEnddate(LocalDate inactiveEnddate) {
        this.inactiveEnddate = inactiveEnddate;
    }

}
