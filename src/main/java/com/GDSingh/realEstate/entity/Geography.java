package com.GDSingh.realEstate.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Embeddable
@Getter
@Setter
public class Geography {

    private double latitude;
    private double longitude;
    private String locationName;
}



