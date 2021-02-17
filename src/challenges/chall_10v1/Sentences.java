package challenges.chall_10v1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

public class Sentences {
    static int lengthOfSentence;

    private static int randomLength() {
        return lengthOfSentence = ThreadLocalRandom.current().nextInt(7,8);
    }

    private static void sevenLengthSentence (String noun, String verb, String prep, String adj, String the) {
        System.out.println(the + " " + adj + " " + noun + " " + prep + " " + verb + " " + the.toLowerCase() + " " + noun );
    }

    private static void eightLengthSentence (String noun, String verb, String adj1, String prep, String adj2, String the) {
        System.out.println(the + " " + adj1 + " " + noun + " " + verb + " " + prep + " " + the.toLowerCase() + " " + adj2 + " " + noun );
    }

    public static void generator() throws FileNotFoundException {
        RandomWords randWords = new RandomWords();

        String noun = randWords.getRandomWord(new File("nouns.txt"));
        String verb = randWords.getRandomWord(new File("verbs.txt"));
        String adj1 = randWords.getRandomWord(new File("adjectives.txt"));
        String adj2 = randWords.getRandomWord(new File("adjectives.txt"));
        String prep = randWords.getRandomWord(new File("prepositions.txt"));


    }
}
