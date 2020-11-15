package challenges.chall_00;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class ImportingMaleNames {


    public void getMaleNames()throws NullPointerException, FileNotFoundException {

        ArrayList <String> nameList = new ArrayList<>();
        Scanner scanner = new Scanner(new File("/home/alan/Desktop/chall_names/namesMale"));

        while(scanner.hasNext()) {
            nameList.add(scanner.next());
        }
        scanner.close();
        //System.out.println(nameList);
        //System.out.println(nameList.size());

        Random rand = new Random();
        //take random name from arrayList

        int index = rand.nextInt(nameList.size());

        System.out.println(nameList.get(index));

    }
    

}
