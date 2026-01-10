package com.dhruv.teamflow.organization.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateOrganizationRequest {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
