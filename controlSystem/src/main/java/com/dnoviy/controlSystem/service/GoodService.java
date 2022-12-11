package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Good;

import java.util.List;

public interface GoodService {
    Good saveGood(Good good);

    List<Good> getAllGoods();

    Good getOneGood(Long id);

    String deleteOneGood(Long id);
}
