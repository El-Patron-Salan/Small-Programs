package game.console.version2.dice;
import java.util.Random;

public class Problem extends BaseDice{

    private static final String[] problem = {"was chased by a tornado of sharks",
            "was sent to Auschwitz", "got lost in space", "was sucked by black hole",
            "lost his memory" , "drank drugged tonic"};


    Random rand = new Random();
    //random value from an array
    int index = rand.nextInt(problem.length);


    protected String roll(){

        super.roll();

        System.out.printf("%nDrawn \"%d\"%n", index);

        System.out.print("Encountered problem: ");
        return problem[index];

    }

    @Override
    protected void summary() {
        System.out.print(" " + problem[index] + ".");
    }

}
