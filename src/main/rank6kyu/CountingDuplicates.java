package rank6kyu;

import java.util.*;

public class CountingDuplicates {

    public static void main(String[] args) {
        System.out.println(duplicateCount("dAccccccccccbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
    }


    public static int duplicateCount(String text) {
        System.out.println(text);
        Map<Character, Integer> map = getMapOfCharsInText(text);
        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            res += entry.getValue();
        }
        return res;
    }

    private static Map<Character, Integer> getMapOfCharsInText(String text) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = text.toLowerCase().toCharArray();
        for (char symbol : chars) {
            if (map.containsKey(symbol)) {
                map.put(symbol, 1);
            } else {
                map.put(symbol, 0);
            }
        }
        return map;
    }


}
