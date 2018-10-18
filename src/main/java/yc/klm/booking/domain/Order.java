package yc.klm.booking.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Account account;


    private Trip trip;


}
