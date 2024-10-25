package com.GDSingh.realEstate.reposatory;

import com.GDSingh.realEstate.entity.CoverPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverPhotoRepository extends JpaRepository<CoverPhoto, Long> {
    CoverPhoto findByPropertyId(Long propertyId);
}
