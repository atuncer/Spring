package com.atahantuncer.CS393HW1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_table")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name",length = 80)
    private String name;
    @Column(name = "price")
    private double price;


    @ManyToMany(mappedBy = "products",cascade = CascadeType.ALL)
    private List<Order> orders=new ArrayList<>();

    @ManyToOne
    private Shop shop;


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public Shop getShop() {return shop;}

    public void setShop(Shop shop) {this.shop = shop;}

    public List<Order> getOrders() {return orders;}

    public void setOrders(List<Order> orders) {this.orders = orders;}
}
