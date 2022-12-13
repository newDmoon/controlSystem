package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Company;
import com.dnoviy.controlSystem.entity.Good;
import com.dnoviy.controlSystem.entity.User;
import com.dnoviy.controlSystem.repository.CompanyRepository;
import com.dnoviy.controlSystem.repository.GoodRepository;
import com.dnoviy.controlSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GoodServiceImpl implements GoodService{
    private final GoodRepository goodRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public GoodServiceImpl(GoodRepository goodRepository, UserRepository userRepository, CompanyRepository companyRepository) {
        this.goodRepository = goodRepository;
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Good saveGood(Good good) {
        CurrentUserInfoService currentUserInfoService = new CurrentUserInfoService();
        User user = userRepository.findByUsername(currentUserInfoService.getCurrentUsername()).get();
        good.setCompany(user.getCompany());
        return goodRepository.save(good);
    }

    @Override
    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }

    @Override
    public Good getOneGood(Long id) {
        return goodRepository.findById(id).get();
    }

    @Override
    public String deleteOneGood(Long id) {
        goodRepository.delete(goodRepository.findById(id).get());
        return "Успешно удалено";
    }

    @Override
    public Good updateOneGood(Long id, Good good) {
        Good goodToUpdate = goodRepository.findById(id).get();
        goodToUpdate.setPlace(good.getPlace());
        goodToUpdate.setGoodType(good.getGoodType());
        goodToUpdate.setCode(good.getCode());
        goodToUpdate.setName(good.getName());
        goodToUpdate.setQuality(good.getQuality());
        goodToUpdate.setStock(good.getStock());
        return goodRepository.save(goodToUpdate);
    }

    @Override
    public Set<Good> getAllCompanyGoods(Long id) {
        Company company = companyRepository.findById(id).get();
        return company.getGoods();
    }

    @Override
    public Set<Good> getAllCompanyGoodsByManager(Long managerId) {;
        User user = userRepository.findById(managerId).get();
        return user.getCompany().getGoods();
    }
}
