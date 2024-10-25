package com.GDSingh.realEstate.entity;

import com.GDSingh.realEstate.relation.PropertyRelation;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Location implements PropertyRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int level;
    private String name;
    private String nameL1;
    private String slug;
    private String slugL1;

    @OneToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;
}
