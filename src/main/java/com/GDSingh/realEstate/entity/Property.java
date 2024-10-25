package com.GDSingh.realEstate.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Entity
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int hits;
    private String userExternalId;
    private int sourceId;
    private String state;
    private double price;
    private String purpose;
    private String product;
    private String productLabel;
    private int productScore;
    private String rentFrequency;
    private String referenceNumber;
    private String permitNumber;
    private String title;
    private String titleL1;
    private String slug;
    private String slugL1;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant reactivatedAt;
    private int rooms;
    private int baths;
    private double area;
    private int score;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agency_id")
    private Agency agency;

    private double latitude;
    private double longitude;
    private String locationName;

    @Embedded
    private ContactDetails phoneNumber;

    @ElementCollection
    private List<String> keywords;

    private boolean verified;
}
