package rank6kyu;

import java.util.*;

public class ReverseOrRotate {

    public static void main(String[] args) {
        System.out.println(revRot("123456987654", 6));
    }


    public static String revRot(String str, int n) {
        if (str == null || str.length() < n || n == 0) {
            return "";
        }
        List<String> list = getPartsOfString(str, n);
        String res = "";
        for (String number : list) {
            res += getCorrectPartOfString(number);
        }
        return res;
    }

    private static String getCorrectPartOfString(String number) {
        return sumOfDigitCubesIsEven(number) ? getInversedWord(number) : getMovedInLeftWord(number);
    }

    private static String getMovedInLeftWord(String number) {
        char[] chars = number.toCharArray();
        String res = "";
        for (int i = 1; i < chars.length; i++) {
            res += chars[i];
        }
        return res + chars[0];
    }

    private static String getInversedWord(String number) {
        char[] chars = number.toCharArray();
        String res = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            res += chars[i];
        }
        return res;
    }

    private static boolean sumOfDigitCubesIsEven(String number) {
        char[] chars = number.toCharArray();
        int sum = 0;
        for (char symbol : chars) {
            int n = Integer.valueOf(String.valueOf(symbol));
            sum += Math.pow(n, 3);
        }
        return sum % 2 == 0;
    }

    private static List<String> getPartsOfString(String str, int n) {
        List<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        String number = "";
        for (char symbol : chars) {
            if (number.length() == n) {
                list.add(number);
                number = "";
            }
            number += symbol;
        }
        if (number.length() == n) {
            list.add(number);
        }
        return list;
    }
}
