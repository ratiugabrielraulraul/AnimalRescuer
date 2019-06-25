package org.fasttrackit;


import java.time.LocalDate;

public class Food {

    String name;
    double price;
    double capacity;
    LocalDate expirationDate;
    boolean stock;


    public Food(String name) {
        this.name = name;
    }
}
