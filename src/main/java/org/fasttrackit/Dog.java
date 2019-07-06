package org.fasttrackit;

public class Dog extends Animal {

    String furColor;

    @Override
    public void expressHappiness() {
        System.out.println("Playing with his tail");
    }

    public Dog(String furColor)
    {
        super();
        this.furColor = furColor;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
}
