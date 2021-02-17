package challenges.chall_10v1;

import java.util.concurrent.ThreadLocalRandom;

public class Sentences {
    final private static String theNode = "The";
    static int lengthOfSentence;

    private static int randomLength() {
        return lengthOfSentence = ThreadLocalRandom.current().nextInt(7,8);
    }
}
