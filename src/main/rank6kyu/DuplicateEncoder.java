package rank6kyu;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("wedaafegthargtgr"));
    }


    static String encode(String word) {
        List<Character> list = word.toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        String res = "";
        for (char symbol : word.toLowerCase().toCharArray()) {
            res += Collections.frequency(list, symbol) > 1 ? ")" : "(";
        }
        return res;
    }
}
