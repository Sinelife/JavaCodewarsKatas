package rank4kyu;

import java.util.*;

public class HammingNumbers {

    public static void main(String[] args) {
        System.out.println(hamming(1));

    }

    public static long hamming(int n) {
        SortedSet<Long> set = new TreeSet<>();
        set.add((long) 1);
        long currentElem;
        for (int i = 0; i < n - 1; ++i) {
            currentElem = set.first();
            set.addAll(Arrays.asList(currentElem * 2, currentElem * 3, currentElem * 5));
            set.remove(currentElem);
        }
        return set.first();
    }


//    public static long hamming(int n) {
//        System.out.println(n);
//        List<Long> list = new ArrayList<>();
//        int counter = 0;
//        long i = 1;
//        while (counter < n) {
//            if (numberIsValid(i)) {
//                counter++;
//                list.add(i);
//            }
//            i++;
//        }
//        System.out.println(list);
//        return list.get(n - 1);
//    }
//
//    private static boolean numberIsValid(long i) {
//        while (i > 1) {
//            if (i % 2 == 0) {
//                i /= 2;
//            } else if (i % 3 == 0) {
//                i /= 3;
//            } else if (i % 5 == 0) {
//                i /= 5;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
}
