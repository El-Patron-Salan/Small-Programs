package challenges.chall_10v1;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Sentences {
    final private String theNode;
    final private String nounsPath;
    final private String verbsPath;
    final private String adjectivesPath;
    final private String prepositionsPath;

    static int lengthOfSentence;
    RandomWords randWords = new RandomWords();

    Sentences() {
        theNode = "The";
        nounsPath = "nouns.txt";
        verbsPath = "verbs.txt";
        adjectivesPath = "adjectives.txt";
        prepositionsPath = "preposition.txt";
    }

    private static int randomLength() {
        return lengthOfSentence = ThreadLocalRandom.current().nextInt(7,8);
    }

    private static void sevenLengthSentence (String noun, String verb, String prep, String adj, String the) {
        System.out.println(the + " " + adj + " " + noun + " " + prep + " " + verb + " " + the.toLowerCase() + " " + noun );
    }
}
