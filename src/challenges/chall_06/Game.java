package challenges.chall_06;

public class Game {
    //instance variables declaration
    private User user = new User();;
    private Computer computer = new Computer();
    //scores
    private int userScore = 0;
    private int computerScore = 0;
    private int gamesCounter = 0;

    public Game(){}

    public static void main(String[] args){
        Game g = new Game();
        g.askUserName();
        g.game();
    }

    public void game(){
        //takes input
        int playerInput = user.userChoice();
        Rules.show(userName(), playerInput);
        //computer input
        int computerInput = computer.getCompInput();
        Rules.show("Computer", computerInput);

        int compare = Rules.whoWins(playerInput, computerInput);
        switch (compare){
            case 0:
                System.out.println("It's a TIE!");
                break;
            case 1:
                System.out.println("Player WINS");
                userScore++;
                break;
            case -1:
                System.out.println("Computer WINS");
                computerScore++;
                break;
        }
        gamesCounter++;

        if(userScore == 5){
            System.out.println("You've won the game!");
            new Game();
        }
        if(computerScore == 5){
            System.out.println("Computer's beaten you!");
            new Game();
        }
        //another game
        if(user.playAgain() == 'Y') {
            System.out.println();
            game();
        }
        else
            printStatistics();
    }
    public void askUserName(){
        user.askName();
    }
    public String userName(){
        return user.getName();
    }
    public void printStatistics(){
        System.out.println("Number of games: " + gamesCounter);
        System.out.println(userName() + " score:" + userScore);
        System.out.println("Computer score: " + computerScore);
    }
}
