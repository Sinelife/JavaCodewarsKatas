package rank6kyu;

import java.util.*;

public class IntegerDepth {

    public static void main(String[] args) {
        IntegerDepth t = new IntegerDepth();
        System.out.println(t.computeDepth(42));
        System.out.println(t.computeDepth(1));
    }


    public int computeDepth(int n) {
        List<Integer> allDigits = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        int counter = 1;
        while (!allDigits.isEmpty()) {
            removeDigits(n, counter, allDigits);
            counter++;
        }
        return counter - 1;
    }

    private void removeDigits(int number, int counter, List<Integer> allDigits) {
        number *= counter;
        char[] chars = String.valueOf(number).toCharArray();
        for (char symbol : chars) {
            allDigits.remove(Integer.valueOf(Character.getNumericValue(symbol)));
        }
    }
}
