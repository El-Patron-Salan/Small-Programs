package challenges.chall_08;
import java.io.FileNotFoundException;
public class Driver {

    private static String hideWord(String hideRandWord) throws FileNotFoundException{
        return new String(new char[hideRandWord.length()]).replace("\0", "_");
    }

    public static void game(String guess){

    }


}
