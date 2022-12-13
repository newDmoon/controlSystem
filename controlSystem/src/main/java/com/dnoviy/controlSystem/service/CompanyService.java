package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getOneCompanyByManager(Long managerId);
    Company updateCompany(Company company);
    Company getOneCompanyByCompanyId(Long companyId);
    String deleteCompany(Long id);
}
