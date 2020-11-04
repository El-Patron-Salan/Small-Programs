package game.console.dice;


import java.util.Random;

public class RolledStage {

    private static final String[] stage = {"inside a hidden cave", "in a dark forest", "at a farm", "on top of a mountain"
                                           ,"in a hot desert", "at a magical castle" };

    String rolled(){
        Random rand = new Random();
        //pick random value from an array
        int index = rand.nextInt(stage.length);
        System.out.printf("Drawn \"%d\"%n", index);

        System.out.print(" ...");
        return stage[index];
    }
}
