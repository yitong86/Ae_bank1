package com.capstone.Ae_bank.repositories;


import com.capstone.Ae_bank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository                               //CrudRepository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select * from customer where id = :id", nativeQuery = true)
    Optional<Customer>  findById(@Param("id") Long id);
  //  Optional<Customer> findByEmail(String email);
}