package com.shop.controller;

import java.util.List;

import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.dto.ProductDTO;

import com.shop.model.Shop;
import com.shop.service.ShopService;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }

}
