package com.company.Java;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static int height = 5;
    static int width = 5;
    static ArrayList<Land> worldMap;
    static Humanoid player;
    static Humanoid goblin;


    public static void main(String[] args) {
        boolean playing=true;
        worldMap = CreateBoard();
        CreatePeople();
        PrintBoard();


        while (playing){


            MovePlayer();
            MoveGoblin();
            PrintBoard();

            if(player.getHealth()==0){
                playing=false;
                System.out.println("You Lost");
            }else if(goblin.getHealth()==0){
                playing=false;
                System.out.println("You Won!");
            }
        }





    }


    public static ArrayList<Land> CreateBoard(){
        ArrayList<Land> worldBuffer = new ArrayList<>();

        int worldSize = height*width;

        int castleIndex = (int)(Math.random()*worldSize);
        int goblinCampIndex = castleIndex+2*width;
        if(goblinCampIndex>=worldSize){goblinCampIndex-=worldSize;}



        System.out.println("Castle Index: " +castleIndex );
        System.out.println("Goblin Camp Index: " + goblinCampIndex);

        for(int i=0;i<worldSize;i++){

            if(i==castleIndex){
                worldBuffer.add(i,new Land(i,"Hero's Castle",'W',1));
            }else if(i==goblinCampIndex){
                worldBuffer.add(i,new Land(i,"Goblin Camp",'M',2));
            }else {
                worldBuffer.add(i,new Land(i,"Grass",'/',0));
            }


        }


        return worldBuffer;

    }

    public static void PrintBoard(){
        String toPrint="";
        int counter = 0;
        for(int i=0;i<worldMap.size();i++){
            toPrint+=worldMap.get(i).getSymbol();

            counter++;
            if(counter==width){counter=0;toPrint+="\n";}


        }

        System.out.println(toPrint);

    }

    public static void CreatePeople(){

        for(Land l:worldMap){
            if(l.getType()==1){
                l.setHero(true);
                player = new Humanoid(l.getIndex(),2,2,"Hero",1);



            }else if(l.getType()==2){
                l.setGoblin(true);
                goblin = new Humanoid(l.getIndex(),1,1,"Goblin",2);
            }
        }


    }

    public static void MoveGoblin(){

        int goblinInd = goblin.getIndex();
        int distance = player.getIndex()- goblinInd;

        worldMap.get(goblinInd).setGoblin(false);




        if(distance>0){
            if(distance>=width){
                goblinInd+=width;
            }else{
                goblinInd++;
            }
        }else if(distance<0){
            if(Math.abs(distance)>=width){
                goblinInd-=width;
            }else{
                goblinInd--;
            }
        }

        goblin.setIndex(goblinInd);
        worldMap.get(goblinInd).setGoblin(true);


        CheckFight();

    }

    public static void CheckFight(){
        if(player.getIndex()==goblin.getIndex()){
            int playerStr = player.getStrength();
            int playerHp = player.getHealth();
            int goblinStr = goblin.getStrength();
            int goblinHp = goblin.getHealth();

            while((playerHp>0)&&(goblinHp>0)){
                int playerAtt = (int)Math.floor(Math.random()*playerStr+1);
                int goblinAtt =(int)Math.floor(Math.random()*goblinStr+1);

                playerHp-=goblinAtt;
                goblinHp-=playerAtt;
                System.out.println("Hero attacks for " + playerAtt +
                                    " reducing the goblin's health to " + goblinHp);

                System.out.println("Goblin attacks for " + goblinAtt +
                        " reducing your health to " + playerHp);

            }


            if(goblinHp<=0){
                goblin.setHealth(0);
                worldMap.get(goblin.getIndex()).setGoblin(false);
            }

            if(playerHp<=0){
                player.setHealth(0);
                worldMap.get(player.getIndex()).setHero(false);
            }




        }

    }


    public static void MovePlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What direction (n/s/e/w):");
        char m = sc.next().charAt(0);

        switch (m){
            case 'n': MoveNorth();
                break;
            case 's': MoveSouth();
                break;
            case 'e':MoveEast();
                break;
            case 'w': MoveWest();
                break;
        }

        CheckFight();
    }

    public static void MoveNorth(){
        int playerLoc = player.getIndex();
        worldMap.get(playerLoc).setHero(false);

        if(playerLoc>=width){
            playerLoc-=width;
        }

        worldMap.get(playerLoc).setHero(true);
        player.setIndex(playerLoc);

    }

    public static void MoveSouth(){
        int playerLoc = player.getIndex();
        worldMap.get(playerLoc).setHero(false);

        if(playerLoc<(width-1)*height){
            playerLoc+=width;
        }

        worldMap.get(playerLoc).setHero(true);
        player.setIndex(playerLoc);
    }

    public static void MoveEast(){
        int playerLoc = player.getIndex();
        worldMap.get(playerLoc).setHero(false);

        if((playerLoc+1)%width==0){
         //   System.out.println("e");
        }else {
            playerLoc++;
        }

        worldMap.get(playerLoc).setHero(true);
        player.setIndex(playerLoc);


    }

    public static void MoveWest(){
        int playerLoc = player.getIndex();
        worldMap.get(playerLoc).setHero(false);

        if((playerLoc)%width==0){
        //    System.out.println("w");
        }else {
            playerLoc--;
        }

        worldMap.get(playerLoc).setHero(true);
        player.setIndex(playerLoc);


    }

}
