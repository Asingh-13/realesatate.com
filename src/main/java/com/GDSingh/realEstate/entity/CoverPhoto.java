package com.GDSingh.realEstate.entity;
import com.GDSingh.realEstate.relation.PropertyRelation;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Embeddable
@Entity
public class CoverPhoto implements PropertyRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    private int orderIndex;
    private double nimaScore;
    private boolean main;
    private int photoCount;
    private int videoCount;
    private int panoramaCount;


    @OneToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;
}
