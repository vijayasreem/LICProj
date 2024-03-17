package com.sacral.java.controller;

import com.sacral.java.model.Applicant;
import com.sacral.java.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/highLimit")
    public Applicant findEligibleApplicantWithHighLimit() {
        return applicantService.findEligibleApplicantWithHighLimit();
    }

    @GetMapping("/moderateLimit")
    public Applicant findEligibleApplicantWithModerateLimit() {
        return applicantService.findEligibleApplicantWithModerateLimit();
    }

    // Other business methods can be added here for creditworthiness evaluation

}