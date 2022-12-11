package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Company;
import com.dnoviy.controlSystem.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getOneCompany(Long id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public Company updateCompany(Company company) {
        return null;
    }
}
