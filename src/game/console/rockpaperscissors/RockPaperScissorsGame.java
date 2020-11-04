/*
TODO - add rounds follower e.g 2 vs 1
TODO - improve this program (BEATING CLASS IS TERRIBLE)!
 */
package game.console.rockpaperscissors;

class RockPaperScissorsGame {

    //printing some information about game
    public static void infoAbout(){
        System.out.println("Hello in Rock Paper Scissors game");
        System.out.println("Game contains 3 rounds and you'll have 3 seconds to declare your choice");
        System.out.println("You can enter following commands :\nR - rock\nP - paper\nS - scissors");
        System.out.println("If you won't enter anything or enter something wrong round will be lost!\n");
    }


    public static void main(String[] args) {
        infoAbout();

        //computer random choice
        Computer comp = new Computer();
        User user = new User();
        //tells who won
        Beating whatBeats = new Beating();
        //make 3 rounds
        for(int i = 1; i <= 3; i++) {
            System.out.println("*****************************************");
            System.out.println("\nRound " + i);

            //TODO - make thread to count to three after that if user won't make input ,round will be lost for him
            System.out.println("Give your choice:");
            //user input
            String u = user.userChoice();
            //computer random choice
            String c = comp.compChoice();
            System.out.println("Computer gave " + c);
            //who win
            whatBeats.whoWins(u, c);
            System.out.println("\n*****************************************");
        }
    }
}
