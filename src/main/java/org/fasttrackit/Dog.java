package org.fasttrackit;

public class Dog extends Animal {

    String furColor;

    @Override
    public void expressHappiness() {
        System.out.println(this.getName() + " is playing with his tail");
    }

    public Dog(String furColor, String name)
    {
        super();
        this.furColor = furColor;
        this.setName(name);

    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
}
