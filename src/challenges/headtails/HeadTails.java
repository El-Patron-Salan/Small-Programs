package challenges.headtails;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

final class HeadTails {

    private static String headOrTailRand(String[] arr){
        Random rand = new Random();
        //draws value from array
        int index = rand.nextInt(arr.length);
        return arr[index];
    }


    public static void main(String[] args)throws InputMismatchException {

        Scanner flip = new Scanner(System.in);

        String[] headTails = {"Head", "Tails"};
        System.out.println("To exit press \"e\"!");
        System.out.println("Hit enter to flip a coin: ");

            String flipping;
            do {
                flipping = flip.nextLine();
                if(flipping.equals(""))
                    System.out.println(headOrTailRand(headTails));
                else if(flipping.equals("e")) System.out.println();
                else
                    throw new InputMismatchException(" Just press enter");

            }while(!flipping.toLowerCase().equals("e"));
    }
}

