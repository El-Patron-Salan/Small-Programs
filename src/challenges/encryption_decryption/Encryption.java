package challenges.encryption_decryption;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Encryption {

    private static StringBuilder encrypt(String input, int offset) {

        StringBuilder sb = new StringBuilder();

        if(offset > 26)
            offset %= 26;
        //when shift is negative
        else if(offset < 0)
            offset = (offset % 26) + 26;

        for (char character : input.toCharArray()) {
            if(character != ' '){
                //get actual position in alphabet and make a scope from 0 to 25
                int positionChar = character - 'a';
                //remain in scope of alphabet
                int newPosition = (positionChar + offset) % 26;
                //return to ascii table and take value
                char newCharacter = (char) (newPosition + 'a');

                sb.append(newCharacter);
            }
            else
                sb.append(character);
        }
        return sb;
    }

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Message to encrypt: ");
            String toEncrypt = input.nextLine();
            System.out.print("Offset: ");
            int offset = input.nextInt();

            System.out.println("Encrypted message: " + encrypt(toEncrypt, offset));
        }catch(InputMismatchException e){
            System.out.println(e + " - wrong input");
        }

    }
}
