package com.GDSingh.realEstate.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Property> properties;

    @Column(name = "name_l1")
    private String nameL1;

    @Column(name = "product")
    private String product;

    @Column(name = "product_score")
    private Integer productScore;
}
