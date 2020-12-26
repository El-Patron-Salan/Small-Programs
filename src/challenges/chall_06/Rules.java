package challenges.chall_06;

class Rules {
    static final int ROCK = 1;
    static final int PAPER= 2;
    static final int SCISSORS = 3;
    static final int LIZARD = 4;
    static final int SPOCK = 5;

    static void show(String name, int input){

        switch(input){

            case Rules.ROCK:
                System.out.println(name + " picked ROCK");
                break;
            case Rules.PAPER:
                System.out.println(name + " picked PAPER");
                break;
            case Rules.SCISSORS:
                System.out.println(name + " picked SCISSORS");
                break;
            case Rules.LIZARD:
                System.out.println(name + " picked LIZARD");
                break;
            case Rules.SPOCK:
                System.out.println(name + " picked SPOCK");
                break;
            default:
                break;
        }
    }
    static int whoWins(int user, int computer){
        if(user == computer) return 0;

        switch(user){
            case ROCK:
                return((computer == SCISSORS) || (computer ==  LIZARD) ? 1 : -1);
            case PAPER:
                return((computer == ROCK) || (computer == SPOCK) ? 1 : -1);
            case SCISSORS:
                return((computer == PAPER) || (computer == LIZARD) ? 1 : -1);
            case LIZARD:
                return((computer == PAPER) || (computer == SPOCK) ? 1 : -1);
            case SPOCK:
                return((computer == ROCK) || (computer == SCISSORS) ? 1 : -1);
        }
        return 0;
    }
}
