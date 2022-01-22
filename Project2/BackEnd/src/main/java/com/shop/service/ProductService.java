package com.shop.service;

import java.util.List;

import com.shop.model.Product;
import com.shop.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.ProductDTO;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getProducts(){
        return productRepository.getProducts();
    }

    public Product findById(int id){
        return productRepository.findById(id).get();
    }
}