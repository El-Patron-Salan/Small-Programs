package challenges.chall_08;
import java.io.FileNotFoundException;
public class Driver {

    private static String hideWord() throws FileNotFoundException{
        String hide;
        return hide = new String(new char[GenerateWord.getRandomWord().length()]).replace("\0", "_");
    }

}
