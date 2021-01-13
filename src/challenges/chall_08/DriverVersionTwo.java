package challenges.chall_08;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Locale;
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
    private static String guess;
    private static int correctCharacter = 0;
    private static int lives = 7;
    private static int count = 0;
    private static LinkedList<Character> list = new LinkedList<>();
    private static boolean loseGame = false;
    //hide word as "_"
    private static void hideWord(char[] arr, int size){
        for(int i = 0; i < size; ++i)
            arr[i] = '*';
    }

    private static void checkIfCorrect(String input, char[] hiddenArr){
        if(input.length() > 1) {
            if (input.equals(getRandWord)) {
                System.out.println("Great job!! You guessed the entire word!");
            } else {
                System.out.println("Wrong! It isn't the correct word, you lose a life!");

            }
        }else {
            for (int i = 0; i < inputFromUser.length; ++i) {
                if (input.charAt(0) == (wordInCharacters[i])) {
                    correctCharacter++;
                    hiddenArr[i] = input.charAt(0);
                    System.out.println("Correct! \"" + input.charAt(0) + "\" is in the word!");
                } else {
                    System.out.println("Wrong! You lose a life!");

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

        }
    }

    private static void printUsedCharacters(int count){
        if(count > 1) {
            System.out.println("Already used characters:");
            System.out.println(list);
        }
    }

    private static String arrayToString(char[] array )
    {
        StringBuilder sb    = new StringBuilder();
        boolean first = true;

        for( char particle : array )
        {
            if( !first )
                sb.append( ' ' );

            sb.append( particle );
            first = false;
        }

        return sb.toString();
    }


    private static boolean lose(){
        if(list.size() > 7){
            return loseGame = true;
        }
        return loseGame;
    }

    public static void game(){
        Scanner input = new Scanner(System.in);
        Dialogs.descriptionOfGame();
        System.out.println();
        hideWord(inputFromUser, arrayLength);

        while(!lose()){
            System.out.println("Word to guess:");
            arrayToString(inputFromUser);
            System.out.print("Guess the character: ");
            guess = input.next().toLowerCase();
            checkIfCorrect(guess, inputFromUser);
            checkIfCharacterIsInTheList(guess.charAt(0));
            printUsedCharacters(count);
            count++;
        }
    }



}
