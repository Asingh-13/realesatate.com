package com.GDSingh.realEstate.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int level;

    private String name;
    private String nameL1;
    private String slug;
    private String slugL1;
    private String nameSingular;
    private String nameSingularL1;

}
