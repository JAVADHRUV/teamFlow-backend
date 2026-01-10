package com.dhruv.teamflow.user.service;

import com.dhruv.teamflow.organization.entity.Organization;
import com.dhruv.teamflow.user.entity.Role;
import com.dhruv.teamflow.user.entity.User;
import com.dhruv.teamflow.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPasswordHash(passwordHash);
        user.setRole(role);
        user.setOrganization(organization);

        return userRepository.save(user);
    }
}
