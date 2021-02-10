package challenges.chall_09;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    private Driver(){}
    private final static char[] mustHaveWord = "LOVES".toCharArray();
    private static Scanner input = new Scanner(System.in);

    private static String firstName() {
        System.out.println("First name to calculate: ");
        return input.nextLine();
    }
    private static String secondName() {
        System.out.println("Second name to calculate: ");
        return input.nextLine();
    }

    private static char[] changeNameToArray(String name) {
        return name.toUpperCase().toCharArray();
    }

    private static char[] mergeArrays(char[] firstName, char[] word, char[] secondName) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName);
        sb.append(word);
        sb.append(secondName);
        return sb.toString().toCharArray();
    }

    private static ArrayList<Integer> countOccurrenceOfLetters(char[] mergedArray) {
        ArrayList<Integer> count = new ArrayList<>();
        int len = mergedArray.length;
        //array to store frequencies of each letter
        int[] freq = new int[len];
        int visited = -1;
        for(int i = 0; i < len; i++) {
            int found = 1;
            //check every element after element [i] points to
            for(int j = i + 1; j < len; j++) {
                if(mergedArray[i] == mergedArray[j]) {
                    found++;
                    freq[j] = visited;
                }
            }
            if(freq[i] != visited) {
                freq[i] = found;
                count.add(freq[i]);
            }
        }
        return count;
    }
    static void show(ArrayList<Integer> list) {
        System.out.println("List = " + list);
        System.out.println("List size = " + list.size());
        System.out.println("Index of 2 = " + list.indexOf(2));

        for (Integer integer : list) {
            System.out.println("\nPrint value = " + integer);
        }
    }

    static int sumElements(int firstElement, int secondElement) {
        return firstElement + secondElement;
    }

    public static void calculateLoveChance(ArrayList<Integer> list) {
        //while(!(list.size() <= 3)) { }

        ArrayList<Integer> tempList = new ArrayList<>();
        for(int i = list.size(); !(i <= 3); i--) {
            int midElement = 0;
            for(int j = 0; j < list.size() / 2; j++) {
                midElement = (list.size() / 2) -1;
                tempList.add(sumElements(list.get(j), (list.get(list.size() - 1 - j))));
            }
            if(list.size() % 2 != 0) tempList.add(tempList.size() - 1, list.get(midElement));
            //replace elements in list with tempList
            list.clear();
            list.addAll(tempList);
            tempList.clear();
        }
    }

}
