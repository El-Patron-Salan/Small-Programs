package game.console.guessnumb;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class GuessNumb {

    public static void main(String[] args){

        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int computerNumber = rand.nextInt(100);
        int countRounds = 0;

        System.out.print("Input number: ");

        try {
            int numb = input.nextInt();
            while (computerNumber != numb) {

                if (computerNumber < numb) System.out.println("Too high");
                else
                    System.out.println("Too low");

                countRounds++;

                System.out.print("Input number: ");
                numb = input.nextInt();

            }
            System.out.println("Congratulations! " + computerNumber + " is the number that computer has thought");
            System.out.println("You've made it in " + countRounds + " rounds");

        }catch (InputMismatchException e) {
            System.out.println(e + " - wrong input!");
        }

    }

}
