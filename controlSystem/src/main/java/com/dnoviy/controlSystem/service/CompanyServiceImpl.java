package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Company;
import com.dnoviy.controlSystem.entity.User;
import com.dnoviy.controlSystem.repository.CompanyRepository;
import com.dnoviy.controlSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getOneCompanyByManager(Long id) {
        return userRepository.findById(id).get().getCompany();
    }

    @Override
    public Company updateCompany(Company company) {
        CurrentUserInfoService currentUserInfoService = new CurrentUserInfoService();
        User user = userRepository.findByUsername(currentUserInfoService.getCurrentUsername()).get();
        if (user.getCompany() != null) {
            company.setUser(user);
            company.setId(user.getCompany().getId());
            if (user.getCompany().getAddress() != null) {
                company.getAddress().setId(user.getCompany().getAddress().getId());
            }
            if (user.getCompany().getGoods() != null) {
                company.setGoods(user.getCompany().getGoods());
            }
        } else {
            company.setUser(user);
            user.setCompany(company);
        }
        user.setCompany(company);
        User newUser = userRepository.save(user);
        return newUser.getCompany();
    }

    @Override
    public Company getOneCompanyByCompanyId(Long companyId) {
        return companyRepository.findById(companyId).get();
    }

    @Override
    public String deleteCompany(Long id) {
        Company companyToDelete = companyRepository.findById(id).get();
        companyToDelete.getUser().setCompany(null);
        userRepository.save(companyToDelete.getUser());
        companyRepository.deleteById(id);
        System.out.println(companyRepository.findById(id));
        return "Компания успешно удалена";
    }
}
