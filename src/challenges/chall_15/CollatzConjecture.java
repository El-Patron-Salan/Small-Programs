package challenges.chall_15;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CollatzConjecture {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{

            System.out.println("For what number you want make collatz conjecture?");
            System.out.print("Number: ");
            int x = sc.nextInt();

        }catch(InputMismatchException e) {
            System.out.println(e + " - wrong input");
        }
    }
}
