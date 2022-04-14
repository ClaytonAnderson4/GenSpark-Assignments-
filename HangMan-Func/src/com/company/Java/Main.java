package com.company.Java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        boolean playing= true;

      List<String> dict;

        String filePath ="C:\\Users\\Clayton\\IdeaProjects\\HangMan\\src\\com\\company\\Resources\\Dictionary";

        dict = readWord(filePath);


        //while (playing){



            String word=getWord(dict);


            word = word.toLowerCase();

       // play("cat");

          play(word);


       // }


    }



    public static void play(String word){
        //Init

        HashSet<Character> charSet = new HashSet<>();






        Scanner sc = new Scanner(System.in);
        DrawBoard db = new DrawBoard();
        db.Start(word);



        boolean dead = false;
        boolean finished=false;

        HashSet<Character> missedL = new HashSet<>();
        HashSet<Character> guessedL=new HashSet<>();


        word.chars()
                .mapToObj(c -> (char) c)
                .forEach(charSet::add);



            //guess loop
            while (!dead&&!finished) {



               // boolean corrInput = false;



                char c = ' ';
              //  while (!corrInput) {

                    System.out.print("Guess a Letter");
                    c = sc.next().charAt(0);

                    c=toLower(c);




                   // corrInput=isLetter(c);




              //  }


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

            if(finished){
                System.out.println("Great Job! The word was " + word);
                int score = word.length()*(26- missedL.size());
                try {
                    writeScore(score);
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }


            }else if(dead){
                System.out.println("You lost! The Word was: "+word);
            }

/*


        Boolean yesNo=false;
        Boolean playing=false;

        while (!yesNo){
            System.out.print("Play Again?");

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

 */

    }

    public static void writeScore(int score) throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Name:");
        String name = sc.next();

        String toWrite = score+ "   , "+name+"\n";
        String fileName = "src/com/company/Resources/High Score";

        FileWriter myWriter = new FileWriter(fileName,true);

        myWriter.write(toWrite);
        myWriter.close();


    }





    public static String getWord(List<String> dict){

        int index = (int)(Math.random() * dict.size());

        String buf = dict.get(index);

        return buf;

    }

    public static boolean inSet(char c, HashSet<Character> charSet){

        //System.out.println(charSet+" / " + c);


        if(charSet.contains(c)){
            return true;
        }


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

    public static List<String> readWord(String filePath) throws FileNotFoundException {
        List<String > rtnDict = new ArrayList<>();
        File file = new File(filePath);



        try {

            rtnDict = Files.readAllLines(Paths.get(filePath));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


      //  System.out.println(rtnDict.toString());
        return rtnDict;
    }

}

