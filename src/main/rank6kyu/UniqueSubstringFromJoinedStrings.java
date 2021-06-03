package rank6kyu;

import java.util.*;

public class UniqueSubstringFromJoinedStrings {
    public static void main(String[] args) {
        //System.out.println(longestSubstring("preface", "singularity"));
        System.out.println(longestSubstring("8684Hh", "7575H--8---"));
    }

    static int longestSubstring(String a, String b){
        List<Character> uniqueList = getUniqueSymbolsOfBothStrings(a, b);
        if (error(a, b, uniqueList)) {
            return -1;
        }
        List<String> listOfWords = new ArrayList<>();
        addAllWords(a, b, listOfWords, uniqueList);
        addAllWords(b, a, listOfWords, uniqueList);
        return getMaxLengthOfSubstring(listOfWords);
    }

    private static boolean error(String a, String b, List<Character> uniqueList) {
        return uniqueList.isEmpty();
    }

    private static void addAllWords(String a, String b, List<String> listOfWords, List<Character> uniqueList) {
        char[] chars = (a + b).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String word = "";
            for (int j = i; j < chars.length; j++) {
                if (uniqueList.contains(chars[j])) {
                    word += chars[j];
                } else {
                    break;
                }
                listOfWords.add(word);
            }
        }
    }

    private static int getMaxLengthOfSubstring(List<String> listOfWords) {
        int max = listOfWords.get(0).length();
        for (String word : listOfWords) {
            if (word.length() > max) {
                max = word.length();
            }
        }
        return max;
    }


    private static List<Character> getUniqueSymbolsOfBothStrings(String a, String b) {
        List<Character> list = new ArrayList<>();
        addSymbols(a, b, list);
        addSymbols(b, a, list);
        return list;
    }

    private static void addSymbols(String a, String b, List<Character> list) {
        char[] chars = a.toCharArray();
        for (char symbol : chars) {
            if (!b.contains(String.valueOf(symbol))) {
                list.add(symbol);
            }
        }
    }
}
