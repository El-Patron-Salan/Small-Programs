package game.console.rockpaperscissors;
import java.util.Scanner;

class User {

    final String R = "Rock";
    final String P = "Paper";
    final String S = "Scissors";

    public String userChoice(){
        Scanner sc = new Scanner(System.in);
        String uCh = sc.nextLine();

        if (uCh.equals("R") || uCh.equals("P") || uCh.equals("S")){
            if(uCh.equals("R"))
                System.out.println("You gave " + R);
            if(uCh.equals("P"))
                System.out.println("You gave " + P);
            if(uCh.equals("S"))
                System.out.println("You gave " + S);
        }
        else System.out.println("Wrong input!");
    return uCh;
    }


}
