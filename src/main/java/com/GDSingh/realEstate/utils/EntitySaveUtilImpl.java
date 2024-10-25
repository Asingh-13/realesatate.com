package com.GDSingh.realEstate.utils;

import com.GDSingh.realEstate.entity.CoverPhoto;
import com.GDSingh.realEstate.entity.Image;
import com.GDSingh.realEstate.entity.Location;
import com.GDSingh.realEstate.reposatory.CoverPhotoRepository;
import com.GDSingh.realEstate.reposatory.ImageRepository;
import com.GDSingh.realEstate.reposatory.LocationRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EntitySaveUtilImpl implements EntitySaveUtil{
    private ImageRepository imageRepository;
    private LocationRepository locationRepository;
    private CoverPhotoRepository coverPhotoRepository;

    @Autowired
    public EntitySaveUtilImpl(ImageRepository imageRepository, LocationRepository locationRepository,
                              CoverPhotoRepository coverPhotoRepository) {
        this.imageRepository = imageRepository;
        this.locationRepository = locationRepository;
        this.coverPhotoRepository = coverPhotoRepository;
    }

    @Override
    public void saveEntity(Object entity) {
        if (entity instanceof Image) {
            imageRepository.save((Image) entity);
        } else if (entity instanceof Location) {
            locationRepository.save((Location) entity);
        } else if (entity instanceof CoverPhoto) {
            coverPhotoRepository.save((CoverPhoto) entity);
        } else {
            throw new IllegalArgumentException("Unsupported entity type");
        }
    }
}

