package com.capstone.Ae_bank.repositories;


import com.capstone.Ae_bank.model.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount,Long> {

}
