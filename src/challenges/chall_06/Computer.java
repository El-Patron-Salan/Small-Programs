package challenges.chall_06;
import java.util.Random;

public class Computer {

    public int getCompInput(){
        Random rand = new Random();
        int input;
        return input = rand.nextInt(5) + 1;
    }
}
