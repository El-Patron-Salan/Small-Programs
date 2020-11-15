package challenges.chall_00;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ImportingFemaleNames {


    public void getFemaleNames()throws NullPointerException, FileNotFoundException {

        Random rand = new Random();
        Scanner scanner = new Scanner(new File("/home/alan/Desktop/chall_names/namesFemale"));

        ArrayList <String> nameFemaleList = new ArrayList<>();

        while(scanner.hasNext()) {
            nameFemaleList.add(scanner.next());
        }
        scanner.close();
//        System.out.println(nameFemaleList);
//        System.out.println(nameFemaleList.size());

        //take random name from arrayList
        int index = rand.nextInt(nameFemaleList.size());
//        System.out.println(index);
        System.out.println(nameFemaleList.get(index));

    }


}
