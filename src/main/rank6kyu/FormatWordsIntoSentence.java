package rank6kyu;

import java.util.*;

public class FormatWordsIntoSentence {

    public static void main(String[] args) {
        System.out.println(formatWords(new String[]{"", "one", "", "sd"}));
    }


        public static String formatWords(String[] words) {
            if (words == null) {
                return "";
            }
            words = String.join(" ", words).trim().split("\\s+");
            String res = "";
            for (int i = 0; i < words.length; i++) {
                res += (i == words.length - 1) ? words[i] : ((i == words.length - 2) ? words[i] + " and " : words[i] + ", ");
            }
            return words.length == 0 ? "" : res;
        }

}

