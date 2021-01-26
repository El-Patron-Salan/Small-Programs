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

    private static int calculateLoveChance(ArrayList<Integer> list) {
        int i = 0, finalNumber;
        while(list.size() != 1) {
            int sum = 0;
            //sum to the point when indexes are the same, then loop again
            int firstElementIndex = list.indexOf(i);
            int lastElementIndex = list.indexOf(list.size() - 1);

            if(firstElementIndex != lastElementIndex) {
                sum = list.get(i) + list.get(list.size() - 1);
                i++;
                list.remove(firstElementIndex);
                list.remove(lastElementIndex);
                list.add(sum);
            }
            else
                list.add(list.get(i));
        }
        return finalNumber = list.get(0);
    }

}
