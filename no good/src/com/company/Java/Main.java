package com.company.Java;

import com.company.Java.Land.Land;
import com.company.Java.Land.Location;
import com.company.Java.Land.Occupation;
import com.company.Java.Land.TypeEnum;
import com.company.Java.People.Goblin;
import com.company.Java.People.Human;
import com.company.Java.People.Humanoid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int width =5;
    public static int height =5;
    static Human player;
    static Goblin enemy;
    static GUI gui;

    public static void main(String[] args) {
	// write your code here

        boolean playing=true;
        HashMap<Location, Land> boardList;
        ArrayList<Humanoid> peoples;




        boardList=StartBoard();
        gui = new GUI("Humans v Goblins",boardList);



        peoples = SpawnPeople(boardList);


        System.out.println(peoples);

        updateOcc(boardList);

        PrintBoard(boardList);




        while(playing){

            ChoosePlayerDirection();

            ChooseGoblinDirection();



            if(enemy.getLocation().Same(player.getLocation())){


                System.out.println("your hp " + player.getHealth());
                System.out.println("enemy hp "+ enemy.getHealth());


            }



            if(peoples.isEmpty()){
                System.out.println("Game Over");
                break;
            }


            updateOcc(boardList);

            PrintBoard(boardList);

        }

    }


    public static void ChoosePlayerDirection(){
        Scanner sc = new Scanner(System.in);


        System.out.print("What direction (n/s/e/w):");
        char m = sc.next().charAt(0);

        Location pL = player.getLocation();


        int curLoc;


        if(m=='n'){

            curLoc= pL.getY()-1;
            if(curLoc<0){curLoc++;}
            pL.setY(curLoc);



        }else if(m=='s'){

            curLoc= pL.getY()+1;
            if(curLoc>= height){curLoc--;}
            pL.setY(curLoc);


        }else if(m=='e'){

            curLoc= pL.getX()+1;
            if(curLoc>= width){curLoc--;}
            pL.setX(curLoc);

        }else if(m=='w'){
            curLoc= pL.getX()-1;
            if(curLoc<0){curLoc++;}
            pL.setX(curLoc);

        }



        player.setLocation(pL);


    }

    public static void ChooseGoblinDirection(){
        Location distance = player.getLocation().distance(enemy.getLocation());

        int gBufX=enemy.getLocation().getX();
        int gBufY=enemy.getLocation().getY();


        if(Math.abs(distance.getX())>=Math.abs(distance.getY())){
            int buf;
            if(distance.getX()<0){
                buf = -1;
            }else if (distance.getX()>0){
                buf =1;
            }else{
                buf=0;
            }
            gBufX+=buf;

        }else{
            int buf;
            if(distance.getY()<0){
                buf = -1;

            }else if(distance.getY()>0){
                buf = -1;

            }else{
                buf =0;
            }
            gBufY+=buf;
        }

        enemy.setLocation(new Location(gBufX,gBufY));
    }

    private static ArrayList<Humanoid> SpawnPeople(HashMap<Location, Land> boardList) {
        ArrayList<Humanoid> peoples = new ArrayList<>();


        for(Land l:boardList.values()){
           // System.out.println(l.getType());
            if(l.getTypeEnum()== TypeEnum.HUT){
                try{
                   // System.out.println("gcs");
                    enemy =new Goblin(1,l.getLocation());
                    peoples.add(enemy);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }else if(l.getTypeEnum()== TypeEnum.CASTLE){
                try{
                  //  System.out.println("hcs");
                    player=new Human("John",l.getLocation());
                    peoples.add(player);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }

        return peoples;

    }




    public static Goblin Fight(Goblin enemy){
        int playerStr = player.getStrength();
        int playerHp = player.getHealth();
        int enemyStr = enemy.getStrength();
        int enemyHp = enemy.getHealth();





        while(playerHp>0){

            int playerAtt = (int) Math.floor(Math.random()*playerStr+1);
            int enemyAtt = (int) Math.floor(Math.random()*enemyStr+1);


            enemyHp-=playerAtt;

            System.out.println("You attack for " +playerAtt+ " reducing it to " + enemyHp );

            if(enemyHp<=0){break;}




            playerHp-=enemyAtt;



            System.out.println("The enemy attacks for " + enemyAtt + " reducing your health to " +playerHp);


        }


        if ((playerHp<=0)){
            player.setHealth(0);
            player.setAlive(false);
        }else{
            player.setHealth(playerHp);
        }

        if(enemyHp<=0){
            enemy.setHealth(0);
            enemy.setAlive(false);
        }else{

        }



       return enemy;


}


    public static void updateOcc(HashMap<Location,Land> worldMap){


        for(Land l: worldMap.values()){
            l.setOccupied(Occupation.EMPTY);
        }

        int cntr=0;
        for(Location l: worldMap.keySet()){

            System.out.println(l.toString()+" " + cntr);

            if(l.Same(player.getLocation())){
                System.out.println(l.toString());
                worldMap.get(l).setOccupied(Occupation.HERO);
            }else if(l.Same(enemy.getLocation())){
                System.out.println(l.toString());
                worldMap.get(l).setOccupied(Occupation.GOBLIN);
            }

            cntr++;
        }
gui.PrintFrame(worldMap);


    }


    public static void PrintBoard(HashMap<Location,Land> worldMap){

      // gui.UpdateFrame(worldMap);

        ArrayList<String > toPrint = new ArrayList<>();

        for(int x=0;x<width;x++){

            String strBuf="";
            for(int y=0;y<height;y++){

                Location loBuf = new Location(x,y);
                for(Location l: worldMap.keySet()){
                    if(loBuf.Same(l)){
                        strBuf+=worldMap.get(l).getSymbol()+"";
                    }
                }

            }
            toPrint.add(strBuf);
        }


        for (String s : toPrint) {
            System.out.println(s);
        }




    }





    public static HashMap<Location, Land> StartBoard(){



        HashMap<Location,Land> worldMap = new HashMap<>();

        int max = width*height;

        int gc = (int)(Math.random()*max);
        int hc =gc+2*width;
        if(hc>max){hc-=max;}
        System.out.println(gc+" Goblin Camp");
        System.out.println(hc+" Hero Castle");
        int currentId = 0;
        for(int i = 0; i< width; i++){
            //ArrayList<Land> buff = new ArrayList<>();

            for(int j = 0; j< height; j++) {

                System.out.println(currentId);
                Land buffer;
                if(currentId==gc){
                    buffer=new Land(TypeEnum.HUT,"Goblin Cave",new Location(i,j));


                }else if(currentId==hc){
                    buffer=new Land(TypeEnum.CASTLE,"Hero's Castle",new Location(i,j));
                }else {
                    buffer=new Land(TypeEnum.GRASS,"Grass Land",new Location(i,j));
                }




                System.out.println(buffer.toString());
                worldMap.put(buffer.getLocation() ,buffer);
                currentId++;
            }
        }
        System.out.println(worldMap.toString());

        return worldMap;
    }
}
