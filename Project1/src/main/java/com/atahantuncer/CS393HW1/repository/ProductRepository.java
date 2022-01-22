package com.atahantuncer.CS393HW1.repository;

import com.atahantuncer.CS393HW1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
