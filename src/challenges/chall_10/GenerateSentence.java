package challenges.chall_10;

import java.io.FileNotFoundException;

public class GenerateSentence {
    public static void main(String[] args) {
        try {
            Sentences.generator();
        }catch(FileNotFoundException e) {
            System.out.println(e + " - file not found");
        }
    }
}
