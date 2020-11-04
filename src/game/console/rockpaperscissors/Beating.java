package game.console.rockpaperscissors;

class Beating {

    public void whoWins(String user, String comp) {

        if (user.equals(comp))
            System.out.println("It's a Tie");
        else if (user.equals("R") && comp.equals("Scissors"))
            System.out.println("You win!");
        else if (user.equals("S") && comp.equals("Paper"))
            System.out.println("You win!");
        else if (user.equals("P") && comp.equals("Rock"))
            System.out.println("You win!");

            //TIE
        else if (user.equals("P") && comp.equals("Paper"))
            System.out.println("It's a TIE!");
        else if (user.equals("R") && comp.equals("Rock"))
            System.out.println("It's a TIE!");
        else if (user.equals("S") && comp.equals("Scissors"))
            System.out.println("It's a TIE!");

            //comp beats
        else
            System.out.println("Computer wins!");

    }
}
