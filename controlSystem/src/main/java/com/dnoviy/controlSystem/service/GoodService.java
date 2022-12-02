package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Good;

import java.util.List;

public interface GoodService {
    public Good saveGood(Good good);
    public List<Good> getAllGoods();
    public Good getOneGood(Long id);
}
