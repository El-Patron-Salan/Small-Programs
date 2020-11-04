package game.console.version2.dice;
import java.util.Random;

public class Stage extends BaseDice{


    private static final String[] stage = {"inside a hidden cave", "in a dark forest", "at a farm", "on top of a mountain"
            ,"in a hot desert", "at a magical castle" };

    Random rand = new Random();
    //pick random value from an array
    int index = rand.nextInt(stage.length);


    protected String roll(){

        super.roll();



        System.out.printf("%nDrawn \"%d\"%n", index);

        System.out.print("Stage: ");
        return stage[index];
    }

    @Override
    protected void summary() {
        System.out.print(" " + stage[index]);
    }
}
