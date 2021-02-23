package challenges.chall_11;

import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    //arrays with optional symbols
    private final char [] symbols = {'~', '`', '!', '@', '#' , '$', '%', '^', '&', '*', '(', ')', '_', '-', '=', '+',
            '[', '{', ']', '}', '\\', '|', ';', ':', '\'', '"', ',', '<', '.', '>', '/', '?'};

    private final char [] lowerCaseChars = {'a' , 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q' , 'r', 's', 't', 'u', 'v', 'w', 'x', 'y' , 'z'};

    private final char [] upperCaseChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private final char [] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    //methods asking about external symbols
    private static boolean wantsSymbols(String kind, String example) {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want " + kind + " in password like " + example + "?(Y/N) ");
        char in = input.next().charAt(0);
        return in == 'Y' || in == 'y';
    }

    //return random value from specified array
    private static char randValue(char[] arr) {
        Random rand = new Random();
        return arr[rand.nextInt(arr.length)];
    }

    //combine the random values
    private static char[] combineRandomValues(int length, char [] array) {
        char [] returnedArray = new char[length];
        for(int i = 0; i < length; ++i) {
            returnedArray[i] = randValue(array);
        }
        return returnedArray;
    }

    //combine arrays
    private static char[] combineArrays(char[]arr1, char[]arr2, char[]arr3, char[]arr4) {
        StringBuilder sb = new StringBuilder();
        if(arr1.length > 0)
            sb.append(arr1);
        if(arr2.length > 0)
            sb.append(arr2);
        if(arr3.length > 0)
            sb.append(arr3);
        if(arr4.length > 0)
            sb.append(arr4);
        return sb.toString().toCharArray();
    }

    private static String generatePassword(boolean inclSymbols, boolean inclLower,
                                           boolean inclUpper, boolean inclNumbers, int length) {
        PasswordGenerator obj = new PasswordGenerator();

        //take first letters of bool
        char symbolsBool = String.valueOf(inclSymbols).toLowerCase().charAt(0);
        char lowerBool = String.valueOf(inclLower).toLowerCase().charAt(0);
        char upperBool = String.valueOf(inclUpper).toLowerCase().charAt(0);
        char numbersBool = String.valueOf(inclNumbers).toLowerCase().charAt(0);

        if(!(inclLower == inclNumbers == inclUpper == inclSymbols))
            System.out.println("You've to at least include one type of symbol");
        if(symbolsBool == 't')
            combineRandomValues(length, obj.symbols);
        if(lowerBool == 't')
            combineRandomValues(length, obj.lowerCaseChars);
        if(upperBool == 't')
            combineRandomValues(length, obj.upperCaseChars);
        if(numbersBool == 't')
            combineRandomValues(length, obj.numbers);

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lengthOfPass = 0;
        //variables specifying the complexity of password
        boolean inclSymbols, inclLowercaseChars, inclUppercaseChars, inclNumbers;

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
        System.out.println();
        //questions about symbols
        inclSymbols = wantsSymbols("symbols", "$,#,@ etc.");
        //lowercaseCharacters
        inclLowercaseChars = wantsSymbols("lowercase characters", "a,b,c...");
        //uppercaseCharacters
        inclUppercaseChars = wantsSymbols("uppercase characters", "A,B,C...");
        //numbers
        inclNumbers = wantsSymbols("numbers", "0,1,2,3...");


    }
    /*TO-DO:
    -learn REGEX
    -try to implement it somehow
     */
}
