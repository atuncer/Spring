package com.shop.service;

import com.shop.model.Order;
import com.shop.model.Product;
import com.shop.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;
    public Order save(List<Integer> products, double amount) {
        Order order=new Order();
        order.setAmount(amount);
        order.setDate(new Date());
        //
        for(int i=0;i<products.size();i++) {
            order.getProducts().add(productService.findById(products.get(i)));
        }
        return orderRepository.save(order);
    }

}