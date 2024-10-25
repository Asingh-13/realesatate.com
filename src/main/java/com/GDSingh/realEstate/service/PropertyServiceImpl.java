package com.GDSingh.realEstate.service;
import com.GDSingh.realEstate.dto.*;
import com.GDSingh.realEstate.entity.*;
import com.GDSingh.realEstate.relation.PropertyRelation;

import com.GDSingh.realEstate.reposatory.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    // Injecting Services

    private final PropertyRepository propertyRepository;
    private final ModelMapper modelMapper;
    private final PropertyRelationService propertyRelationService;
    private final ImageService imageService;
    private final AgencyServices agencyService;
    private final CategoryService categoryService;
    private final LocationService locationService;
    private final CoverPhotoService coverPhotoService;


    @Autowired
    public PropertyServiceImpl(ImageService imageService, PropertyRepository propertyRepository,
                               ModelMapper modelMapper, PropertyRelationService propertyRelationService,
                               AgencyServices agencyService, CategoryService categoryService, LocationService locationService, CoverPhotoService coverPhotoService) { // Constructor injection
        this.propertyRepository = propertyRepository;
        this.modelMapper = modelMapper;
        this.propertyRelationService = propertyRelationService;
        this.imageService = imageService;
        this.agencyService = agencyService; // Assigning AgencyService
        this.categoryService = categoryService;
        this.locationService = locationService;
        this.coverPhotoService = coverPhotoService;
    }

    private <D, E extends PropertyRelation> void saveRelatedEntity(D dto, Class<E> entityClass, Property savedProperty) {
        if (dto != null) {
            E entity = modelMapper.map(dto, entityClass);
            propertyRelationService.saveRelation(entity, savedProperty);
        }
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    @Override
    @Transactional
    public PropertyDTO getPropertyByIdWithRelations(Long id) {
        Property property = propertyRepository.findByIdWithRelation(id)
                .orElseThrow(() -> new EntityNotFoundException("Property not found"));

        PropertyDTO propertyDTO = modelMapper.map(property, PropertyDTO.class);
        var pId = property.getId();

        // Fetch and map images
        List<Image> images = imageService.findByPropertyId(pId);
        List<ImageDTO> imageDTOS = images.stream()
                .map(image -> modelMapper.map(image, ImageDTO.class))
                .collect(Collectors.toList());
        propertyDTO.setImageDTOS(imageDTOS);

        // Fetch and map related entities
        propertyDTO.setAgencyDTO(modelMapper.map(
                agencyService.getAgencyById(property.getAgency().getId()),
                AgencyDTO.class)
        );

        propertyDTO.setCategoryDTO(modelMapper.map(
                categoryService.getCategory(property.getCategory().getId()),
                CategoryDTO.class)
        );

        propertyDTO.setCoverPhotoDTO(modelMapper.map(
                coverPhotoService.findByPropertyId(pId),
                CoverPhotoDTO.class)
        );

        propertyDTO.setLocationDTO(modelMapper.map(
                locationService.findByPropertyId(pId),
                LocationDTO.class)
        );


        return propertyDTO;
    }

    public List<PropertyDTO> getProperties(Long locationIds, String purpose, int hitsPerPage) {
        Pageable pageable = PageRequest.of(0, hitsPerPage);
        List<Property> properties = propertyRepository.findByIdAndPurpose(locationIds, purpose, pageable);
        return properties.stream()
                .map(property -> modelMapper.map(property, PropertyDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    @Transactional
    public PropertyDTO addPropertyWithRelations(PropertyDTO propertyDTO) {
        try {
            if (propertyDTO.getCategoryDTO() == null) {
                throw new ServiceException("Category cannot be null");
            }

            if (propertyDTO.getAgencyDTO() == null || propertyDTO.getAgencyDTO().getName() == null) {
                throw new ServiceException("Agency name cannot be null");
            }

            // Use the AgencyService to get or create the agency
            Agency agency = agencyService.getOrCreateAgency(propertyDTO.getAgencyDTO());

            // Map Category
            Category category = modelMapper.map(propertyDTO.getCategoryDTO(), Category.class);

            // Create Property entity and set embedded fields
            Property property = modelMapper.map(propertyDTO, Property.class);
            property.setCategory(category);
            property.setAgency(agency);

            // Save the Property
            Property savedProperty = propertyRepository.save(property);

            // Save related entities using the generic method
            saveRelatedEntity(propertyDTO.getLocationDTO(), Location.class, savedProperty);
            saveRelatedEntity(propertyDTO.getCoverPhotoDTO(), CoverPhoto.class, savedProperty);
            propertyDTO.getImageDTOS().forEach(imageDTO -> saveRelatedEntity(imageDTO, Image.class, savedProperty));

            // Map the saved Property back to DTO and return
            return modelMapper.map(savedProperty, PropertyDTO.class);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Error while saving property with relations", e);
        }
    }
}