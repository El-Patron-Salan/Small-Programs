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
            System.out.println("Steps: " + collatz(x));

        }catch(InputMismatchException e) { //in case of incorrect input
            System.out.println(e + " - wrong input");
        }
    }

    /**
     * Calculate collatz conjecture
     *
     * @param val   The value to be calculated
     * @return number of steps which takes to get 1
     */
    private static int collatz(int val) {
        if(val <= 1) {
            System.out.print("\"" + val + "\"\n");
            return 0;
        }
        else if(val % 2 != 0) {
            System.out.print(val + ", ");
            return 1 + collatz(val * 3 + 1);
        }
        else {
            System.out.print(val + ", ");
            return 1 + collatz(val / 2);
        }
    }
}
