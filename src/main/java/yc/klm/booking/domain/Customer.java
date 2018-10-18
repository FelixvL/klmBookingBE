package yc.klm.booking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    private String street;
    private String streetNumber;

    private String postalCode;
    private String city;
    private String country;

    private String email;

    private String phoneNumber;
    private String passportNumber;

    private String password; //???
    private String type;

    
}
