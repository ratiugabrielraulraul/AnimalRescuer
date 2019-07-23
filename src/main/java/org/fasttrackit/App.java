package org.fasttrackit;


import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.setAge(3);
        animal.setHunger(5);
        animal.setFavoriteFood("pedigree");
        animal.setFavoriteActivity("running");
        animal.setHealthStatus(6);
        animal.setMood(5);
        animal.setName("Vaca");

        

        Adopter adopter = new Adopter("Adi", 233.54);
        adopter.setFeedingAnimal(true);

        Vet vet = new Vet("Alex");
        vet.setPrice(10);
        vet.setSpecialization("doctor");

        Food food = new Food();
        food.setExpirationDate(LocalDate.of((2019), (11), (3)));
        food.setPrice(5.73);
        food.setStock(true);
        food.setQuantity(35);
        food.setName("pedigree");

        Food food1 = new Food();
        food1.setExpirationDate(LocalDate.of(2019,11,3));
        food1.setPrice(3.50);
        food1.setStock(true);
        food1.setQuantity(54);
        food1.setName("seeds");

        Food food2 = new Food();
        food2.setExpirationDate(LocalDate.of(2019,10,14));
        food2.setPrice(5.50);
        food2.setStock(true);
        food2.setQuantity(100);
        food2.setName("Milk");

        food2.expirationDayCheck(food1.getExpirationDate(), food2.getExpirationDate());










        Dog dog = new Dog("white","Bella");

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
