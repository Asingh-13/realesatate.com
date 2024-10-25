package com.GDSingh.realEstate.service;

import com.GDSingh.realEstate.dto.AgencyDTO;
import com.GDSingh.realEstate.entity.Agency;
import com.GDSingh.realEstate.reposatory.AgencyRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyServices {
    private final AgencyRepository agencyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository, ModelMapper modelMapper) {
        this.agencyRepository = agencyRepository;
        this.modelMapper = modelMapper;
    }

    // Save or update an Agency
    @Override
    public Agency saveAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    // Fetch all Agencies
    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }

    // Fetch an Agency by ID
    @Override
    public Agency getAgencyById(Long id) {
        return agencyRepository.findById(id).get();
    }

    // Delete an Agency by ID
    @Override
    public void deleteAgencyById(Long id) {
        agencyRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Agency getOrCreateAgency(AgencyDTO agencyDTO) {
        // Check if the agency already exists by name
        Agency agency = agencyRepository.findByName(agencyDTO.getName());
        if (agency == null) {
            // Create a new agency if it doesn't exist
            agency = modelMapper.map(agencyDTO, Agency.class);
            agencyRepository.save(agency);
        }
        return agency;
    }

}


