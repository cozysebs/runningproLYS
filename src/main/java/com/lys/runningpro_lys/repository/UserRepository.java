package com.lys.runningpro_lys.repository;

import com.lys.runningpro_lys.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Users findByEmail(String email);
}
