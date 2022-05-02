package com.company.Java.People;

import com.company.Java.Items.Item;
import com.company.Java.Land.Location;

import java.util.ArrayList;

public class Humanoid {

    public char getSymbol() {
        return symbol;
    }
    boolean alive=true;
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    String description;
    int type = 0;
    char symbol = 'h';
    int health=1;
    int strength=1;
    int movement=1;
    int sight=1;
    ArrayList<Item> equipment=null;
    Location location;

    public Humanoid(){

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Humanoid(String description){
        setDescription(description);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }


    public void setLocation(Location l){
        this.location=l;
    }



    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getSight() {
        return sight;
    }

    public void setSight(int sight) {
        this.sight = sight;
    }

    public ArrayList<Item> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Item> equipment) {
        this.equipment = equipment;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int h){
        health=h;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
