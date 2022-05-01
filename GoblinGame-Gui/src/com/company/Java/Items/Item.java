package com.company.Java.Items;

import java.util.HashMap;

public class Item {
    String name;
    String description;
    //array of bonuses Health, Movement, Sight, Strength
    int bonuses[] = {0,0,0,0};
    int healthBonus=0;
    int movementBonus=0;
    int sightBonus=0;
    int strengthBonus=0;


    public Item(){
        setName("dust");
        setDescription("dirt and debris");
    }

    public Item(String name,String description){

        setName(name);
        setDescription(description);

    }
                                    //attribute: 0=health 1=movement 2=sight 3=strength
    public Item(String name,String description, int attribute, int bonus){

        setName(name);
        setDescription(description);
        initBonus(attribute,bonus);


    }

    private void initBonus(int attr, int bonus){
        switch (attr){
            case 0:
                setHealthBonus(bonus);
                break;
            case 1:
                setMovementBonus(bonus);
                break;
            case 2:
                setSightBonus(bonus);
                break;
            case 3:
                setStrengthBonus(bonus);
                break;
            default:
                System.out.println("Incorrect attribute");
                break;
        }
    }

    @Override
    public String toString(){

        return name + " " + description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }

    public int getMovementBonus() {
        return movementBonus;
    }

    public void setMovementBonus(int movementBonus) {
        this.movementBonus = movementBonus;
    }

    public int getSightBonus() {
        return sightBonus;
    }

    public void setSightBonus(int sightBonus) {
        this.sightBonus = sightBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

