package challenges.chall_07;

import java.util.LinkedList;
import java.util.Iterator;

public class EulerFirstProblem {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();int sum = 0;
        for(int i = 1; i < 1000; i++){
            if((i % 3 == 0) || (i % 5 == 0)) {
                list.add(i);
                sum += i;
            }
        }
        System.out.println("The sum is: " + sum);
//        Iterator<Integer> it = list.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        int sum = 0;
//        for(int i: list){
//            sum += i;
//        }
//        System.out.println(sum);
    }
}
