package com.dnoviy.controlSystem.controller;

import com.dnoviy.controlSystem.entity.Order;
import com.dnoviy.controlSystem.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping("/makeOrder/{goodId}")
    public ResponseEntity<?> addOrder(@PathVariable Long goodId,
                                      @RequestBody Integer count){
        System.out.println(count);
        return new ResponseEntity<>(orderService.addOrder(goodId, count),
                 HttpStatus.OK);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("company/getAll")
    public ResponseEntity<?> getAllCompanyOrders(){
        return new ResponseEntity<>(orderService.getAllCompanyOrders(),
                HttpStatus.OK);
    }

    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("user/getAll")
    public ResponseEntity<?> getAllUserOrders(){
        return new ResponseEntity<>(orderService.getAllUserOrders(),
                HttpStatus.OK);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PutMapping("/changeState/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id){
        return new ResponseEntity<>(orderService.updateOrder(id),
                HttpStatus.OK);
    }

}
