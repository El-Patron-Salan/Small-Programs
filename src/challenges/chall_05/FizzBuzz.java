package challenges.chall_05;

public class FizzBuzz {

    public static void main(String[] args) {

        int counterFizz = 0, counterBuzz = 0,countBoth = 0;
        for(int i = 1; i <= 100; i++){

            if((i % 15) == 0) {
                System.out.println("FizzBuzz");
                countBoth++;
            }
            else if((i% 3) == 0) {
                System.out.println("Fizz");
                counterFizz++;
            }
            else if((i % 5) == 0) {
                System.out.println("Buzz");
                counterBuzz++;
            }
            else System.out.println(i);
        }
        System.out.printf("Fizz: %d\nBuzz: %d\nFizzBuzz: %d",counterFizz, counterBuzz, countBoth);
    }

}
