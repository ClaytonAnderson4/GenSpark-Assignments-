package com.company.Java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.print("What is your name?");


       String name="";

        try {
            name = new Input().getInput();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        String str = String.format("Hello %s Let us go on an Adventure.", name);


        System.out.println(str);

        System.out.println("After hours of walking you come across 2 caves...");
        System.out.println("A dragon lies in each, but one will eat you and the other will make you rich.");


        int x = 0;
        boolean correctResponse = false;

        while (!correctResponse) {
            try {

                System.out.print("Which cave will you enter? (1 or 2)");


                Scanner userInput = new Scanner(System.in);
                String answer = userInput.nextLine();


                x = Integer.valueOf(answer);

                correctResponse = Resposes(x);





            } catch (Exception e) {

                System.out.println(e.getMessage());
                System.out.println("Try Again");
            }


        }
    }


public static Boolean Resposes(int evil)  {
    if (evil == 1) {
        System.out.println("You approach the cave \n" +
                "It is Dark and Spooky\n" +
                "A large dragon jumps out, opening his jaws\n" +
                "You are eaten in one bite! :(");
        return true;
    } else if (evil == 2) {
        System.out.println("You approach the cave \n" +
                "It is Dark and Spooky\n" +
                "A large dragon jumps out, opening his jaws\n" +
                "His name is Teddy and he is friendly! :)");
        return true;
    } else {
        System.out.println("Unexpected Input! Try Again");
        return false;


    }

}


    }

