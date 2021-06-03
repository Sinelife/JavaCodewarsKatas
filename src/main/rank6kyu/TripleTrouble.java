package rank6kyu;

import java.util.*;

public class TripleTrouble {

    public static void main(String[] args) {
        System.out.println(TripleDouble(12345L, 12345L));
    }



    public static int TripleDouble(long num1, long num2) {
        if(listsAreEquals(getListOfTriples(num1), getListOfDoubles(num2))
                && listsAreEquals(getListOfDoubles(num1), getListOfTriples(num2))
                && !(num1 == num2)) {
            return 1;
        }
        return 0;
    }


    private static boolean listsAreEquals(List<Character> list1, List<Character> list2) {
        for (Character symbol : list1) {
            if (!list2.contains(symbol)) {
                return false;
            }
        }
        return true;
    }

    private static List<Character> getListOfTriples(long num1) {
        return getListOfNEntries(num1, 3);
    }

    private static List<Character> getListOfDoubles(long num1) {
        return getListOfNEntries(num1, 2);
    }

    private static List<Character> getListOfNEntries(long num, int n) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = String.valueOf(num).toCharArray();
        for (char symbol : chars) {
            if (map.containsKey(symbol)) {
                int newValue = map.get(symbol) + 1;
                map.put(symbol, newValue);
            } else {
                map.put(symbol, 1);
            }
        }
        return getResultList(map, n);
    }

    private static List<Character>getResultList(Map<Character, Integer> map, int n) {
        List<Character> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) {
                list.add(entry.getKey());
            }
        }
        System.out.println("N = " + n + "  " + list);
        return list;
    }

}
