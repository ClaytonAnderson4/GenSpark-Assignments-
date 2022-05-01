package com.company.Java.Land;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y){



        this.x=x;
        this.y=y;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean Same(Location location){
        if ((location.getX()==this.getX())&&(location.getY()==this.getY())){
            return true;

        }else{
            return false;
        }

    }

    public Location distance(Location location){
        int difX=this.getX()- location.getX();
        int difY=this.getY()-location.getY();

        return new Location(difX,difY);


    }

    @Override
    public String toString(){
        return getX()+ " X " + getY() + " Y";
    }

}
