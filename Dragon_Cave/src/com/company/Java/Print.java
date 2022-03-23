package com.company.Java;

public class Print {
    public void Printer(String toPrint, Boolean newLine){
        if (newLine){
            System.out.println(toPrint);
        }else{
            System.out.print(toPrint);
        }
    }
}
