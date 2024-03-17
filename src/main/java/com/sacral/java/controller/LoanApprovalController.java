package com.sacral.java.controller;

import com.sacral.java.service.LoanApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan-approval")
public class LoanApprovalController {

    private LoanApprovalService loanApprovalService;

    @Autowired
    public LoanApprovalController(LoanApprovalService loanApprovalService) {
        this.loanApprovalService = loanApprovalService;
    }

    @PostMapping("/document-verification")
    public String verifyDocument(@RequestParam Long applicantId,
                                 @RequestParam boolean identityVerified,
                                 @RequestParam boolean addressVerified) {
        boolean documentVerified = loanApprovalService.verifyDocument(applicantId, identityVerified, addressVerified);

        if (documentVerified) {
            return "Congratulations! You are eligible for banking services.";
        } else {
            return "Document verification is incomplete. You are not eligible for banking services.";
        }
    }

    @GetMapping("/credit-evaluation/{applicantId}")
    public String evaluateCredit(@PathVariable Long applicantId) {
        return loanApprovalService.evaluateCredit(applicantId);
    }
}