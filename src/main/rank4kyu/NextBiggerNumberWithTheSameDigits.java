package rank4kyu;

import java.util.ArrayList;
import java.util.List;

public class NextBiggerNumberWithTheSameDigits {
    public static void main(String[] args) {
        Long l = new Long("59884848459853");
        System.out.println(nextBiggerNumber(l));
    }

    public static long nextBiggerNumber(long number) {
        System.out.println(number);
        if (numberNotHaveBigger(number)) {
            return -1;
        }
        for (long i = number + 1; i < getEndNumber(number); i++) {
            if (numberIsValid(i, number)) {
                return i;
            }
        }
        return -1;
    }


    private static boolean numberNotHaveBigger(long number) {
        return number <= 0 || isSorted(getDigitsFromNumber(number));
    }


    private static boolean isSorted(List<Character> digits) {
        int counter = 0;
        for (int i = 0; i < digits.size() - 1; i++) {
            int digit1 = Integer.valueOf(String.valueOf(digits.get(i)));
            int digit2 = Integer.valueOf(String.valueOf(digits.get(i + 1)));
            if (digit1 >= digit2) {
                counter++;
            }
        }
        return counter == digits.size() - 1;
    }


    private static long getEndNumber(long number) {
        return (long) (Math.pow(10, getRank(number)) - 1);
    }

    private static int getRank(long number) {
        return String.valueOf(number).length();
    }


    private static boolean numberIsValid(long number, long mainNumber) {
        char[] chars = String.valueOf(number).toCharArray();
        List<Character> digitList = getDigitsFromNumber(mainNumber);
        for (char aChar : chars) {
            if (digitList.contains(aChar)) {
                digitList.remove(Character.valueOf(aChar));
            } else {
                return false;
            }
        }
        return true;
    }


    private static List<Character> getDigitsFromNumber(long number) {
        List<Character> digits = new ArrayList<>();
        char[] chars = String.valueOf(number).toCharArray();
        for (char aChar : chars) {
            digits.add(aChar);
        }
        return digits;
    }

}
