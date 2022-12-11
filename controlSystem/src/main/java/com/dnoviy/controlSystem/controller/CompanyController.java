package com.dnoviy.controlSystem.controller;

import com.dnoviy.controlSystem.entity.Company;
import com.dnoviy.controlSystem.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
@CrossOrigin(origins = "*", maxAge = 3600)
@PreAuthorize("hasRole('CUSTOMER') or hasRole('PROVIDER')")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.updateCompany(company), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCompany(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.getOneCompany(id), HttpStatus.OK);
    }

}
