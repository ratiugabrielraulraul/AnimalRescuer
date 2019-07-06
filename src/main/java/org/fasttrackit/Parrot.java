package org.fasttrackit;

public class Parrot extends Animal {

    boolean availableToTalk;

    public Parrot(String name, boolean availableToTalk) {
        super();
        this.setName(name);
        this.setAvailableToTalk(availableToTalk);
    }

    public boolean isAvailableToTalk() {
        return availableToTalk;
    }

    public void setAvailableToTalk(boolean availableToTalk) {
        this.availableToTalk = availableToTalk;
    }
}
