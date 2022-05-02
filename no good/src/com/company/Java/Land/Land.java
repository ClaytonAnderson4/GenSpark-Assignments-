package com.company.Java.Land;


public class Land {



    String name = "basic land";

    char symbol='/';

    TypeEnum landType = TypeEnum.GRASS;
    Occupation occupied=Occupation.EMPTY;
    String path="";
    private Location location;





    public Land(TypeEnum type, String name, Location location){

        this.landType=type;
        path=getPath();
        setName(name);
        setLocation(location);
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



    public void setOccupied(Occupation occupied) {
        this.occupied = occupied;
        path=getPath();

    }


    public char getSymbol() {
        return symbol;
    }








    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }



    public TypeEnum getTypeEnum() {
        return landType;
    }



    public String getPath(){
        Paths p = new Paths();

        switch (occupied){
            case HERO:
                switch (landType){
                    case GRASS:
                        path=p.graPathHero;
                        break;
                    case HUT:
                        path=p.hutPathHero;
                        break;
                    case CASTLE:
                        path=p.casPathHero;
                        break;
                }
                break;
            case GOBLIN:
                switch (landType){
                    case GRASS:
                        path=p.graPathGoblin;
                        break;
                    case HUT:
                        path=p.hutPathGoblin;
                        break;
                    case CASTLE:
                        path=p.casPathGoblin;
                        break;
                }
                break;
            case EMPTY:
                switch (landType){
                    case GRASS:
                        path=p.graPathNormal;
                        break;
                    case HUT:
                        path=p.hutPathNormal;
                        break;
                    case CASTLE:
                        path=p.casPathNormal;
                        break;
                }
                break;

        }

        return path;

    }

}
