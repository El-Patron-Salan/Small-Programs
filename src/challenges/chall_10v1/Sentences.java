package challenges.chall_10v1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

public class Sentences {
    static int lengthOfSentence;

    private static int randomLength() {
        return lengthOfSentence = ThreadLocalRandom.current().nextInt(7,8);
    }

    private static void sevenLengthSentence (String noun, String verb, String prep, String adj) {
        System.out.println("The" + " " + adj + " " + noun + " " + prep + " " + verb + " the " + noun );
    }

    private static void eightLengthSentence (String noun, String verb, String adj1, String prep, String adj2) {
        System.out.println("The" + " " + adj1 + " " + noun + " " + verb + " " + prep + " the " + adj2 + " " + noun );
    }

    public static void generator() throws FileNotFoundException {
        RandomWords randWords = new RandomWords();

        String noun = randWords.getRandomWord(new File("nouns.txt"));
        String verb = randWords.getRandomWord(new File("verbs.txt"));
        String adj1 = randWords.getRandomWord(new File("adjectives.txt"));
        String adj2 = randWords.getRandomWord(new File("adjectives.txt"));
        String prep = randWords.getRandomWord(new File("prepositions.txt"));

        //since some words in files starts with capitol letter so move them to lower cases
        String n = noun.toLowerCase();
        String v = verb.toLowerCase();
        String a1 = adj1.toLowerCase();
        String a2 = adj2.toLowerCase();
        String p = prep.toLowerCase();
    }
}
