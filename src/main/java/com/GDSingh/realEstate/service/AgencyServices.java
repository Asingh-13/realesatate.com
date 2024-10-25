package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.dto.AgencyDTO;
import com.GDSingh.realEstate.entity.Agency;

import java.util.List;
import java.util.Optional;

public interface AgencyServices {
    // Save or update an Agency
    Agency saveAgency(Agency agency);

    // Fetch all agencies
    List<Agency> getAllAgencies();

    // Fetch an agency by ID
    Agency getAgencyById(Long id);

    // Delete an agency by ID
    void deleteAgencyById(Long id);

    Agency getOrCreateAgency(AgencyDTO agencyDTO);

}
