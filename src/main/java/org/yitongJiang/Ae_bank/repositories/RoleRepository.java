package org.yitongJiang.Ae_bank.repositories;

import org.yitongJiang.Ae_bank.auth.ERole;
import org.yitongJiang.Ae_bank.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
//// role repo work with database
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole roleName);
}
