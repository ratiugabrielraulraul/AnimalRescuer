package org.fasttrackit;


import java.time.LocalDateTime;
import java.util.Date;

public class App
{

    public static void main(String[] args ) {

        Animal animal = new Animal();
        animal.name = "Bella";
        animal.age = 3;
        animal.hunger = 5;
        animal.favoriteFood = "pedigree";
        animal.favoriteActivity = "running";
        animal.healthStatus = 6;
        animal.mood = 5;



        Adopter adopter = new Adopter();
        adopter.name = "Cristian";
        adopter.money = 20.33;


        Vet vet = new Vet();
        vet.name = "Alex";
        vet.price = 10;
        vet.specialization = "doctor";

        Food food = new Food();
        food.name = "pedigree";
        food.expirationDate = LocalDateTime.now();
        food.price = 5.67;
        food.stock = true;
        food.capacity = 844.123;




        RecreationActivity activity = new RecreationActivity();
        activity.name = "running";














    }
}
