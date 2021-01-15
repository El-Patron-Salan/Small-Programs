package challenges.chall_08;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

public class DriverVersionTwo {
    //it needs to be this way, cuz it has to handle FileNotFoundException
    private static String getRandWord;
    static{
        try{
            getRandWord = GenerateWord.getRandomWord();
        }catch(FileNotFoundException e){
            e.getStackTrace();
        }
    }

    DriverVersionTwo(){}

    final private static char[] wordInCharacters = getRandWord.toCharArray();
    private static char[] inputFromUser = new char[wordInCharacters.length];
    private static int lives = 7;
    private static int count = 0;
    private static boolean presence = true;
    private static LinkedList<Character> list = new LinkedList<>();


    private static void hideWord(char[] arr, int size){
        for(int i = 0; i < size; ++i)
            arr[i] = '_';
    }

    private static void checkIfCorrect(String input, char[] hiddenArr){
        if (input.length() > 1) {
            if (input.equals(getRandWord)) {
                Dialogs.outputAfterTheGame(true, getRandWord, lives);
            } else {
                System.out.println("Wrong! It isn't the correct word!\n\t\tGAME OVER!");
            }
            System.exit(0);
        }else {
            for (int i = 0; i < inputFromUser.length; ++i) {
                if (input.charAt(0) == (wordInCharacters[i])) {
                    hiddenArr[i] = input.charAt(0);
                    presence = false;
                }
            }
        }
    }
    /*
    TO-DO:
    -handle wrong input such as numbers and special characters
     */
    private static void checkIfCharacterIsInTheList(char input){
        if(!(list.contains(input)) && presence){
            list.add(input);
            System.out.println("Wrong guess, try again");
            lives--;
        }
        else if(!(list.contains(input)) && !presence){
            list.add(input);
            System.out.println("You guessed correct!");
        }
        else{
            System.out.println("This character - \"" + input + "\" has been already used!");
            System.out.println("Unfortunately you lose a life");
            lives--;
        }
    }

    private static void printUsedCharacters(int count){
        if(count > 0) {
            System.out.println("\n\nAlready used characters:");
            System.out.println(list);
        }
    }

    private static void showHiddenWord(char[] array )
    {
            for(var x : array){
                System.out.print(x + " ");
            }
    }

    private static boolean win(){
        return Arrays.equals(inputFromUser, wordInCharacters);
    }

    private static boolean lose(){
        return lives == 0;
    }

    public static void game(){
        Scanner input = new Scanner(System.in);
        Dialogs.descriptionOfGame();
        System.out.println();
        hideWord(inputFromUser, inputFromUser.length);

        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            AnimationOfHangman.hangmanImage(lives);
            System.out.println("\nWord to guess:");
            showHiddenWord(inputFromUser);
            printUsedCharacters(count);
            System.out.print("\n\nGuess the character: ");
            String guess = input.next().toLowerCase();
            checkIfCorrect(guess, inputFromUser);
            checkIfCharacterIsInTheList(guess.charAt(0));
            System.out.println("Remaining lives: " + lives);
            count++;
            presence = true;
            if(win()) {
                Dialogs.outputAfterTheGame(true, getRandWord,lives);
                break;
            }
            else if(lose()) {
                AnimationOfHangman.hangmanImage(0);
                Dialogs.outputAfterTheGame(false, getRandWord,lives);
                break;
            }
        }
    }



}
