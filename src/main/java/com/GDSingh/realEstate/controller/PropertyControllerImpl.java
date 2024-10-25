package com.GDSingh.realEstate.controller;

import com.GDSingh.realEstate.dto.PropertyDTO;
import com.GDSingh.realEstate.entity.Property;
import com.GDSingh.realEstate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class PropertyControllerImpl implements PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyControllerImpl(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @Override
    @GetMapping("/properties")
    public List<Property> getAllUser() {
        return propertyService.getAllProperties();
    }

    @Override
    @GetMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> getUserById(@PathVariable String id) {
        PropertyDTO propertyDTO = propertyService.getPropertyByIdWithRelations(Long.parseLong(id)); // Assuming the ID can be used as an external ID
        System.out.print(propertyDTO.toString());
        return ResponseEntity.ok(propertyDTO);
    }

    @Override
    @GetMapping("/properties/list")
    public List<PropertyDTO> getProperties(
            @RequestParam String externalId,
            @RequestParam String purpose,
            @RequestParam(defaultValue = "8") int hitsPerPage) {
        Long id = Long.parseLong(externalId);
        return propertyService.getProperties(id, purpose, hitsPerPage);
    }

    @Override
    @PostMapping("/properties/add")
    public ResponseEntity<PropertyDTO> addProperty(@RequestBody PropertyDTO propertyDTO) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        PropertyDTO savedProperty = propertyService.addPropertyWithRelations(propertyDTO);
        return ResponseEntity.ok(savedProperty);
    }
}
