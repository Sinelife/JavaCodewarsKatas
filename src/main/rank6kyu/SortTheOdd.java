package rank6kyu;

import java.util.*;

public class SortTheOdd {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 3, 2, 8, 1, 4})));
    }

    public static int[] sortArray(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }
        List<Integer> oddNumbers = getOddNumbersList(array);
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = oddNumbers.get(counter++);
            }
        }
        return array;
    }

    private static List<Integer> getOddNumbersList(int[] array) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int number : array) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }
        Collections.sort(oddNumbers);
        return oddNumbers;
    }

}
