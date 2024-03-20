
package com.sacral.java.repository;

import com.sacral.java.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    @Query("SELECT la FROM LoanApplication la WHERE la.userId = :userId")
    List<LoanApplication> findByUserId(Long userId);

    @Query("SELECT la FROM LoanApplication la WHERE la.status = :status")
    List<LoanApplication> findByStatus(String status);

    @Query("SELECT la FROM LoanApplication la WHERE la.creditScore >= :minCreditScore")
    List<LoanApplication> findByMinCreditScore(int minCreditScore);

    @Query("SELECT la FROM LoanApplication la WHERE la.income >= :minIncome")
    List<LoanApplication> findByMinIncome(double minIncome);

    @Query("SELECT la FROM LoanApplication la WHERE la.employmentDetails = :employmentDetails")
    List<LoanApplication> findByEmploymentDetails(String employmentDetails);

}
