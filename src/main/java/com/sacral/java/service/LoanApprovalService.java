package com.sacral.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacral.java.repository.LoanApprovalRepository;

@Service
public class LoanApprovalService {

    private LoanApprovalRepository loanApprovalRepository;

    @Autowired
    public LoanApprovalService(LoanApprovalRepository loanApprovalRepository) {
        this.loanApprovalRepository = loanApprovalRepository;
    }

    public boolean verifyDocument(Long applicantId, boolean identityVerified, boolean addressVerified) {
        // Open Document Verification App and display welcoming message
        // Verify identity and address based on provided input
        boolean documentVerified = identityVerified && addressVerified;

        // Update document verification status in the repository
        Applicant applicant = loanApprovalRepository.findById(applicantId).orElse(null);
        if (applicant != null) {
            applicant.setIdentityVerified(identityVerified);
            applicant.setAddressVerified(addressVerified);
            loanApprovalRepository.save(applicant);
        }

        return documentVerified;
    }

    public String evaluateCredit(Long applicantId) {
        // Retrieve applicant's annual income and credit score from the repository
        Applicant applicant = loanApprovalRepository.findById(applicantId).orElse(null);
        if (applicant != null) {
            int annualIncome = applicant.getAnnualIncome();
            int creditScore = applicant.getCreditScore();

            // Check eligibility based on annual income and credit score
            if (annualIncome >= 30000 && creditScore >= 700) {
                return "Congratulations! You are eligible for a credit score with a high limit.";
            } else if (annualIncome >= 20000 && creditScore >= 600) {
                return "You are eligible for a credit score with a moderate limit.";
            } else {
                return "You are not eligible for a credit score.";
            }
        }

        return "Applicant not found.";
    }
}