package challenges.chall_08;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GenerateWord {

    public void getWord() throws NullPointerException, FileNotFoundException{

        Scanner scanner = new Scanner(new File("words.txt"));
        ArrayList <String> wordList = new ArrayList<>();

        while(scanner.hasNext())
            wordList.add(scanner.next());
        scanner.close();
        System.out.println(wordList);
        System.out.println(wordList.size());
    }

    public static void main(String[] args) {
        GenerateWord gen = new GenerateWord();
        try {
            gen.getWord();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }


}
