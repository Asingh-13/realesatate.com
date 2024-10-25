package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.entity.CoverPhoto;
import com.GDSingh.realEstate.entity.Image;

public interface CoverPhotoService {
    CoverPhoto saveCoverPhoto(CoverPhoto coverPhoto);
    CoverPhoto updateCoverPhoto(CoverPhoto coverPhoto);
    CoverPhoto findByPropertyId(Long id);
}
