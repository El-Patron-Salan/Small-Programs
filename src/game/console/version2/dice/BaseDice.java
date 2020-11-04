package game.console.version2.dice;
import java.util.Scanner;

class BaseDice {

     protected String roll(){

         Scanner sc = new Scanner(System.in);
         System.out.print("\nRoll dice - make input: ");

         return sc.nextLine();
    }

    protected void summary(){}
}
