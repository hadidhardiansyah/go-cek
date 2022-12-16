package com.hadidhardiansyah.gocek.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "phone_number", nullable = false, length = 13)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Booking> bookingList;


}
