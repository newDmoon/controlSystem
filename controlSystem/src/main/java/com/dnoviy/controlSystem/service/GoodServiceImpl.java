package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Good;
import com.dnoviy.controlSystem.repository.GoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService{
    private final GoodRepository goodRepository;

    public GoodServiceImpl(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

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
        return goodRepository.findById(id).get();
    }

    @Override
    public String deleteOneGood(Long id) {
        goodRepository.delete(goodRepository.findById(id).get());
        return "Успешно удалено";
    }
}
