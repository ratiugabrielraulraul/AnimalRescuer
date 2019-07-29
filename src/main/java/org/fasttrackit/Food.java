package org.fasttrackit;


import java.time.LocalDate;

public class Food {

    private String name;
    private double price;
    private int quantity;
    private LocalDate expirationDate;
    private boolean stock;


    public Food() {
    }

    public boolean expirationDayCheck(LocalDate expirationDate, LocalDate now) {

        if (now.isBefore(expirationDate)) {
            System.out.println("this food hasn't expired yet");
            return true;
        }else {
            System.out.println("this food has expired");
            return false;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }
}
