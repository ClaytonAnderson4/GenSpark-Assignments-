package com.company.Java;

import java.util.Scanner;

public class Input {
    public String getInput(){
        String buf = "";

        Scanner userInput = new Scanner(System.in);
        buf = userInput.nextLine();

        return buf;
    }
}
