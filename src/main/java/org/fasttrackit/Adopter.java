package org.fasttrackit;

public class Adopter {

    private String name;
    private double money;
    private boolean feedingAnimal;

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
        System.out.println(this.name + " gave some " + food.getName() + " food to " + animal.getName());
    }

    /**
     * Prints out some attributes from the parameters passed, creating a sentence.
     * @param activity
     * @param animal
     */
    public void play(RecreationActivity activity, Animal animal) {

        System.out.println(this.name + " is " + activity.getName() + " with " + animal.getName() + " in " + activity.getPlace());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isFeedingAnimal() {
        return feedingAnimal;
    }

    public void setFeedingAnimal(boolean feedingAnimal) {
        this.feedingAnimal = feedingAnimal;
    }
}







