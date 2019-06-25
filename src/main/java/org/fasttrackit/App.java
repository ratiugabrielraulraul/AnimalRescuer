package org.fasttrackit;


import java.time.LocalDate;

public class App
{

    public static void main(String[] args ) {

        Animal animal = new Animal("Bella");
        animal.name = "Adi";
        animal.age = 3;
        animal.hunger = 5;
        animal.favoriteFood = "pedigree";
        animal.favoriteActivity = "running";
        animal.healthStatus = 6;
        animal.mood = 5;




        Adopter adopter = new Adopter("adi", 233.54);
        adopter.feedingAnimal=true;
        System.out.println(adopter.name);
        System.out.println(adopter.money);


        Vet vet = new Vet("Alex");
        vet.price = 10;
        vet.specialization = "doctor";
        System.out.println(vet.name);

        Food food = new Food("pedigree");
        food.name = "pedigree";
        //food.expirationDate = new LocalDate(2020,7,23);
        food.price = 5.67;
        food.stock = true;
        food.capacity = 844.123;

        Dog dog = new Dog("white");
        System.out.println(dog.furColor);


        Parrot parrot = new Parrot(true);
        System.out.println(parrot.availableToTalk);



        RecreationActivityName recreationActivityName = new RecreationActivityName("Running");
        RecreationActivityPlace recreationActivityPlace = new RecreationActivityPlace("Park");
        RecreationActivity activity = new RecreationActivity(recreationActivityName, recreationActivityPlace);
        System.out.println(activity.name.name);
        System.out.println(activity.place.name);













    }
}
