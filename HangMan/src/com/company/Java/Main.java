package com.company.Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.FileHandler;

public class Main {



    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        boolean playing= true;

        ArrayList<String> dict = new ArrayList<>();

        String filePath ="C:\\Users\\Clayton\\IdeaProjects\\HangMan\\src\\com\\company\\Java\\Dictionary";

        dict = readWord(filePath);


        while (playing){



            String word=getWord(dict);


            word = word.toLowerCase();

           //System.out.println(word);
          // System.out.println(word.length()+"");

           play(word);
            playing=PlayAgain();
        }


    }

    public static boolean PlayAgain(){
    Boolean yesNo=false;
    Boolean playing=false;

    while (!yesNo){
        System.out.print("Play Again?");
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        if(c=='n'||c=='N') {
            yesNo=true;
            playing=false;
        }else if(c=='y'||c=='Y'){
            yesNo=true;
            playing=true;
        }

    }
    return playing;
}

    public static void play(String word){
        //Init

        HashSet<Character> charSet = new HashSet<>();
        for(int i=0;i<word.length();i++){charSet.add(word.charAt(i));}

        Scanner sc = new Scanner(System.in);
        DrawBoard db = new DrawBoard();
        db.Start(word);



        boolean dead = false;
        boolean finished=false;

        HashSet<Character> missedL = new HashSet<>();
        HashSet<Character> guessedL=new HashSet<>();






            //guess loop
            while (!dead&&!finished) {



                boolean corrInput = false;



                char c = ' ';
                while (!corrInput) {

                    System.out.print("Guess a Letter");
                    c = sc.next().charAt(0);

                    c=toLower(c);




                    corrInput=isLetter(c);




                }


                if((inSet(c,guessedL))||(inSet(c,missedL))){
                    System.out.println("You've already guessed that");
                } else if (!inSet(c, charSet)) {
                    System.out.println("Oh No. "+c+" is NOT in the word.");
                    missedL.add(c);
                    dead = db.UpdateML(missedL);
                } else {
                    //The character is in the word

                    System.out.println("Correct! "+c+" is in the word.");
                    guessedL.add(c);
                    finished = db.Correct(guessedL, word);
                }


            }

            //quit or play again

            if(finished){System.out.println("Great Job! The word was " + word);}
            else if(dead){System.out.println("You lost! The Word was: "+word);}



    }

    public static String getWord(ArrayList<String> dict){

        int index = (int)(Math.random() * dict.size());

        String buf = dict.get(index);

        return buf;

    }

    public static boolean inSet(char c, HashSet<Character> charSet){

        //System.out.println(charSet+" / " + c);

        for(char i:charSet){
            if (c==i){
                //System.out.println("T");
                return true;
            }
        }
       // System.out.println("F");
        return false;

    }

    public static char toLower(char c){
        if ((c >= 'A' && c <= 'Z')) {
            c += 32;
        }
        return c;
    }

    public static boolean isLetter(char c) {



            if ((c >= 'a' && c <= 'z')) {
                return true;
            }

            System.out.println("Please enter a letter (a-z)");
            return false;

    }

    public static ArrayList<String> readWord(String filePath) throws FileNotFoundException {
        ArrayList<String > rtnDict = new ArrayList<>();
        File file = new File(filePath);
        Scanner myReader = new Scanner(file);

        myReader.useDelimiter(",");

        while(myReader.hasNext()){
            rtnDict.add(myReader.next());
        }




        return rtnDict;
    }

}

