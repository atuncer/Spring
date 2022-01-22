package com.atahantuncer.CS393HW1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop_table")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "address",length = 100)
    private String address;

    @OneToMany(mappedBy = "shop",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "shop",cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public List<Customer> getCustomers() {return customers;}

    public void setCustomers(List<Customer> customers) {this.customers = customers;}

    public List<Product> getProducts() {return products;}

    public void setProducts(List<Product> products) {this.products = products;}
}
