package challenges.chall_08;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

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
    private static int arrayLength = inputFromUser.length;
    private static char providedChar;
    private static int correctCharacter = 0;
    private static LinkedList<Character> list = new LinkedList<>();
    private static int lives = 7;
    private static boolean loseGame = false;
    Scanner input = new Scanner(System.in);
    //hide word as "_"
    private static void hideWord(char[] arr, int size){
        for(int i = 0; i < size; ++i)
            arr[i] = '_';
    }

    private static void checkIfCorrect(String input, char[] hiddenArr){
        if(input.length() > 1) {
            if (input.equals(getRandWord)) {
                System.out.println("Great job!! You guessed the entire word!");
            } else {
                System.out.println("Wrong! You lose a life!");
                lives--;
            }
        }else {
            for (int i = 0; i < inputFromUser.length; ++i) {
                if (input.charAt(0) == (wordInCharacters[i])) {
                    correctCharacter++;
                    hiddenArr[i] = input.charAt(0);
                    System.out.println("Correct! \"" + input.charAt(0) + "\" is in the word!");
                } else {
                    System.out.println("Wrong! You lose a life!");
                    lives--;
                }
            }
        }
    }

    private static void checkIfCharacterIsInTheList(char input){
        if(!(list.contains(input))){
            list.add(input);
        }
        else{
            System.out.println("This character has been already used - " + input);
            System.out.println("Unfortunately you lose a life");
            lives--;
        }
    }

    private static boolean lose(){
        if(list.size() > 7 || lives == 0){
            return loseGame = true;
        }
        return loseGame;
    }

    public static void game(){
        Dialogs.descriptionOfGame();
        System.out.println();
        hideWord(inputFromUser, arrayLength);

        while(!lose()){

            System.out.print("Guess the character: ");


        }
    }



}
