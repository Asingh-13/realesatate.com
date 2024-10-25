package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.entity.Property;
import com.GDSingh.realEstate.relation.PropertyRelation;

public interface PropertyRelationService {
    <E extends PropertyRelation> void saveRelation(E entity, Property property);
}
