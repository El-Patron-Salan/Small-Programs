package challenges.chall_16;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("String: ");
        String toReverse = input.next();
        char[] arr = toReverse.toCharArray();
        for(int i = arr.length - 1; i >= 0; --i)
            System.out.print(arr[i]);
    }

}
