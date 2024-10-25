package com.GDSingh.realEstate.entity;
import jakarta.persistence.Embeddable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Embeddable
@Getter
@Setter
public class ContactDetails {
    private String mobile;
    private String phone;
    private String whatsapp;
    private String proxyMobile;
    private String email;
}


