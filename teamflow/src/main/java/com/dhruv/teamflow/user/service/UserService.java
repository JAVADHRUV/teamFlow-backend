package com.dhruv.teamflow.user.service;

import com.dhruv.teamflow.organization.entity.Organization;
import com.dhruv.teamflow.user.entity.Role;
import com.dhruv.teamflow.user.entity.User;
import com.dhruv.teamflow.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            OrganizationRepository organizationRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User createUser(
            String name,
            String email,
            String passwordHash,
            Role role,
            Organization organization
    ) {

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already in use");
        }

        var organization = organizationRepository
                .findById(request.getOrganizationId())
                .orElseThrow(() -> new IllegalStateException("Organization not found"));

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .organization(organization)
                .isActive(true)
                .build();

        return userRepository.save(user);
    }
}
