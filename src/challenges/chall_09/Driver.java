package challenges.chall_09;
import java.util.Scanner;

public class Driver {
    private static char[] mustHaveWord = "LOVES".toCharArray();
    private static Scanner input = new Scanner(System.in);

    private static String firstName(){
        System.out.println("First name to calculate: ");
        return input.nextLine();
    }
    private static String secondName(){
        System.out.println("Second name to calculate: ");
        return input.nextLine();
    }

    private static char[] changeNameToArray(String name) {
        return name.toUpperCase().toCharArray();
    }

}
