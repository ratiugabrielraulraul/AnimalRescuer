package org.fasttrackit;

import javax.security.auth.login.AccountNotFoundException;

public class Adopter {

    private String name;
    private double money;
    private boolean feedingAnimal;

    /**
     * Constructor;
     */
    public Adopter ()
    {
        this.setMoney(35);
    }

    /**
     * Prints out some attributes from the parameters passed, creating a sentence.
     * @param animal
     * @param food
     */
    public void feed(Animal animal, Food food)
    {
        if (food.getName().equals(animal.getFavoriteFood())) {
            animal.setMood(animal.getMood() + 1);
        }
        animal.setHunger(animal.getHunger() - 1);
        System.out.println(this.name + " gave some " + food.getName() + " food to " + animal.getName());
        System.out.println("Animal hunger level: " + animal.getHunger() + " and happiness level is " + animal.getMood());
    }

    /**
     * Prints out some attributes from the parameters passed, creating a sentence.
     * @param activity
     * @param animal
     */
    public void play(RecreationActivity activity, Animal animal) {

        if (activity.getName().equals(animal.getFavoriteActivity())) {
            animal.setMood(animal.getMood() + 2);
        } else {
            animal.setMood(animal.getMood() + 1);
        }
        System.out.println(this.name + " is " + activity.getName() + " with " + animal.getName() + " in " + activity.getPlace());
        System.out.println("Animal happiness level: " + animal.getMood());
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







