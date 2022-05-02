package com.company.Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static int height = 5;
    static int width = 5;
    static ArrayList<Land> worldMap;
    static Humanoid player;
    static Humanoid goblin;
    static JPanel displayPanel = new JPanel();
    static JPanel actionPanel = new JPanel();
    static JPanel buttonPanel = new JPanel();
    static JLabel displayLabel = new JLabel();
    static JLabel actionLabel = new JLabel();

    static JButton[] buttons = new JButton[4];

    public static void main(String[] args) {
        boolean playing=true;
        worldMap = CreateBoard();
        CreatePeople();
        PrintBoard();
        UI();







    }

    public static ArrayList<Land> CreateBoard(){
        ArrayList<Land> worldBuffer = new ArrayList<>();

        int worldSize = height*width;

        int castleIndex = (int)(Math.random()*worldSize);
        int goblinCampIndex = castleIndex+2*width;
        if(goblinCampIndex>=worldSize){goblinCampIndex-=worldSize;}



   //     System.out.println("Castle Index: " +castleIndex );
     //   System.out.println("Goblin Camp Index: " + goblinCampIndex);

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

    public static void UI(){
        JFrame window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setResizable(false);
        window.setTitle("Goblins");



        displayLabel.setBounds(0,0,200,200);
        displayLabel.setFont(new Font("Book Antiqua",Font.PLAIN,26));

        displayPanel.add(displayLabel);
        displayPanel.setBounds(50,50,700,200);




        actionLabel.setBounds(0,0,200,200);
        actionLabel.setFont(new Font("Book Antiqua",Font.PLAIN,26));

        actionPanel.add(actionLabel);
        actionPanel.setBounds(50,250,700,200);


        buttons[0] = new JButton("North");
        buttons[1] = new JButton("South");
        buttons[2] = new JButton("East");
        buttons[3] = new JButton("West");

        SetListeners();

        buttons[0].setBounds(50,0,100,100);
        buttons[1].setBounds(200,0,100,100);
        buttons[2].setBounds(350,0,150,100);
        buttons[3].setBounds(500,0,100,100);

        buttonPanel.add(buttons[0]);
        buttonPanel.add(buttons[1]);
        buttonPanel.add(buttons[2]);
        buttonPanel.add(buttons[3]);

        buttonPanel.setBounds(50,0,700,200);

        window.add(actionPanel);
        window.add(displayPanel);
        window.add(buttonPanel);




        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void SetListeners(){
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovePlayer(Directions.NORTH);
            }
        });

        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovePlayer(Directions.SOUTH);
            }
        });

        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovePlayer(Directions.EAST);
            }
        });

        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovePlayer(Directions.WEST);
            }
        });
    }

    public static void PrintBoard(){
        String toPrint="";
        int counter = 0;
        for(int i=0;i<worldMap.size();i++){
            toPrint+=worldMap.get(i).getSymbol();

            counter++;
            if(counter==width){counter=0;toPrint+="\n";}


        }



     //   System.out.println(toPrint);
        displayLabel.setText("<html>" + toPrint.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

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

            String actionReport = "";

            while((playerHp>0)&&(goblinHp>0)){
                int playerAtt = (int)Math.floor(Math.random()*playerStr+1);
                int goblinAtt =(int)Math.floor(Math.random()*goblinStr+1);

                playerHp-=goblinAtt;
                goblinHp-=playerAtt;

                actionReport+="Hero attacks for " + playerAtt +
                        " reducing the goblin's health to " + goblinHp + "\n";

           //     System.out.println("Hero attacks for " + playerAtt +
           //                         " reducing the goblin's health to " + goblinHp);

                actionReport+="Goblin attacks for " + goblinAtt +
                        " reducing your health to " + playerHp+"\n";

              //  System.out.println("Goblin attacks for " + goblinAtt +
             //           " reducing your health to " + playerHp);



            }


            actionLabel.setText("<html>" + actionReport.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");



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

    public static char convertCase(char c){

        if(c<97){c+=32;}

        return c;
    }

    public static boolean CheckInput(char c){
        return  ((c=='n')||(c=='s')||(c=='e')||(c=='w'));
    }

    public static void MovePlayer(Directions direction) {
/*
        char m;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("What direction (n/s/e/w):");
            m = sc.next().charAt(0);
            m= convertCase(m);
        } while (!CheckInput(m));
*/

        switch (direction) {
            case NORTH:
                MoveNorth();
                break;
            case SOUTH:
                MoveSouth();
                break;
            case EAST:
                MoveEast();
                break;
            case WEST:
                MoveWest();
                break;
        }

        CheckFight();
        MoveGoblin();
        PrintBoard();

        if(player.getHealth()==0){
            displayLabel.setText("You Lost");
           buttonPanel.setVisible(false);
           // System.out.println("You Lost");
        }else if(goblin.getHealth()==0){
            displayLabel.setText("You Won!");
            buttonPanel.setVisible(false);
           // System.out.println("You Won!");
        }
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
