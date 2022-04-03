package com.company.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class DrawBoard {
    private static String[] state = new String[7];
    private char corr[];

    public void Start(String word){
        int sz=word.length();
        corr= new char[sz];

        String staBuf="";

        for(int i =0;i<word.length();i++){corr[i]='-';}
        for(char c:corr){staBuf+=c;}


        state[0]="\n+---+\n";
        state[1]="    |\n";
        state[2]="    |\n";
        state[3]="    |\n";
        state[4]="  ====\n";
        state[5]="Missed Letters:";
        state[6]="\n"+staBuf+"\n";
        //state[7]="\nGuess a letter: ";

        Print();


    }


    private static void Print(){

        for(String s:state){
            System.out.print(s);
        }

    }

    public static boolean Correct(HashSet<Character> guesses, String word) {

        String printWord="";
        int dashCt = 0;

        for(char c:word.toCharArray()){
            if(guesses.contains(c)){
                printWord+=c;

            }else{
                printWord+='-';
                dashCt++;

            }

        }



        if(dashCt==0){
            return true;
        }else{
            state[6]="\n"+printWord+"\n";
            Print();
            return false;
        }

    }






    public static boolean UpdateML(HashSet<Character> missedLetters){
        boolean dead = false;

        if(missedLetters.size()>0){
            state[1]=" O  |\n";
        }

        if(missedLetters.size()==2){
            state[2]=" |  |\n";
        }else if(missedLetters.size()==3){
            state[2]="/|  |\n";
        }else if(missedLetters.size()>3){
            state[2]="/|\\ |\n";
        }


        if(missedLetters.size()==5){
            state[3]="/   |\n";
        }else if(missedLetters.size()>5){
            state[3]="/ \\ |\n";
            dead = true;
        }



        ArrayList<Character> buf = new ArrayList<>();
        for(Character z:missedLetters){
            buf.add(z);
        }

        Collections.sort(buf);

        String strBuf = "Missed Letters: ";
        for (Character x:buf){
            strBuf=strBuf+x+" ";
        }



        state[5]=strBuf;



        Print();

        return dead;
    }


}
