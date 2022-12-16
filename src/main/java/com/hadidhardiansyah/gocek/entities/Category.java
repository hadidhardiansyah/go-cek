package com.hadidhardiansyah.gocek.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_field", nullable = false)
    private String categoryField;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "price", nullable = false)
    private Integer price;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Field> fieldList;


}
