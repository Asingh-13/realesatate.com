package com.GDSingh.realEstate.dto;

import lombok.Data;

@Data
public class CoverPhotoDTO {
    private String title;
    private String url;
    private int orderIndex;
    private double nimaScore;
    private boolean main;
    private int photoCount;
    private int videoCount;
    private int panoramaCount;
}
