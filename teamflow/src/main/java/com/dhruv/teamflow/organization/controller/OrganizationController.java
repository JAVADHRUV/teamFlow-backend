package com.dhruv.teamflow.organization.controller;

import com.dhruv.teamflow.organization.dto.CreateOrganizationRequest;
import com.dhruv.teamflow.organization.dto.OrganizationResponse;
import com.dhruv.teamflow.organization.entity.Organization;
import com.dhruv.teamflow.organization.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public ResponseEntity<OrganizationResponse> createOrganization(
            @Valid @RequestBody CreateOrganizationRequest request
    ) {
        Organization organization =
                organizationService.createOrganization(request.getName());

        OrganizationResponse response =
                new OrganizationResponse(organization.getId(), organization.getName());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
