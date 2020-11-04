package convert.numbers;
import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

//program needs to be improved!

public class ConvertBinHexDecOct {

    //check if number is actually binary
    public static boolean isBin(long numb){

        while(numb > 0){
            if(numb % 10 > 1)
                return false;
            numb /= 10;
        }
        return true;
    }

    public static long binaryToDecimal(long numb){

        int decimalNumber = 0;
        int powerOfTwo = 1;

        //check if provided number is binary
        if(isBin(numb)){
            while(numb != 0){

                decimalNumber += (numb % 10) * powerOfTwo;
                powerOfTwo *= 2;
                //removes last digit from input
                numb /= 10;

            }
        }
        else throw new InvalidParameterException("Not a binary number");
        return decimalNumber;
    }

    public static void switchMenu(int option){

        Scanner input = new Scanner(System.in);
        long numb;
        switch(option){
            case 1:
                System.out.println("Input binary number :");
                numb = input.nextLong();
                long convertedNumb = binaryToDecimal(numb);
                System.out.println("Converted number from binary " + numb + " to decimal is " + convertedNumb);
                break;

            case 2:
                System.out.println("Input number");
                numb = input.nextLong();
                System.out.printf("Converted number from %d is %#x%n",numb,numb);
                break;

            default:
                System.out.println("There is no such an option");
                break;
        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("This conversion program is only up to 64bits!");
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Hexadecimal");
        try {

            switchMenu(input.nextInt());


        }catch(InputMismatchException e){
            System.out.println("Wrong input!");
        }
    }

}
