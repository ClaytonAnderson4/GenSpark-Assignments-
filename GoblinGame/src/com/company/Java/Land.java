package com.company.Java;

public class Land {
    private int index;
    private String name;
    private int type;
    private char symbol = '/';
    private char gobSymbol = 'G';
    private char heroSymbol = 'H';
    private boolean goblin = false;
    private boolean hero = false;

    public Land(int index, String name, char symbol,int type) {
        this.index = index;
        this.name = name;
        this.type = type;
        this.symbol=symbol;
    }

    public char getSymbol() {
        if(hero){
            return heroSymbol;
        }else if(goblin){
            return gobSymbol;
        }else{
            return symbol;
        }

    }

    public char getGobSymbol() {
        return gobSymbol;
    }

    public void setGobSymbol(char gobSymbol) {
        this.gobSymbol = gobSymbol;
    }

    public char getHeroSymbol() {
        return heroSymbol;
    }

    public void setHeroSymbol(char heroSymbol) {
        this.heroSymbol = heroSymbol;
    }

    public boolean isGoblin() {
        return goblin;
    }

    public void setGoblin(boolean goblin) {
        this.goblin = goblin;
    }

    public boolean isHero() {
        return hero;
    }

    public void setHero(boolean hero) {
        this.hero = hero;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }



    @Override
    public String toString(){
        return "Name: " + name +
                "Symbol: " + symbol +
                "Index: " + index;

    }

}
