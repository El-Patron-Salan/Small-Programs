package challenges.chall_11;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    //from long array take random value
    private static char pickRandomValuesFromLongArray(char[] longArray) {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, longArray.length);
        return longArray[randomNumber];
    }

    private static String generatePassword(boolean inclSymbols, boolean inclLower,
                                           boolean inclUpper, boolean inclNumbers, int length) {
        //created object to use the arrays with values
        PasswordGenerator obj = new PasswordGenerator();

        //using string builder to create password
        StringBuilder sb = new StringBuilder();

        //arrays for random values
        char [] sArray = new char[0];
        char [] lArray = new char[0];
        char [] uArray = new char[0];
        char [] nArray = new char[0];

        //take first letters of bool
        char symbolsBool = String.valueOf(inclSymbols).toLowerCase().charAt(0);
        char lowerBool = String.valueOf(inclLower).toLowerCase().charAt(0);
        char upperBool = String.valueOf(inclUpper).toLowerCase().charAt(0);
        char numbersBool = String.valueOf(inclNumbers).toLowerCase().charAt(0);

        if(!(inclLower == inclNumbers == inclUpper == inclSymbols))
            System.out.println("You've to at least include one type of symbol");

        if(symbolsBool == 't') {
            sArray = new char[length];
            sArray = combineRandomValues(length, obj.symbols);
        }
        if(lowerBool == 't') {
            lArray = new char[length];
            lArray = combineRandomValues(length, obj.lowerCaseChars);
        }
        if(upperBool == 't') {
            uArray = new char[length];
            uArray = combineRandomValues(length, obj.upperCaseChars);
        }
        if(numbersBool == 't') {
            nArray = new char[length];
            nArray = combineRandomValues(length, obj.numbers);
        }

        //combine array 4 arrays from before
        char[] combinedArray = combineArrays(sArray, lArray, uArray, nArray);

        for(int i = 0; i < length; ++i)
            sb.append(pickRandomValuesFromLongArray(combinedArray));

        return sb.toString();
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

        //initialize and output password
        String password = generatePassword(inclSymbols, inclLowercaseChars, inclUppercaseChars, inclNumbers, lengthOfPass);
    }
    /*TO-DO:
    -learn REGEX
    -try to implement it somehow
     */
}
