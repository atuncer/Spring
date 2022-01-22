package com.atahantuncer.CS393HW1.model;

import javax.persistence.*;

@Entity
@Table(name = "address_table")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "text",length = 50)
    private String text;

    @Column(name = "city",length = 30)
    private String city;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getText() {return text;}

    public void setText(String text) {this.text = text;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}
}
