package challenges.generator;
import java.util.Scanner;
import java.io.FileNotFoundException;

final class GenerateName {

    protected static void genInfo(String decision)throws FileNotFoundException{

        ImportingCredentials impCredentials = new ImportingCredentials();
        ImportingJobs impJobs = new ImportingJobs();

        if(decision.toLowerCase().equals("yes")){
            impCredentials.getCredentials();
            impJobs.getJobs();
        }
        else {
            System.out.println("Wrong input - program will terminate");
            System.exit(0);
        }
        }

    protected static void genNames(String input)throws FileNotFoundException{

        ImportingMaleNames impNames = new ImportingMaleNames();
        ImportingFemaleNames impFemaleNames = new ImportingFemaleNames();
        ImportingSurnames impSurnames = new ImportingSurnames();

        if (input.toLowerCase().equals("m")) {
            System.out.print("\nName: ");
            impNames.getMaleNames();
            System.out.print("Surname: ");
            impSurnames.getSurnames();

        } else if (input.toLowerCase().equals("f")) {
            System.out.print("\nName: ");
            impFemaleNames.getFemaleNames();
            System.out.print("Surname: ");
            impSurnames.getSurnames();

        } else System.out.println("Wrong input");

    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\t\tWelcome in full name generator!");
        System.out.print("Type M for male name and F for female name: ");

        String inputChUser = sc.next();
        genNames(inputChUser);

        System.out.println("\nDo you want to generate credentials and jobs?");
        System.out.print("Input \"Yes\" or \"No\": ");
        String inputStrUser = sc.next();

        genInfo(inputStrUser);

    }
}
