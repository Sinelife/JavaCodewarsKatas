package rank6kyu;


import java.util.*;

public class MissingAlphabet {

    public static void main(String[] args) {
        System.out.println(insertMissingLetters("hello"));
        System.out.println(insertMissingLetters("xpixax"));
    }



    private static Map<Character, Boolean> charMap;

    public static String insertMissingLetters(String str) {
        charMap = new HashMap<>();
        for (char symbol : str.toCharArray()) {
            charMap.put(symbol, true);
        }
        String res = "";
        for (char letter : str.toCharArray()) {
            if (charMap.get(letter)) {
                charMap.put(letter, false);
                res += getSymbolShell(letter);
            } else if (!charMap.get(letter)) {
                res += letter;
            }
        }
        return res;
    }

    private static String getSymbolShell(char letter) {
        char start = letter++;
        String res = "";
        while (letter <= 'z') {
            if (!charMap.keySet().contains(letter)) {
                res += letter;
            }
            letter++;
        }
        return start + res.toUpperCase();
    }
}
