package com.atahantuncer.CS393HW1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "amount")
    private double amount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rela_order_product",
            joinColumns = @JoinColumn(name = "orderid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productid", referencedColumnName = "id"))
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
