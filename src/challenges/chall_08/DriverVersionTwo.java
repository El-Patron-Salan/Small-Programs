package challenges.chall_08;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

public class DriverVersionTwo {
    //it needs to be this way, cuz it has to handle FileNotFoundException
    private static String getRandWord;
    static{
        try{
            getRandWord = GenerateWord.getRandomWord();
        }catch(FileNotFoundException e){
            e.getStackTrace();
        }
    }
    private static final String pass = "bociany";

    DriverVersionTwo(){}

    final private static char[] wordInCharacters = pass.toCharArray();
    private static char[] inputFromUser = new char[wordInCharacters.length];
    private static int lives = 7;
    private static int count = 0;
    private static boolean presence = true;
    private static LinkedList<Character> list = new LinkedList<>();


    private static void hideWord(char[] arr, int size){
        for(int i = 0; i < size; ++i)
            arr[i] = '_';
    }

    private static void checkIfCorrect(String input, char[] hiddenArr){
        if (input.length() > 1) {
            if (input.equals(getRandWord)) {
                System.out.println("\t\tBRAWOO Agunia, odgadnelas haslo <33");
                System.out.println("Nasze piekne bocianki w afryce symbolizujace nasza milosc i sukces w zyciu :)");
                System.out.println("Wskazowka: Spojrz na tablice i znajdz niepozorny wzor");
            } else {
                System.out.println("Wrong! It isn't the correct word!\n\t\tGAME OVER!");
            }
            System.exit(0);
        }else {
            for (int i = 0; i < inputFromUser.length; ++i) {
                if (input.charAt(0) == (wordInCharacters[i])) {
                    hiddenArr[i] = input.charAt(0);
                    presence = false;
                }
            }
        }
    }
    /*
    TO-DO:
    -handle wrong input such as numbers and special characters
     */
    private static void checkIfCharacterIsInTheList(char input){
        if(!(list.contains(input)) && presence){
            list.add(input);
            System.out.println("Niestety nie :/");
            lives--;
        }
        else if(!(list.contains(input)) && !presence){
            list.add(input);
            System.out.println("Dobry strzal!");
        }
        else{
            System.out.println("This character - \"" + input + "\" has been already used!");
            System.out.println("Unfortunately you lose a life");
            lives--;
        }
    }

    private static void printUsedCharacters(int count){
        if(count > 0) {
            System.out.println("\n\nWykorzystane juz znaki:");
            System.out.println(list);
        }
    }

    private static void showHiddenWord(char[] array){
            for(var x : array){
                System.out.print(x + " ");
            }
    }

    private static boolean win(){
        return Arrays.equals(inputFromUser, wordInCharacters);
    }

    private static boolean lose(){
        return lives == 0;
    }

    public static void game(){
        Scanner input = new Scanner(System.in);
        char hint;
        //Dialogs.descriptionOfGame();
        System.out.println("\t\tOdgadnij haslo, a dostaniesz kolejna wskazowke ;)) <3");
        System.out.println();
        hideWord(inputFromUser, inputFromUser.length);

        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            AnimationOfHangman.hangmanImage(lives);
            System.out.println("\nHaslo do odgadniecia:");
            showHiddenWord(inputFromUser);
            printUsedCharacters(count);
            System.out.print("\n\nWpisz literke lub cale slowo: ");
            String guess = input.next().toLowerCase();
            checkIfCorrect(guess, inputFromUser);
            checkIfCharacterIsInTheList(guess.charAt(0));
            System.out.println("Pozostale zycia: " + lives);
            count++;
            presence = true;
            if(win()) {
                System.out.println("\t\tBRAWOO Agunia, odgadnelas haslo <33");
                System.out.println("Nasze piekne bocianki w afryce symbolizujace nasza milosc i sukces w zyciu :)");
                System.out.println("Wskazowka: Spojrz na tablice i znajdz niepozorny wzor");
                break;
            }
            else if(lose()) {
                AnimationOfHangman.hangmanImage(0);
                System.out.println("Nic sie nie stalo ;), Sprobuj jeszcze raz");
                System.out.print("Chcesz wskazowke? Wpisz y(yes) lub n(no): ");
                hint = input.next().charAt(0);
                if(hint == 'y') System.out.println("Pewne zwierzatka pijace szampana w afryce :D");
                else {
                    System.out.println("A wiec nie skracamy drogi hahah");
                }
                break;
            }
        }
    }



}
