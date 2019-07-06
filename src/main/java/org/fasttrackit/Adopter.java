package org.fasttrackit;

public class Adopter {

    String name;
    double money;
    boolean feedingAnimal;

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
        System.out.println(this.name + " gave some " + food.name + " food to " + animal.name);
    }

    /**
     * Prints out some attributes from the parameters passed, creating a sentence.
     * @param activity
     * @param animal
     */
    public void play(RecreationActivity activity, Animal animal) {

        System.out.println(this.name + " is " + activity.name + " with " + animal.name + " in " + activity.place);
    }
}







