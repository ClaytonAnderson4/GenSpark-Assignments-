package com.company.Java.People;

import com.company.Java.Land.Location;

public class Human extends Humanoid {
//sight, movement, str, health, equipment
    String name;
    int type = 1;

    public Human(String name){
        setHuman(name);
    }

    public Human(String name, Location location){
        setHuman(name);
        setLocation(location);
    }

    public void setHuman(String name){
        setName(name);
        setDescription("Human named: " + name);
        setHealth(4);
        setMovement(1);
        setSight(2);
        setStrength(3);
        setSymbol('H');
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString(){
        return "Human named: "+ name +"Health: "+ health+
                "Strength: " +strength+
                "Movement: " + movement+
                "Sight: " + sight;
    }




}


