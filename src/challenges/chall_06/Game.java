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
            case 1:
                System.out.println("Player WINS");
                userScore++;
            case -1:
                System.out.println("Computer WINS");
                computerScore++;
        }
        gamesCounter++;

    }
    public void askUserName(){
        user.askName();
    }
    public String userName(){
        return user.getName();
    }
}
