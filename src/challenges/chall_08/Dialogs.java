package challenges.chall_08;

public class Dialogs {

    public static void descriptionOfGame(){

        System.out.println("\t\t\tHello in HANGMAN game! :D");
        System.out.println("\t\tThere are two game options:" +
                "\n1. Computer picks a random word and you've to guess it" +
                "\n2. You or your friends input word and the other person tries to guess it");
        System.out.println("\tThe rules are quite simple:" +
                "\n~ you've 7 lives(number of tries)" +
                "\n~ you can provide only characters" +
                "\n~ the word to guess is only one word - it doesn't have any space between" +
                "\n~ when little man is doomed YOU LOSE" +
                "\n~ when little man escapes YOU WIN" +
                "\n\t\t That's all - Have Fun and enjoy the game;))");

    }

}
