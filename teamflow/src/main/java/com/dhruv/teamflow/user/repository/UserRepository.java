package com.dhruv.teamflow.user.repository;

import com.dhruv.teamflow.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByOrganizationId(Long organizationId);

    boolean existsByEmail(String email);
}
