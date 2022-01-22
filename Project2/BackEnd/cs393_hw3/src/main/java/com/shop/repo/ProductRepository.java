package com.shop.repo;

import java.util.List;

import com.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.dto.ProductDTO;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT NEW com.shop.dto.ProductDTO(p.id, p.name, p.price,p.url) FROM Product p")
    List<ProductDTO> getProducts();
}

