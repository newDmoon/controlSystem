package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Good;
import com.dnoviy.controlSystem.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllUserOrders();

    List<Order> getAllCompanyOrders();

    Order updateOrder(Long orderId);

    Order addOrder(Long goodId, Integer count);
}
