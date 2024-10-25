package com.GDSingh.realEstate.controller;

import com.GDSingh.realEstate.dto.PropertyDTO;
import com.GDSingh.realEstate.entity.Property;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface PropertyController {

    List<Property>getAllUser();

    ResponseEntity<PropertyDTO> getUserById(String id);

    List<PropertyDTO> getProperties(String externalId, String purpose, int hitsPerPage);

    public ResponseEntity<PropertyDTO> addProperty(@RequestBody PropertyDTO propertyDTO) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;
}
