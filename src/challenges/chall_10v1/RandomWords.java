package challenges.chall_10v1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class RandomWords {
    public String getRandomWord(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Random random = new Random();
        String outcome = null;
        int count = 0;
        while(scanner.hasNext()) {
            count++;
            String l = scanner.nextLine();
            if(random.nextInt(count) == 0)
                outcome = l;
        }
        return outcome;
    }
}
