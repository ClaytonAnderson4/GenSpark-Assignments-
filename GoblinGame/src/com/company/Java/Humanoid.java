package com.company.Java;

public class Humanoid {
    private int index;
    private int health;
    private int strength;
    private int type;
    private String name;

    public Humanoid(int index, int health, int strength, String name, int type) {
        this.index = index;
        this.health = health;
        this.strength = strength;
        this.name = name;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name: " + name +
                "Index: " + index +
                "Health: " + health +
                "Strength " + strength +
                "Type " + type;
    }

}
