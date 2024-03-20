package com.sacral.java.service;

import com.sacral.java.model.LoanApplication;
import com.sacral.java.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    public List<LoanApplication> findByUserId(Long userId) {
        return loanApplicationRepository.findByUserId(userId);
    }

    public List<LoanApplication> findByStatus(String status) {
        return loanApplicationRepository.findByStatus(status);
    }

    public List<LoanApplication> findByMinCreditScore(int minCreditScore) {
        return loanApplicationRepository.findByMinCreditScore(minCreditScore);
    }

    public List<LoanApplication> findByMinIncome(double minIncome) {
        return loanApplicationRepository.findByMinIncome(minIncome);
    }

    public List<LoanApplication> findByEmploymentDetails(String employmentDetails) {
        return loanApplicationRepository.findByEmploymentDetails(employmentDetails);
    }

    // Add any additional business methods here

}