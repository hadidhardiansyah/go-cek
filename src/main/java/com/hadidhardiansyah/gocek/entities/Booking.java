package com.hadidhardiansyah.gocek.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "field_id", referencedColumnName = "field_id", nullable = false)
    private Field field;

}
