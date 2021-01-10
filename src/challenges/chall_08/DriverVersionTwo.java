package challenges.chall_08;

import java.io.FileNotFoundException;

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
    private static char[] hiddenWord = new char[wordInCharacters.length];
    private static char providedChar;

}
