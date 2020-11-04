package challenges.generator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class ImportingCredentials {


    public void getCredentials() throws NullPointerException, FileNotFoundException {

        ArrayList<String> nameList = new ArrayList<>();
        Scanner scanner = new Scanner(new File("/home/alan/Desktop/chall_names/credentials"));

        while (scanner.hasNextLine()) {
            nameList.add(scanner.nextLine());
        }
        scanner.close();
        //System.out.println(nameList);
        //System.out.println(nameList.size());

        Random rand = new Random();
        //take 3 random credentials from arrayList

        System.out.println("\nCredentials: " + nameList.get(rand.nextInt(nameList.size())) + ", " +
                nameList.get(rand.nextInt(nameList.size())) + ", " +
                nameList.get(rand.nextInt(nameList.size())));
    }
}