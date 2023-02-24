package com.capstone.Ae_bank.repositories;

import com.capstone.Ae_bank.auth.ERole;
import com.capstone.Ae_bank.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole roleName);
}
