package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.EGoodType;
import com.dnoviy.controlSystem.pojo.GoodForCountAnalyse;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public interface DashboardService {
    ArrayList<GoodForCountAnalyse> getPerfectGoods();
    Map<EGoodType, AtomicInteger> getImportExport();
}
