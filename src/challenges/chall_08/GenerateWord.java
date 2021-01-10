package challenges.chall_08;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GenerateWord {

    public static ArrayList<String> getWord() throws NullPointerException, FileNotFoundException{

        Scanner scanner = new Scanner(new File("/home/alan/Desktop/Java_Examples/out/production/Java_Examples/challenges/chall_08/words.txt"));
        ArrayList <String> wordList = new ArrayList<>();

        while(scanner.hasNext())
            wordList.add(scanner.next());
        scanner.close();
        return(wordList);
    }

    public static String getRandomWord() throws FileNotFoundException{
        //GenerateWord g = new GenerateWord();
        Random rand = new Random();
        ArrayList<String> wordList = getWord();
        int index = rand.nextInt(wordList.size());
        return wordList.get(index);
    }
}