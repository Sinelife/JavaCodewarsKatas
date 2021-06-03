package rank4kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HowManyNumbersIII {
    public static void main(String[] args) {
        int counter = 1;
        for (int i = 0; i < 25; i++) {
            System.out.println("#" + counter++);
            System.out.println(findAll(30 + i, 7) + "\n");
        }
        for (int i = 0; i < 25; i++) {
            System.out.println("#" + counter++);
            System.out.println(findAll(40 + i, 12) + "\n");
        }
    }


    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        if (sumDigits <= 0 || numDigits <= 0) {
            return Collections.emptyList();
        }
        List<Long> numberList = getAllValidNumbers(sumDigits, numDigits);
        if (numberList.isEmpty()) {
            return Collections.emptyList();
        }
        Long first = numberList.get(0);
        Long last = numberList.get(numberList.size() - 1);
        Long amount = (long) numberList.size();
        return Arrays.asList(amount, first, last);
    }

    private static List<Long> getAllValidNumbers(int sumDigits, int numDigits) {
        List<Long> list = new ArrayList<>();
        for (long i = getStartNumber(numDigits); i < getEndNumber(numDigits); i++) {
            i = getNextNumber(numDigits, i);
            if (numberIsValid(sumDigits, i)) {
                list.add(i);
            }
        }
        return list;
    }

    private static long getNextNumber(int numDigits, long i) {
        for (int j = 0; j < numDigits - 1; j++) {
            if (numberDevideOnTenInNPow(i , numDigits - j)) {
                i = getNextCorrectNumber(numDigits, i, j);
            }
        }
        return i;
    }

    private static boolean numberDevideOnTenInNPow(long number, int numDigits) {
        return number % (long)(Math.pow(10, numDigits - 1)) == 0;
    }

    private static long getNextCorrectNumber(int numDigits, long i, int count) {
        char firstDigit = String.valueOf(i).charAt(count);
        String newI = "";
        for (int j = 0; j < count; j++) {
            newI += String.valueOf(i).charAt(j);
        }
        for (int j = 0; j < numDigits - count; j++) {
            newI += firstDigit;
        }
        return Long.valueOf(newI);
    }

    private static boolean numberIsValid(int sumDigits, long number) {
        return sumOfDigitsIsCorrect(sumDigits, number) && isSortedNumber(number);
    }

    private static boolean sumOfDigitsIsCorrect(int sumDigits, long number) {
        char[] chars = String.valueOf(number).toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            sum += getDigitFromChar(aChar);
        }
        return sum == sumDigits;
    }

    private static boolean isSortedNumber(long number) {
        char[] chars = String.valueOf(number).toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static long getDigitFromChar(char digit) {
        return Long.valueOf(String.valueOf(digit));
    }


    private static long getEndNumber(int numDigits) {
        return (long) (Math.pow(10, numDigits) - 1);
    }

    private static long getStartNumber(int numDigits) {
        return (long) Math.pow(10, numDigits - 1);
    }
}
