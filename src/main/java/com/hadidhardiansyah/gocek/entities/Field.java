package com.hadidhardiansyah.gocek.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "field")
@Getter
@Setter
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private Integer fieldId;

    @Column(name = "field_name", nullable = false, length = 50)
    private String fieldName;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<Booking> bookingList;

}
