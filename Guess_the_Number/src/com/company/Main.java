package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Hello! What is your name? ");

        Scanner userInput = new Scanner(System.in);
        String name = userInput.nextLine();


        boolean keepGoing = true;

        while (keepGoing) {

            String respBuff = String.format("Well %s, I am thinking of a number between 1 and 20.", name);


            int genNum = new rndNum().guess();
            // System.out.println(genNum);


            System.out.println();
            System.out.println(respBuff);
            System.out.println();
            System.out.println("Take a guess");
            System.out.println();
            System.out.println();
            boolean guessed = false;
            String Response = "";

            while (!guessed) {
                int guess = userInput.nextInt();

                if (guess == genNum) {
                    guessed = true;
                    Response = "Good Job!";
                } else if (guess > genNum) {
                    Response = "To high! Try again.";
                } else if (guess < genNum) {
                    Response = "To low! Try again.";
                }

                System.out.println();
                System.out.println(Response);
                System.out.println();


            }

            System.out.println("Would you like to keep playing?");
            String x;
            x = userInput.next();

            Boolean y = x.equals("y");

            if (y) {
                System.out.println("Great!");
            }else{
                keepGoing=false;
            }


        }
    }
}
