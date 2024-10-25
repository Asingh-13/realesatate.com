package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.entity.Image;
import com.GDSingh.realEstate.reposatory.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    private ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> findByPropertyId(Long id) {
        return imageRepository.findByPropertyId(id);
    }
}
