package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Good;
import com.dnoviy.controlSystem.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService{
    @Autowired
    private GoodRepository goodRepository;

    @Override
    public Good saveGood(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }

    @Override
    public Good getOneGood(Long id) {
        return goodRepository.getGoodById(id);
    }
}
