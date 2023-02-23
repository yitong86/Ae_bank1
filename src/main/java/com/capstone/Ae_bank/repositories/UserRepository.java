package com.capstone.Ae_bank.repositories;

import com.capstone.Ae_bank.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);



    // Boolean existsByUsername(String username);
}
