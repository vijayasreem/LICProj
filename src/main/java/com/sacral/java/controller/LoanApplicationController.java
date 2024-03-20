package com.sacral.java.controller;

import com.sacral.java.model.LoanApplication;
import com.sacral.java.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loanApplications")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    @Autowired
    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @GetMapping("/findByUserId/{userId}")
    public List<LoanApplication> findByUserId(@PathVariable Long userId) {
        return loanApplicationService.findByUserId(userId);
    }

    @GetMapping("/findByStatus/{status}")
    public List<LoanApplication> findByStatus(@PathVariable String status) {
        return loanApplicationService.findByStatus(status);
    }

    @GetMapping("/findByMinCreditScore/{minCreditScore}")
    public List<LoanApplication> findByMinCreditScore(@PathVariable int minCreditScore) {
        return loanApplicationService.findByMinCreditScore(minCreditScore);
    }

    @GetMapping("/findByMinIncome/{minIncome}")
    public List<LoanApplication> findByMinIncome(@PathVariable double minIncome) {
        return loanApplicationService.findByMinIncome(minIncome);
    }

    @GetMapping("/findByEmploymentDetails/{employmentDetails}")
    public List<LoanApplication> findByEmploymentDetails(@PathVariable String employmentDetails) {
        return loanApplicationService.findByEmploymentDetails(employmentDetails);
    }

    // Add any additional business methods here

}