package challenges.chall_08;
import java.io.FileNotFoundException;
public class Driver {

    private static String hideWord(String hideRandWord) throws FileNotFoundException{
        return new String(new char[hideRandWord.length()]).replace("\0", "_");
    }

    public static void game(String guess) throws FileNotFoundException{
        String importWord = GenerateWord.getRandomWord();
        String newHide = "";
        for(int i = 0; i < importWord.length(); ++i){
            if(importWord.charAt(i) == guess.charAt(0))
                newHide += guess.charAt(0);

            else if(hideWord(importWord).charAt(i) != '_')
                newHide += importWord.charAt(i);
            else
                newHide += "_";

        }

    }


}
