package com.ufes.miniproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // that's telling mysql to make a table out of the class
public class Product {
    @Id //id is the primary key
            @GeneratedValue(strategy = GenerationType.IDENTITY) // that means that de value of the id is auto incremented in sequence
    int id;
    private String name;
    private double price;
    private int amountInStorage;
    private int amountSold;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountInStorage() {
        return amountInStorage;
    }

    public void setAmountInStorage(int amountInStorage) {
        this.amountInStorage = amountInStorage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
