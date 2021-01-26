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

    public static ArrayList<Integer> countOccurrenceOfLetters(char[] mergedArray) {
        ArrayList<Integer> count = new ArrayList<>();
        int len = mergedArray.length;
        int[] freq = new int[len];
        int visited = -1;
        for(int i = 0; i < len; i++) {
            int found = 1;
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

}
