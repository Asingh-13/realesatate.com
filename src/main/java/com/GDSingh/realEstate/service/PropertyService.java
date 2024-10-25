package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.dto.PropertyDTO;
import com.GDSingh.realEstate.entity.Property;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public interface PropertyService {

    List<Property> getAllProperties();

    Optional<Property> getPropertyById(Long id);

    PropertyDTO getPropertyByIdWithRelations(Long id);

    List<PropertyDTO> getProperties(Long locationIds, String purpose, int hitsPerPage);

    PropertyDTO addPropertyWithRelations(PropertyDTO propertyDTO) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;
}
