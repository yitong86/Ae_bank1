package org.yitongJiang.Ae_bank.repositories;

import org.yitongJiang.Ae_bank.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// user repo work with database
public interface UserRepository extends JpaRepository<User, Long> {
   // Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    //Boolean existsByEmail(String email);


}
