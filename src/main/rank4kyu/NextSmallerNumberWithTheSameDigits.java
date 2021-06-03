package rank4kyu;


import java.util.ArrayList;
import java.util.List;

public class NextSmallerNumberWithTheSameDigits {

    public static void main(String[] args) {
        Long l = new Long("100012");
        System.out.println(nextSmaller(l));
    }

    public static long nextSmaller(long number) {
        System.out.println(number);
        if (numberNotHaveSmaller(number)) {
            return -1;
        }
        if (smallerNumberTooFar(number)) {
            return getSmallerNumber(number);
        }
        for (long i = number - 1; i > getEndNumber(number); i--) {
            if (numberIsValid(i, number)) {
                return i;
            }
        }
        return -1;
    }

    private static long getSmallerNumber(long number) {
        List<Character> digits = getDigitsFromNumber(number);
        char symbol = getNextSymbolAfterThis(digits.get(0), digits);
        Long smallerNumber = Long.valueOf(symbol + getPartOfNumber(digits, symbol));
        if (String.valueOf(smallerNumber).length() < String.valueOf(number).length()) {
            return -1;
        } else {
            return smallerNumber;
        }
    }

    private static String getPartOfNumber(List<Character> digits, char symbol) {
        int index = digits.indexOf(symbol);
        char temp = digits.get(0);
        digits.set(0, symbol);
        digits.set(index, temp);

        digits.remove(0);
        digits.sort((o1, o2) -> o2 - o1);
        String res = "";
        for (Character digit : digits) {
            res += digit;
        }
        return res;
    }

    private static char getNextSymbolAfterThis(Character character, List<Character> digits) {
        int i = 1;
        while (i < 9) {
            for (Character digit : digits) {
                if (digit.equals((char) (character - i))) {
                    return digit;
                }
            }
            i++;
        }
        return ' ';
    }

    private static boolean smallerNumberTooFar(long number) {
        List<Character> digits = getDigitsFromNumber(number);
        digits.remove(0);
        return isSorted(digits);
    }

    private static boolean numberNotHaveSmaller(long number) {
        return number <= 0 || isSorted(getDigitsFromNumber(number));
    }


    private static boolean isSorted(List<Character> digits) {
        int counter = 0;
        for (int i = 0; i < digits.size() - 1; i++) {
            int digit1 = Integer.valueOf(String.valueOf(digits.get(i)));
            int digit2 = Integer.valueOf(String.valueOf(digits.get(i + 1)));
            if (digit1 <= digit2) {
                counter++;
            }
        }
        return counter == digits.size() - 1;
    }


    private static int getEndNumber(long number) {
        return (int) Math.pow(10, getRank(number) - 1);
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
