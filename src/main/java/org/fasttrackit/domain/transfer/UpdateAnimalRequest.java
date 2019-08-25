package org.fasttrackit.domain.transfer;

public class UpdateAnimalRequest {
    private String name;
    private String furColor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    @Override
    public String toString() {
        return "UpdateAnimalRequest{" +
                "name='" + name + '\'' +
                ", furColor='" + furColor + '\'' +
                '}';
    }
}