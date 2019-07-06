package org.fasttrackit;


import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        Animal animal = new Animal("Bella");
        animal.setAge(3);
        animal.setHunger(5);
        animal.setFavoriteFood("pedigree");
        animal.setFavoriteActivity("running");
        animal.setHealthStatus(6);
        animal.setMood(5);

        Adopter adopter = new Adopter("Adi", 233.54);
        adopter.setFeedingAnimal(true);

        Vet vet = new Vet("Alex");
        vet.setPrice(10);
        vet.setSpecialization("doctor");

        Food food = new Food("pedigree");
        //food.expirationDate = new LocalDate(2020,7,23);
        food.setPrice(5.73);
        food.setStock(true);
        food.setCapacity(844.123);

        Dog dog = new Dog("white");

        Parrot parrot = new Parrot("Richie", true);
        parrot.setHunger(10);


        RecreationActivity activity = new RecreationActivity("running", "Hill");
        adopter.feed(animal, food);
        adopter.play(activity, animal);

        animal.setSpiritMood("is running");

        animal.expressHappiness();
        parrot.expressHappiness();
        dog.expressHappiness();


    }
}
