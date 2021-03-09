package challenges.chall_14;

import java.util.Scanner;

public class MagicEightBall {

    /**
     * Show description at start
     */
    private void entranceDesc() {
        System.out.println("\tWelcome in Magic 8-Ball fortune teller!");
        System.out.println("**Ask any question and see what awaits you**");
        System.out.println("");
    }

    /**
     * Ask user to provide question
     */
    private void question() {
        Scanner in = new Scanner(System.in);
        System.out.print("Your question: ");
        in.nextLine();
    }

    /**
     * Make simple animation and show an answer
     *
     * @param answer    The string from other class
     * @throws InterruptedException     Throw Exception
     */
    private void simpleAnimationWithAnswer(String answer) throws InterruptedException {
        String text = "Shaking...";
        for(int i = 0; i < 3; ++i) {
            Thread.sleep(1500);
            System.out.printf("%s ", text);
        }
        System.out.println("\n\t\t\t" + answer);
    }
}
