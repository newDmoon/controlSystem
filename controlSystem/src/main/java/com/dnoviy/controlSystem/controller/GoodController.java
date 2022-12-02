package com.dnoviy.controlSystem.controller;

import com.dnoviy.controlSystem.entity.Good;
import com.dnoviy.controlSystem.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/good")
@CrossOrigin
public class GoodController {

    @Autowired
    private GoodService goodService;

    @PostMapping("/add")
    public String add(@RequestBody Good good) {
        goodService.saveGood(good);
        return "New good is added";
    }

    @GetMapping("/getAll")
    public List<Good> getAll() {
        return goodService.getAllGoods();
    }

    // TODO make crud operations
    @DeleteMapping("delete/{id}")
    public Good getOneGood(@PathVariable Long id){
        return goodService.getOneGood(id);
    }
}
