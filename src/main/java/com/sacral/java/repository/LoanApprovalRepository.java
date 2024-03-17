
package com.sacral.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sacral.java.model.Applicant;

@Repository
public interface LoanApprovalRepository extends JpaRepository<Applicant, Long> {
    
    @Query("SELECT CASE WHEN (a.identityVerified = true AND a.addressVerified = true) THEN true ELSE false END FROM Applicant a WHERE a.id = :applicantId")
    boolean isDocumentVerificationComplete(Long applicantId);
    
    @Query("SELECT CASE WHEN (a.identityVerified = true AND a.addressVerified = true) THEN 'Document verification complete. Eligible for banking services.' ELSE 'Document verification incomplete. Not eligible for banking services.' END FROM Applicant a WHERE a.id = :applicantId")
    String verifyDocument(Long applicantId);
    
    @Query("SELECT CASE WHEN (a.annualIncome >= 30000 AND a.creditScore >= 700) THEN 'Congratulations! You are eligible for a credit score with a high limit.' WHEN (a.annualIncome >= 20000 AND a.creditScore >= 600) THEN 'You are eligible for a credit score with a moderate limit.' ELSE 'You are not eligible for a credit score.' END FROM Applicant a WHERE a.id = :applicantId")
    String evaluateCredit(Long applicantId);
}
