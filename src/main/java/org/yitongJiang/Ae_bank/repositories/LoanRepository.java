package org.yitongJiang.Ae_bank.repositories;



import org.yitongJiang.Ae_bank.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
// loan repo work with database
@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    @Query(value = "select * from loan where id = :id", nativeQuery = true)
    Loan getLoanById(@Param("id") Long id);



}
