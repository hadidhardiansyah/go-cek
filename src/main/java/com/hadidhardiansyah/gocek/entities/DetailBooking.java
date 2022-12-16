package com.hadidhardiansyah.gocek.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detail_booking")
@Getter
@Setter
public class DetailBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_booking_id")
    private Integer detailBookingId;

    @Column(name = "booking_Start", nullable = false)
    private String bookingStart;

    @Column(name = "booking_end", nullable = false)
    private String bookingEnd;

    @Transient
    private String duration;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "booking_id")
    private Booking booking;

}


