package game.console.version2.dice;
import java.util.Random;

class Characters extends BaseDice{

    //set of characters
    private static final String[] characters = {"a two-headed monster", "a fire-breathing dragon", "a hungry vampire",
            "an ugly toad", "a brutal viking", "a pussy cat"};


    Random rand = new Random();
    //pick random value from an array
    int index = rand.nextInt(characters.length);


    protected String roll(){

        System.out.printf("%nYou've drawn a field with value \"%d\"%n", index);

        System.out.print("Character: ");
        return characters[index];
    }

    @Override
    protected void summary(){
        String capitalize = characters[index].substring(0, 1).toUpperCase() + characters[index].substring(1);
        System.out.print("\n\t\t" + capitalize);
    }


}
