package org.fasttrackit;

public class Adopter {

    String name;
    double money;
    boolean feedingAnimal;

    Food food;
    Animal animal;
    RecreationActivity activity;

    /**
     * Constructor;
     * @param name
     * @param money
     */
    public Adopter (String name, double money)
    {
        this.name = name;
        this.money = money;
    }

    /**
     * Prints out some attributes from the parameters passed, creating a sentence.
     * @param animal
     * @param food
     */
    public void feed(Animal animal, Food food)
    {
        this.animal = animal;
        this.food = food;

        System.out.println(this.name + " gave some " + this.food.name + " food to " + this.animal.name);
    }

    /**
     * Prints out some attributes from the parameters passed, creating a sentence.
     * @param activity
     * @param animal
     */
    public void play(RecreationActivity activity, Animal animal) {
        this.activity = activity;
        this.animal = animal;

        System.out.println(this.name + " is " + this.activity.name + " with " + this.animal.name + " in " + this.activity.place);
    }
}







