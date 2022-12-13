package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.EOrderStatus;
import com.dnoviy.controlSystem.entity.Good;
import com.dnoviy.controlSystem.entity.Order;
import com.dnoviy.controlSystem.entity.User;
import com.dnoviy.controlSystem.repository.GoodRepository;
import com.dnoviy.controlSystem.repository.OrderRepository;
import com.dnoviy.controlSystem.repository.UserRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final UserRepository userRepository;
    private final GoodRepository goodRepository;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(UserRepository userRepository, GoodRepository goodRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.goodRepository = goodRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> getAllUserOrders() {
        CurrentUserInfoService currentUserInfoService = new CurrentUserInfoService();
        User user = userRepository.findByUsername(currentUserInfoService.getCurrentUsername()).get();
        if (user.getOrders() != null) {
            return user.getOrders();
        }
        return null;
    }

    @Override
    public List<Order> getAllCompanyOrders() {
        CurrentUserInfoService currentUserInfoService = new CurrentUserInfoService();
        User user = userRepository.findByUsername(currentUserInfoService.getCurrentUsername()).get();
        if (user.getCompany() != null){
            if (user.getCompany().getOrders() != null){
                return user.getCompany().getOrders();
            }
        }
        return null;
    }

    @Override
    public Order updateOrder(Long orderId) {
        return null;
    }

    @Override
    public Order addOrder(Long goodId, Integer count) {
        CurrentUserInfoService currentUserInfoService = new CurrentUserInfoService();
        Good companyGood = goodRepository.findById(goodId).get();
        companyGood.setStock(count);
        Order order = new Order();
        order.setCreationTime(LocalDateTime.now());
        order.setOrderStatus(EOrderStatus.STATUS_WAITING);
        order.setCompany(companyGood.getCompany());
        order.setUser(userRepository.findByUsername(currentUserInfoService.getCurrentUsername()).get());
        order.setGoodId(goodId);
        order.setStock(companyGood.getStock());
        return orderRepository.save(order);
    }
}
