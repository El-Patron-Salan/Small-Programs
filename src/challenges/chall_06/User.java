package challenges.chall_06;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);
    private String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void askName(){
        System.out.println("What's your name?");
        System.out.print("Input: ");
        name = input.next();
    }
    public int userChoice(){
        try{
        System.out.println("You can choose:\nROCK | PAPER | SCISSORS | LIZARD | SPOCK");
        input.nextLine();
        String choice = input.nextLine().toUpperCase();
        String s = choice.substring(0, 2);

        switch (s) {
            case "RO":
                return Rules.ROCK;
            case "PA":
                return Rules.PAPER;
            case "SC":
                return Rules.SCISSORS;
            case "LI":
                return Rules.LIZARD;
            case "SP":
                return Rules.SPOCK;
            default:
                userChoice();
                return 0;
        }
    }catch(StringIndexOutOfBoundsException e){
            userChoice();
            return 0;
        }
    }
    public char playAgain(){
        char choice;
        System.out.println("Do you want to play another round? (Y\\N)");
        choice = input.next().charAt(0);
        if(choice == 'Y' || choice == 'y')
            return 'Y';
        else
            return 'N';
    }

}
