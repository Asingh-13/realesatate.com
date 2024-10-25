package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.entity.Image;

import java.util.List;

public interface ImageService {
        Image saveImage(Image image);
        List<Image> findByPropertyId(Long id);
}
