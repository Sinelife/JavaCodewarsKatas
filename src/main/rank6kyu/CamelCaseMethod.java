package rank6kyu;

import java.util.*;

public class CamelCaseMethod {

    public static void main(String[] args) {
        System.out.println(camelCase("  wa   rer re   erew    \n\n gtrggt\ntyty " +
                "ededd  yyyy   oop   "));
    }


    public static String camelCase(String str) {
        if (str.isEmpty()) {
            return "";
        }
        List<String> words = getWordList(str);
        for (int i = 0; i < words.size(); i++) {
            words.set(i, words.get(i).substring(0, 1).toUpperCase() + words.get(i).substring(1));
        }
        System.out.println(String.join("", words));
        return String.join("", words);
    }

    private static List<String> getWordList(String str) {
        List<String> list = new ArrayList<>();
        char[] chars = str.trim().toCharArray();
        String word = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || chars[i] == '\n') {
                list.add(word);
                word = "";
                while (chars[i] == ' ' || chars[i] == '\n') {
                    i++;
                }
            }
            word += chars[i];
        }
        list.add(word);
        return list;
    }

}
