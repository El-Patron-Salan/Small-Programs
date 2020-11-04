package game.console.dice;
import java.util.InputMismatchException;
import java.util.Scanner;

class DiceGame {

    static void rollDice(String roll){
        System.out.print("Make input: ");
    }

    public static void main(String[] args) throws InputMismatchException {

        Scanner input = new Scanner(System.in);
        //create objects
        RolledCharacter characterRandom = new RolledCharacter();
        RolledStage stageRandom = new RolledStage();

        //explain rules
        System.out.println("You'll have to roll three times a dice");
        System.out.print("To roll dice input \"Roll dice\": ");

        String roll = input.nextLine();
        do{

            //who are you
            System.out.print(characterRandom.rolled());

            //roll again and draw where you are
            rollDice(input.nextLine());
            System.out.print(stageRandom.rolled());



        }while(roll.toLowerCase().equals("roll dice"));
        System.out.println("");
            throw new InputMismatchException(" - wrong input!");

    }

}
