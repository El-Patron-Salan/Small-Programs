package challenges.chall_11;

import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    /*
     * Arrays with optional symbols
     */
    private final char [] SYMBOLS = {'~', '`', '!', '@', '#' , '$', '%', '^', '&', '*', '(', ')', '_', '-', '=', '+',
            '[', '{', ']', '}', '\\', '|', ';', ':', '\'', '"', ',', '<', '.', '>', '/', '?'};

    private final char [] LOWERCASECHARS = {'a' , 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q' , 'r', 's', 't', 'u', 'v', 'w', 'x', 'y' , 'z'};

    private final char [] UPPERCASECHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private final char [] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /*
     * Method asking about external symbols
     * @param var String kind to input kind of symbol
     * @param var String example to show what it looks like
     * @return true if user type 'Y' or 'y' and remain false if he doesn't
     */
    private static boolean wantsSymbols(String kind, String example) {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want " + kind + " in password like " + example + "?(Y/N) ");
        char in = input.next().charAt(0);
        return in == 'Y' || in == 'y';
    }

    /*
     * Return random value from specified array
     * @param arr character array to draw character from
     * @return a random character from the specified array
     */
    private static char randValue(char[] arr) {
        Random rand = new Random();
        return arr[rand.nextInt(arr.length)];
    }

    /*
     * Combine the random values
     * @param var int length of given array
     * @param arr character array to get values from it
     * @return an array with random values from the other array
     */
    private static char[] combineRandomValues(int length, char [] array) {
        char [] returnedArray = new char[length];
        for(int i = 0; i < length; ++i) {
            returnedArray[i] = randValue(array);
        }
        return returnedArray;
    }

    /*
     * Combine arrays if they are not empty
     * @param arr character first array to take every value from it
     * @param arr character second array to take every value from it
     * @param arr character third array to take every value from it
     * @param arr character fourth array to take every value from it
     * @return the character array with the values of other arrays if they are not empty
     */
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

//    //from long array take random value
//    private static char pickRandomValuesFromLongArray(char[] longArray) {
//        int randomNumber = ThreadLocalRandom.current().nextInt(0, longArray.length);
//        return longArray[randomNumber];
//    }

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

        if(!inclLower && !inclNumbers && !inclUpper && !inclSymbols) {
            System.out.println("You've to at least include one type of symbol");
            System.exit(0);
        }

        if(inclSymbols) {
            sArray = combineRandomValues(length, obj.SYMBOLS);
        }
        if(inclLower) {
            lArray = combineRandomValues(length, obj.LOWERCASECHARS);
        }
        if(inclUpper) {
            uArray = combineRandomValues(length, obj.UPPERCASECHARS);
        }
        if(inclNumbers) {
            nArray = combineRandomValues(length, obj.NUMBERS);
        }

        //combine array 4 arrays from before
        char[] combinedArray = combineArrays(sArray, lArray, uArray, nArray);

        for(int i = 0; i < length; ++i)
            sb.append(randValue(combinedArray));

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lengthOfPass;
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
        System.out.printf("\n%s", password);
        System.out.println();
    }
}
