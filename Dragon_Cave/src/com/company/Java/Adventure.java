package com.company.Java;



public class Adventure {
    public void start(){



        new Print().Printer("What is your name?",false);

        String Name = "";


        try{
            Name = new Input().getInput();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }




        String str = String.format("Hello %s Let us go on an Adventure.",Name);

        new Print().Printer(str,true);
        new Print().Printer("After hours of walking you come across 2 caves...", true);
        new Print().Printer("A dragon lies in each, but one will eat you and the other will make you rich.", true);


    }

    public void cave(){

        start();





        //Cave Decision
        //Input and error handling

        int x = 0;
        boolean ansd = false;

       while (!ansd){
           try{
               new Print().Printer("Which cave will you enter? (1 or 2)",false);
               String answer = new Input().getInput();
               x = Integer.valueOf(answer);

               if(x==1){
                   Responses(true);
                   ansd=true;
               }else if (x==2){
                   Responses(false);
                   ansd=true;
               }else{
                   new Print().Printer("Try Again",true);
               }


           }catch (Exception e){

               System.out.println(e.getMessage());
                new Print().Printer("Try Again",true);
           }

       }

/*
        //Narration Response

        if(answer.equals("1")){
            Responses(true);
        }else if (answer.equals("2")){
            Responses(false);
        }else{
            new Print().Printer("Oh no you ran away scared",true);
        }*/
    }


    public void Responses(boolean evil){
        if (evil){
            new Print().Printer("You approach the cave",true);
            new Print().Printer("It is Dark and Spooky",true);
            new Print().Printer("A large dragon jumps out, opening his jaws",true);
            new Print().Printer("You are eaten in one bite :(",true);
        }else{
            new Print().Printer("You approach the cave",true);
            new Print().Printer("It is Dark and Spooky",true);
            new Print().Printer("A large dragon jumps out, opening his jaws",true);
            new Print().Printer("His name is Teddy and he is friendly! :)",true);
        }
    }

}


