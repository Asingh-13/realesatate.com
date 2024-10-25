package com.GDSingh.realEstate.reposatory;

import com.GDSingh.realEstate.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
    Agency findByName(String name);
}
