package rank6kyu;

import java.util.*;

public class NumericalsOfString {
    public static void main(String[] args) {

    }


    public static String numericals(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for (char symbol : s.toCharArray()) {
            if (map.containsKey(symbol)) {
                int newValue = map.get(symbol) + 1;
                res.append(newValue);
                map.put(symbol, newValue);
            } else {
                map.put(symbol, 1);
                res.append("1");
            }
        }
        return res.toString();
    }
}
