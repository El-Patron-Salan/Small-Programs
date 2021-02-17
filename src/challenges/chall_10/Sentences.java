package challenges.chall_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

public class Sentences {

    private static int randomLength() {
        return ThreadLocalRandom.current().nextInt(7,9);
    }

    private static void sevenLengthSentence (String noun1, String noun2, String verb, String prep, String adj) {
        System.out.println("The" + " " + adj + " " + noun1 + " " + prep + " " + verb + " the " + noun2 + ".");
    }

    private static void eightLengthSentence (String noun1, String noun2, String verb, String adj1, String prep, String adj2) {
        System.out.println("The" + " " + adj1 + " " + noun1 + " " + verb + " " + prep + " the " + adj2 + " " + noun2 + ".");
    }

    public static void generator() throws FileNotFoundException {
        RandomWords randWords = new RandomWords();

        String noun1 = randWords.getRandomWord(new File("/home/alan/Desktop/Java_Examples/out/production/Java_Examples/challenges/chall_10v1/nouns.txt"));
        String noun2 = randWords.getRandomWord(new File("/home/alan/Desktop/Java_Examples/out/production/Java_Examples/challenges/chall_10v1/nouns.txt"));
        String verb = randWords.getRandomWord(new File("/home/alan/Desktop/Java_Examples/out/production/Java_Examples/challenges/chall_10v1/verbs.txt"));
        String adj1 = randWords.getRandomWord(new File("/home/alan/Desktop/Java_Examples/out/production/Java_Examples/challenges/chall_10v1/adjectives.txt"));
        String adj2 = randWords.getRandomWord(new File("/home/alan/Desktop/Java_Examples/out/production/Java_Examples/challenges/chall_10v1/adjectives.txt"));
        String prep = randWords.getRandomWord(new File("/home/alan/Desktop/Java_Examples/out/production/Java_Examples/challenges/chall_10v1/prepositions.txt"));

        //since some words in files starts with capitol letter so move them to lower cases
        String n1 = noun1.toLowerCase();
        String n2 = noun2.toLowerCase();
        String v = verb.toLowerCase();
        String a1 = adj1.toLowerCase();
        String a2 = adj2.toLowerCase();
        String p = prep.toLowerCase();

        if(randomLength() == 7)
            sevenLengthSentence(n1, n2, v, p, a1);
        else
            eightLengthSentence(n1, n2, v, a1, p, a2);
    }
}
