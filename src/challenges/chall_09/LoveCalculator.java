package challenges.chall_09;

public class LoveCalculator {

    public static void main(String[] args) {
        System.out.println("\t\tProvide two names to calculate their love");
        int chance = Driver.calculator();
        System.out.println("Your fit love is " + chance + "%");
    }

}
