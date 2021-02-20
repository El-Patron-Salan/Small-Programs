package challenges.chall_11;

import java.util.Scanner;

public class PasswordGenerator {
    //arrays with optional symbols
    private final char [] symbols = {'~', '`', '!', '@', '#' , '$', '%', '^', '&', '*', '(', ')', '_', '-', '=', '+',
            '[', '{', ']', '}', '\\', '|', ';', ':', '\'', '"', ',', '<', '.', '>', '/', '?'};

    private final char [] lowerCaseChars = {'a' , 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q' , 'r', 's', 't', 'u', 'v', 'w', 'x', 'y' , 'z'};

    private final char [] upperCaseChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private final int [] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    //methods asking about external symbols
    private static boolean wantsSymbols(char in, String kind, String example) {
        System.out.print("Do you want " + kind + " in password like " + example + "?(Y/N) ");
        return in == 'Y' || in == 'y';
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lengthOfPass = 0;
        //variables specifying the complexity of password
        boolean inclSymbols = false;
        boolean inclLowercaseChars = false;
        boolean inclUppercaseChars = false;
        boolean inclNumbers = false;

        while (true) {
            System.out.print("Password length from 6 to 128: ");
            lengthOfPass = input.nextInt();
            if (lengthOfPass >= 6 && lengthOfPass <= 128) {
                break;
            }
            else {
                System.out.println("Try again");
            }
        }
        //questions about symbols
        inclSymbols = wantsSymbols(input.next().charAt(0), "symbols", "$,#,@ etc.");
        //lowercaseCharacters
        inclLowercaseChars = wantsSymbols(input.next().charAt(0), "lowercase characters", "a,b,c...");
        //uppercaseCharacters
        inclUppercaseChars = wantsSymbols(input.next().charAt(0), "uppercase characters", "A,B,C...");
        //numbers
        inclNumbers = wantsSymbols(input.next().charAt(0), "numbers", "0,1,2,3...");


    }
}
