package com.sacral.java.controller;

import com.sacral.java.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/verifyDocuments")
    @ResponseBody
    public String verifyDocuments(@RequestParam boolean identityVerified, @RequestParam boolean addressVerified) {
        boolean result = applicantService.verifyDocuments(identityVerified, addressVerified);
        return result ? "Document verification successful. You are eligible for banking services." : "Document verification incomplete. You are not eligible for banking services.";
    }

    @PostMapping("/evaluateCredit")
    @ResponseBody
    public String evaluateCredit(@RequestBody Applicant applicant) {
        applicantService.evaluateCredit(applicant);
        return "Credit evaluation completed.";
    }
}