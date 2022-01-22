package com.atahantuncer.CS393HW1.repository;

import com.atahantuncer.CS393HW1.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
