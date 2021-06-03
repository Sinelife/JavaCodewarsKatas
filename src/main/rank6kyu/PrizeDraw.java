package rank6kyu;

import java.util.*;
import java.util.stream.Collectors;

public class PrizeDraw {
    public static void main(String[] args) {
        String words = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden";
        Integer[] ranks = new Integer[] {1, 3, 5, 5, 3, 6};
        System.out.println(nthRank(words, ranks, 2));

    }





    public static String nthRank(String st, Integer[] we, int n) {
        if (st.isEmpty()) {
            return "No participants";
        }
        if (n > we.length) {
            return "Not enough participants";
        }
        String[] words = st.split(",");
        List<Map.Entry<String, Integer>> rankList = getRankMap(words, we);
        rankList.sort((o1, o2) -> (o2.getValue() - o1.getValue() != 0) ? o2.getValue() - o1.getValue() : o1.getKey().compareTo(o2.getKey()));
        return rankList.get(n - 1).getKey();
    }

    private static List<Map.Entry<String, Integer>> getRankMap(String[] words, Integer[] we) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], getWordCode(words[i]) * we[i]);
        }
        return new ArrayList<>(map.entrySet());
    }


    private static Integer getWordCode(String word) {
        int code = word.length();
        for (char symbol : word.toLowerCase().toCharArray()) {
            code += symbol - 96;
        }
        return code;
    }

}
