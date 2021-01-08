package challenges.chall_08;
import java.io.FileNotFoundException;
public class Driver {

    private static String hideWord() throws FileNotFoundException{
        return new String(new char[GenerateWord.getRandomWord().length()]).replace("\0", "_");
    }

}
