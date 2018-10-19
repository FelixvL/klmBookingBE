package yc.klm.booking.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name="bestelling")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String seatNumber;
    private String seatType;
    private BigDecimal luggage;
    private BigDecimal openAmount;
    private BigDecimal paidAmount;

    @ManyToOne
    @JsonIgnoreProperties("orders")
    private Account account;


    @ManyToOne
    private Trip trip;

    public Account getAccount() {
        return this.account;
    }

    public Trip getTrip() {
        return this.trip;
    }

    public long getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public BigDecimal getLuggage() {
        return luggage;
    }

    public void setLuggage(BigDecimal luggage) {
        this.luggage = luggage;
    }

    public BigDecimal getOpenAmount() {
        return openAmount;
    }

    public void setOpenAmount(BigDecimal openAmount) {
        this.openAmount = openAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
