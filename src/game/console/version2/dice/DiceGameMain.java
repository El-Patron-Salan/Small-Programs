package game.console.version2.dice;
import java.util.Scanner;
import java.util.InputMismatchException;

/*

TODO - after first input ,throw exception doesn't work :/

 */

public class DiceGameMain {

    public static void main(String[] args) throws InputMismatchException {

        Scanner sc = new Scanner(System.in);

        BaseDice getCharacters = new Characters();
        BaseDice getStage = new Stage();
        BaseDice getProblem = new Problem();

        //rules
        System.out.println("\t*************************************************************************************************");
        System.out.println("\t\t\t\t\tYou'll have to roll three times a dice");
        System.out.println("\t\tFirst you'll roll character, then stage and lastly problem that you've encountered");
        System.out.print("\nTo roll dice input \"Roll dice\": ");
        String inputCommand = sc.nextLine();

        if(inputCommand.toLowerCase().equals("roll dice")) {

            System.out.println(getCharacters.roll());
            System.out.println(getStage.roll());
            System.out.println(getProblem.roll());

            //print the whole story
            getCharacters.summary();
            getStage.summary();
            getProblem.summary();

        }
        else
            throw new InputMismatchException(" - wrong input");

    }

}
