package game.console.dice;
import java.util.Random;

public class RolledCharacter {

    //set of characters
    private static final String[] characters = {"a two-headed monster", "a fire-breathing dragon", "a hungry vampire",
                                                "an ugly toad", "a brutal viking", "a pussy cat"};

    String rolled(){
        Random rand = new Random();
        //pick random value from an array
        int index = rand.nextInt(characters.length);
        System.out.printf("You've drawn a field with value \"%d\"%n", index);

        System.out.print("You're ");
        return characters[index];
    }
}
