package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.entity.CoverPhoto;
import com.GDSingh.realEstate.reposatory.CoverPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverPhotoServiceImpl implements CoverPhotoService{

    private CoverPhotoRepository coverPhotoRepository;

    @Autowired
    public CoverPhotoServiceImpl(CoverPhotoRepository coverPhotoRepository) {
        this.coverPhotoRepository = coverPhotoRepository;
    }

    @Override
    public CoverPhoto saveCoverPhoto(CoverPhoto coverPhoto) {
        return coverPhotoRepository.save(coverPhoto);
    }

    @Override
    public CoverPhoto updateCoverPhoto(CoverPhoto coverPhoto) {
        return coverPhotoRepository.save(coverPhoto);
    }

    @Override
    public CoverPhoto findByPropertyId(Long id) {
        return coverPhotoRepository.findByPropertyId(id);
    }
}
