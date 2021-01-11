package challenges.chall_08;

import java.io.FileNotFoundException;
import java.util.LinkedList;

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

    final private static char[] wordInCharacters = getRandWord.toCharArray();
    private static char[] inputFromUser = new char[wordInCharacters.length];
    private static char providedChar;
    private static int correctCharacter = 0;
    private static LinkedList<Character> list = new LinkedList<>();
    private static int lives = 0;

    //hide word as "_"
    private static void hideWord(char[] arr, int size){
        for(int i = 0; i < size; ++i)
            arr[i] = '_';
    }

    private static void checkIfCorrect(char input, char[] hiddenArr){
        for(int i = 0; i < inputFromUser.length; ++i){
            if(input == wordInCharacters[i]){
                correctCharacter++;
                hiddenArr[i] = input;
            }
            else{
                list.add(input);
            }
        }
    }


}
