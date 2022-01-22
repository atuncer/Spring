package com.shop.controller;

import java.util.List;

import com.shop.model.Order;
import com.shop.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.model.Shop;
import com.shop.service.ShopService;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public void addOrder(@RequestParam(value="type", required=false) List<Integer> products, @RequestParam(value="amount") double amount) {
        service.save(products,amount);
    }

}
