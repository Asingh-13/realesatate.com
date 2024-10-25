package com.GDSingh.realEstate.dto;

import com.GDSingh.realEstate.service.ImageService;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class PropertyDTO {

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
    private AgencyDTO agencyDTO;
    private CategoryDTO categoryDTO;
    private double latitude;
    private double longitude;
    private String locationName;
    private ContactDetailsDTO phoneNumber;
    private List<String> keywords;
    private boolean verified;

    private LocationDTO locationDTO;
    private CoverPhotoDTO coverPhotoDTO;
    private List<ImageDTO> imageDTOS;
}
