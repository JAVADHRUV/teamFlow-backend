package com.dhruv.teamflow.organization.service;

import com.dhruv.teamflow.organization.entity.Organization;
import com.dhruv.teamflow.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Transactional
    public Organization createOrganization(String name) {

        if (organizationRepository.existsByName(name)) {
            throw new IllegalArgumentException("Organization with this name already exists");
        }

        Organization organization = new Organization();
        organization.setName(name);

        return organizationRepository.save(organization);
    }
}
