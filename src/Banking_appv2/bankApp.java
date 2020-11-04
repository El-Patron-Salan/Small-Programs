package Banking_appv2;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.InputMismatchException;

public class bankApp {

    private String name;
    private double balance;

    public bankApp(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    //print brief information about newly created account
    public static void newAccounts(String newName, int PIN, double money) {
        System.out.println("\nName: " + newName);
        System.out.println("Generated PIN: " + PIN);
        System.out.println("Balance: " + money);
    }

    //randomize PIN number
    public static int randomPIN() {
        Random rand = new Random();
        return rand.nextInt(10000 - 1000) + 1000;
    }


    //method to deposit money
    public static double deposit(double x, double y){
        return x + y;
    }
    //x = balance  , y = money to withdraw
    public static double withdraw(double x, double y){
        if(x < y){
            System.out.println("*** You don't have enough money on your account ***");
            return x;
        }
        else
            return x - y;
    }

    //round up to 2 decimal places
    public static double round(double x){
        double rB;
        return rB = Math.round(x * 100.0) / 100.0;
    }

    //entrance menu
    public static void intro()throws InterruptedException{
        System.out.println("\n\n\t\t\t\t\tWelcome in  C Z A J A  Bank");
        System.out.println("Insert your card");
        System.out.println("Processing...");
        //this is used to imitate data processing in a real bank
        Thread.sleep(3000);
        System.out.print("\nProvide PIN for your credit card: ");
    }

    //MENU
    public static void menu(String accName){
        System.out.println("\nHello " + accName + ", choose an operation you want to perform\n");
        System.out.println("***********************************\n");
        System.out.println("\n1. Check your balance\n2. Deposit money\n3. Withdraw money\n5. Logout");
        System.out.println("\n\n***********************************\n");
    }

    //after doing an operation tell to choose again...
    public static void printAgain(){
        System.out.println("\nChoose again an operation you want to perform or press 5 to leave");
    }


    public static void main(String[] args)throws InterruptedException{

            Scanner input = new Scanner(System.in);

            //collect accounts in HashMap with PIN as key and object as a value
            Map<Integer, bankApp> accounts = new HashMap<>();
            accounts.put(1994, new bankApp(568.4552, "Charlie Hendrix"));
            accounts.put(2002, new bankApp(1242.23, "Eduardo Moet"));
            accounts.put(1241, new bankApp(64322.21, "Malik Montana"));

            //logging into account using PIN
            int provPIN;
            int option = 0;
            //loop as long as the user would like to use bank
            do {

                intro();

                try {
                    provPIN = input.nextInt();
                    if (accounts.containsKey(provPIN)) {

                        //MENU
                        bankApp acc = accounts.get(provPIN);
                        menu(acc.name);

                        //options
                        while (option != 4) {
                            option = input.nextInt();
                            switch (option) {

                                case 1:
                                    System.out.printf("\n\t\tYour balance is %.2f%C",acc.balance,'$');//works as round
                                    printAgain();
                                    break;

                                case 2:
                                    System.out.println("\n\t\tInput amount of money you want to deposit\n");
                                    acc.balance = deposit(acc.balance, input.nextDouble());
                                    System.out.println("\n\t\tNow your balance is " + round(acc.balance) + "$");
                                    printAgain();
                                    break;

                                case 3:
                                    System.out.println("\n\t\tInput amount of money you want to withdraw");
                                    acc.balance = withdraw(acc.balance, input.nextDouble());
                                    System.out.println("\n\t\tBalance " + round(acc.balance) + "$");
                                    printAgain();
                                    break;

                                case 4:
                                    break;

                                default:
                                    System.out.println("\n\t\tThis operation cannot be performed at the moment");
                                    System.out.println("\t\t\t\tMake an input once again");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Wrong PIN");
                        System.out.println("Do you want to create new account? If 'yes' then type Y or N for 'no'");
                        char choice = input.next().charAt(0);

                        if (choice == 'Y') {
                            //creating new account
                            double depMon;
                            String provName;
                            int randPIN = randomPIN();

                            System.out.println("Create new account\nLater the details of your account will be printed");
                            System.out.println("\nInput your name:");
                            input.nextLine(); //next.Int doesn't read new line after ENTER so nextLine does it
                            provName = input.nextLine();

                            System.out.println("\nDeposit money: ");
                            depMon = input.nextDouble();

                            accounts.put(randPIN, new bankApp(depMon, provName));
                            //call method and print values
                            newAccounts(provName, randPIN, round(depMon));


                        } else break;
                    }
                    //if someone made mistake catch error
                }catch(InputMismatchException e){
                    System.out.println("\nWrong input!\nFor PIN provide integer and for a name provide string");
                }
            } while (option != 4);
    }
}