package org.fasttrackit;

public class Animal {

    private String name;
    private int age;
    private int healthStatus;
    private int hunger;
    private int mood;
    private String favoriteFood;
    private String favoriteActivity;
    private String spiritMood;

    public Animal(String name){
        super();
        this.name = name;
    }

    public Animal() {
    }

    public void expressHappiness()
    {
        System.out.println(this.getSpiritMood());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(int healthStatus) {
        this.healthStatus = healthStatus;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteActivity() {
        return favoriteActivity;
    }

    public void setFavoriteActivity(String favoriteActivity) {
        this.favoriteActivity = favoriteActivity;
    }

    public String getSpiritMood() {
        return spiritMood;
    }

    public void setSpiritMood(String spiritMood) {
        this.spiritMood = spiritMood;
    }
}
