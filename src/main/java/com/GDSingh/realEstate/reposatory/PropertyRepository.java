package com.GDSingh.realEstate.reposatory;

import com.GDSingh.realEstate.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT p FROM Property p " +
            "LEFT JOIN FETCH p.category c " + // Assuming Category is a direct relationship
            "LEFT JOIN FETCH p.agency a " +   // Assuming Agency is a direct relationship
            "WHERE p.id = :id")
    Optional<Property> findByIdWithRelation(@Param("id") Long id);


    List<Property> findByIdAndPurpose(Long id, String purpose, Pageable pageable);
}
