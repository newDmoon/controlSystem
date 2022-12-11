package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getOneCompany(Long id);
    Company updateCompany(Company company);
}
