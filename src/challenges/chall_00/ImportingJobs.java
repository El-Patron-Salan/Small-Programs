package challenges.chall_00;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class ImportingJobs{


    public void getJobs()throws NullPointerException, FileNotFoundException {

        ArrayList <String> nameList = new ArrayList<>();
        Scanner scanner = new Scanner(new File("/home/alan/Desktop/chall_names/jobNamesList"));

        while(scanner.hasNextLine()) {
            nameList.add(scanner.nextLine());
        }
        scanner.close();
        //System.out.println(nameList);
        //System.out.println(nameList.size());
        Random rand = new Random();
        //take random name from arrayList

        System.out.println("Jobs: " + nameList.get(rand.nextInt(nameList.size())) +
                ", " + nameList.get(rand.nextInt(nameList.size())) +
                ", " + nameList.get(rand.nextInt(nameList.size())) +
                ", " + nameList.get(rand.nextInt(nameList.size())));

    }


}
