package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.entity.Location;
import com.GDSingh.realEstate.reposatory.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{

    private  LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location findByPropertyId(Long id) {
        return locationRepository.findByPropertyId(id);
    }
}
