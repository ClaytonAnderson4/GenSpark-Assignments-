package com.company.Java;

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



            boolean guessed = false;


            while (!guessed) {
                System.out.println();
                System.out.print("Take a guess ");

                try {
                    userInput = new Scanner(System.in);
                    int guess = userInput.nextInt();

                    guessed = Checker(guess,genNum);

                }catch (Exception e){

                    System.out.println("Not an Integer");

                }









            }

            System.out.print("Would you like to keep playing?");
            String x;
            userInput = new Scanner(System.in);
            x = userInput.next();

            boolean y = x.equals("y");

            if (y) {
                System.out.println("Great!");
            }else{
                keepGoing=false;
            }


        }
    }

    public static boolean Checker(int guess, int genNum) {
        if (guess == genNum) {
            System.out.println("Good Job!");
            return true;
        } else if (guess > genNum) {

            System.out.println("To high! Try again.");
            return false;
        } else {
            System.out.println("To low! Try again.");
            return false;
        }
    }
}
