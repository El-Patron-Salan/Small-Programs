package game.console.rockpaperscissors;
import java.util.Random;

class Computer {

     final static String [] ch = {"Scissors", "Rock", "Paper"};

     public String compChoice(){
        Random rand = new Random();
        int index = rand.nextInt(ch.length);
         return ch[index];
     }

}
