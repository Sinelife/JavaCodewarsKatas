package rank7kyu;

import java.util.Arrays;
import java.util.List;

public class ChangingLetters {

    private static List<Character> vowels = Arrays.asList('a', 'u', 'e', 'i', 'o');

    public static void main(String[] args) {

    }

    public static String swap(String str){
        char[] chars = str.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(chars[i])) {
                res += String.valueOf(chars[i]).toUpperCase();
            } else {
                res += chars[i];
            }
        }
        return res;
    }
}
