package com.company.Java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DrawBoard {
    private static String[] state = new String[7];
    private char corr[];
    private static ArrayList<String> boardStates;
    private static int missed_letters=0;
    private static String missed_letters_line = "Missed Letters: ";
    private static String dashedWord="";

    public void Start(String word) {
        boardStates = new ArrayList<>();
        AtomicReference<String> printWord= new AtomicReference<>("");
        String fileName = "src/com/company/Resources/Boards/Board State 0";
        HashSet<Character> guesses=new HashSet<>();

        System.out.println(readHiScore());

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);
            System.out.println(missed_letters_line);

            List<Character> list = word.chars()
                    .mapToObj(c -> (char) c).collect(Collectors.toList());

            list.stream().forEach(c->{
                if(guesses.contains(c)){
                    printWord.updateAndGet(v -> v + c);
                }else{

                    printWord.updateAndGet(v -> v+'-');
                }
            });

            dashedWord=printWord.get();
            System.out.println(dashedWord);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public static boolean Correct(HashSet<Character> guesses, String word) {

        AtomicReference<String> printWord= new AtomicReference<>("");
        AtomicInteger dashCt = new AtomicInteger();


        List<Character> list = word.chars()
                .mapToObj(c -> (char) c).collect(Collectors.toList());


       list.stream().forEach(c->{
           if(guesses.contains(c)){
               printWord.updateAndGet(v -> v + c);
           }else{
               dashCt.getAndIncrement();
               printWord.updateAndGet(v -> v+'-');
           }
       });



        String fileName="src/com/company/Resources/Boards/Board State";


        fileName+=" "+missed_letters;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(missed_letters_line);

        dashedWord=printWord.get();

        if(dashCt.get() ==0){
            return true;
        }else{
            System.out.println(dashedWord);
            return false;
        }

    }

    public static boolean UpdateML(HashSet<Character> missedLetters){
        boolean dead = false;
        missed_letters= missedLetters.size();
        String fileName="src/com/company/Resources/Boards/Board State";



        if(missed_letters>5){dead=true;}

        fileName+=" "+missed_letters;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        ArrayList<Character> buf = missedLetters.stream().collect(Collectors.toCollection(ArrayList::new));

        missed_letters_line="Missed Letters: "+buf.stream().map(y->y+" ").collect(Collectors.joining());
        System.out.println(missed_letters_line);
        System.out.println(dashedWord);



        return dead;
    }


    public static String readHiScore(){

        AtomicReference<String> highScore = new AtomicReference<>("");
        String fileName = "src/com/company/Resources/High Score";

        try {
            ArrayList<String> scores = Files.lines(Paths.get(fileName)).collect(Collectors.toCollection(ArrayList::new));
            final int[] hs = {0};

            scores.stream().forEach(y->{



                int score = Integer.parseInt(y.substring(0,3).trim());

                if(score> hs[0]){
                    hs[0] =score;
                    highScore.set(y);
                }
            });


        }catch (Exception e){
            System.out.println(e.getMessage());
        }




        return highScore.get();
    }

}
