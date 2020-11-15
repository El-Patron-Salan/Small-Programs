package challenges.encryption_decryption;
import java.util.Scanner;

public class EncryptionROT13 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Message: ");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= input.length() - 1; i++){
           char c = input.charAt(i);
           if(c != ' ') {
               int positionOfCharacter = c - 'a';
               int newPosition = (positionOfCharacter + 13) % 26;
               char newCharacter = (char) ('a' + newPosition);
               sb.append(newCharacter);
           }
           else{
               sb.append(c);
           }
        }
        System.out.println("Encrypted message: " + sb);

    }


}
