package challenges.chall_10v1;

import java.io.FileNotFoundException;

public class GenerateSentence {
    public static void main(String[] args) {
        System.out.println("It's just a simple sentence generator");
        try {
            Sentences.generator();
        }catch(FileNotFoundException e) {
            System.out.println(e + " - file not found");
        }
    }
}
