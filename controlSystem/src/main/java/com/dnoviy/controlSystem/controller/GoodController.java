package com.dnoviy.controlSystem.controller;

import com.dnoviy.controlSystem.entity.Good;
import com.dnoviy.controlSystem.service.GoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goods")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GoodController {
    private final GoodService goodService;

    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addOneGood(@RequestBody Good good) {
        return new ResponseEntity<>(goodService.saveGood(good), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGoods() {
        return new ResponseEntity<>(goodService.getAllGoods(), HttpStatus.OK);
    }

    // TODO make crud operations
    @GetMapping("good/{id}")
    public ResponseEntity<?> getOneGood(@PathVariable Long id) {
        return new ResponseEntity<>(goodService.getOneGood(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteOneGood(@PathVariable Long id) {
        return new ResponseEntity<>(goodService.deleteOneGood(id), HttpStatus.OK);
    }
}
