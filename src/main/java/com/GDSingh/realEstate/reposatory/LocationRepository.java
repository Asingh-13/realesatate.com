package com.GDSingh.realEstate.reposatory;


import com.GDSingh.realEstate.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByPropertyId(Long id);
}
