package challenges.calcAgeInSec;
import convert.numbers.ConvertSuffixes;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Calendar;

public class CalculateAge {

    //if true, it's a leap year
    protected static boolean isLeapYear(long yearOfBirth){
        if((yearOfBirth % 4) == 0 && (yearOfBirth % 100) != 0)
            return true;

        else if((yearOfBirth % 4) == 0 && (yearOfBirth % 100) == 0 && (yearOfBirth % 400) == 0)
            return true;

        else return false;
    }

    protected static long summarizeAge(long yearOfBirth, long actualYear){

        long countLeapYear = 0;
        long countNormalYear = 0;
        final int normalYearSeconds = 31536000;
        final int leapYearSeconds = 31622400;

        for(long i = yearOfBirth ;i < actualYear; i++){
            if(isLeapYear(i)) countLeapYear++;
            else countNormalYear++;
        }
        return (countNormalYear * normalYearSeconds) + (countLeapYear * leapYearSeconds);
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Scanner input = new Scanner(System.in);

        long year = cal.get(Calendar.YEAR);

        System.out.print("How old are you: ");
        try {

            long providedAge = input.nextLong();

            if(providedAge > 122)
                System.out.println("You're the oldest human on earth. You should get Guinness World Record");

            else if(providedAge <= 0)
                System.out.println("Your age have to be at least 1 year!");

            else {
                long yearOfBirth = year - providedAge;

                long ageInSeconds = summarizeAge(yearOfBirth, year);

                System.out.println("You've lived for " + ConvertSuffixes.format(ageInSeconds) + " seconds");
            }

        }catch(InputMismatchException e){
            System.out.println(e + " - wrong input");
        }




    }


}
