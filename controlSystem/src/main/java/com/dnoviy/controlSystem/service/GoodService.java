package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Good;

import java.util.List;
import java.util.Set;

public interface GoodService {
    Good saveGood(Good good);

    List<Good> getAllGoods();

    Good getOneGood(Long id);

    String deleteOneGood(Long id);

    Good updateOneGood(Long id, Good good);

    Set<Good> getAllCompanyGoods(Long id);

    Set<Good> getAllCompanyGoodsByManager(Long managerId);
}
