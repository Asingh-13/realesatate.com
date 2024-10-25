package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.entity.Location;

public interface LocationService {
    Location saveLocation(Location location);
    Location updateLocation(Location location);
    Location findByPropertyId(Long id);
}

