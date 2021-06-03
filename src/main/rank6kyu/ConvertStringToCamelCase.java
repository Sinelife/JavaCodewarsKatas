package rank6kyu;

import java.util.Arrays;

public class ConvertStringToCamelCase {

    public static void main(String[] args) {
        System.out.println(toCamelCase("the-Stealth-Warrior"));
        System.out.println(toCamelCase("the_Stealth_Warrior"));
    }


    static String toCamelCase(String str) {
        String[] words = str.split("[-_]");
        String res = words[0];
        for (int i = 1; i < words.length; i++) {
            res += getWordFromCapitalLetter(words[i]);
        }
        return res;
    }

    private static String getWordFromCapitalLetter(String word) {
        char[] chars = word.toCharArray();
        String res = String.valueOf(chars[0]).toUpperCase();
        for (int i = 1; i < chars.length; i++) {
            res += chars[i];
        }
        return res;
    }
}
