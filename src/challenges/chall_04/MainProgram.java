package challenges.chall_04;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgram {

    private static void menu(){

        System.out.println("\t1 - encryption" +
                           "\n\t2 - decryption");
        System.out.print("Choose option: ");
    }

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            menu ();
            int option = input.nextInt();
            input.nextLine();
            switch (option){
                case 1:
                    System.out.println("Message to encrypt: ");
                    String toEncrypt = input.nextLine();
                    System.out.print("Offset: ");
                    int offset = input.nextInt();
                    System.out.println("\nEncrypted message: " + Encryption.encrypt(toEncrypt, offset));
                    break;
                case 2:
                    System.out.println("Message to decrypt: ");
                    String toDecrypt = input.nextLine();
                    System.out.print("Offset: ");
                    int decryptOffset = input.nextInt();
                    System.out.println("\nDecrypted message: " + Decryption.decrypt(toDecrypt, decryptOffset));
                    break;
                default:
                    System.out.println("There isn't such an option");
            }
        }catch(InputMismatchException e){
            System.out.println(e + " - wrong input");
        }

    }
}
