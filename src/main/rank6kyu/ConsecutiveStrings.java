package rank6kyu;

import java.util.*;

public class ConsecutiveStrings {

    public static void main(String[] args) {
        System.out.println(longestConsec(new String[]{"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 3));
    }




    public static String longestConsec(String[] strarr, int k) {
        if(strarr == null || strarr.length == 0 || k > strarr.length) {
            return "";
        }
        return getMaxListWord(getResultWordList(strarr, k));
    }

    private static String getMaxListWord(List<String> list) {
        String maxWord = list.get(0);
        for (String word : list) {
            if (maxWord.length() < word.length()) {
                maxWord = word;
            }
        }
        return maxWord;
    }

    private static List<String> getResultWordList(String[] strarr, int k) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strarr.length + 1 - k; i++) {
            String resWord = "";
            for (int j = 0; j < k; j++) {
                resWord += strarr[j + i];
            }
            list.add(resWord);
        }
        return list;
    }


//    public static String longestConsec(String[] strarr, int k) {
//        if (strarr.length == 0 || k <= 0 || k > strarr.length) {
//            return "";
//        }
//        return getResultWord(strarr, k);
//    }
//
//
//
//    private static String getResultWord(String[] strarr, int k) {
//        List<String> list = getBigWords(strarr, k);
//        String result = "";
//        for (String word : strarr) {
//            if(list.contains(word)) {
//                result += word;
//                list.remove(word);
//            }
//        }
//        System.out.println(result);
//        return result;
//    }
//
//    private static List<String> getBigWords(String[] strarr, int k) {
//        List<String> words = getListOfUniqueWords(strarr);
//        Collections.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() < o2.length()) {
//                    return 1;
//                } else if (o1.length() > o2.length()) {
//                    return -1;
//                }
//                return o2.compareTo(o1);
//            }
//        });
//        List<String> bigWords = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            bigWords.add(words.get(i));
//        }
//        return bigWords;
//    }
//
//    private static List<String> getListOfUniqueWords(String[] strarr) {
//        Set<String> set = new HashSet<>();
//        Collections.addAll(set, strarr);
//        return new ArrayList<>(set);
//    }

}
