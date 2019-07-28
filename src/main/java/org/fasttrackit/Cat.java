package org.fasttrackit;

public class Cat extends Animal {

    String furcolor;


    @Override
    public void expressHappiness() {
        System.out.println(this.getName() + " is purring");
    }

    public Cat(String furcolor) {
        this.furcolor = furcolor;
    }

    public String getFurcolor() {
        return furcolor;
    }

    public void setFurcolor(String furcolor) {
        this.furcolor = furcolor;
    }
}
