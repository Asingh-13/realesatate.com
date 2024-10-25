package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.entity.Property;
import com.GDSingh.realEstate.relation.PropertyRelation;
import com.GDSingh.realEstate.utils.EntitySaveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyRelationServiceImpl implements PropertyRelationService {

    private final EntitySaveUtil entitySaveUtil;

    @Autowired
    public PropertyRelationServiceImpl(EntitySaveUtil entitySaveUtil) {
        this.entitySaveUtil = entitySaveUtil;
    }

    @Override
    public <E extends PropertyRelation> void saveRelation(E entity, Property property) {
        entity.setProperty(property);
        entitySaveUtil.saveEntity(entity);
    }
}



