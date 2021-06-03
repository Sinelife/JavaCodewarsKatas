package rank6kyu;

import java.util.*;

public class _NumberZooPatrol {
    public static void main(String[] args) {
        System.out.println(findMissingNumber2(new int[]{1, 2, 3, 4, 5, 7, 12, 8, 9, 10, 11, 13}));
    }







    public static int findMissingNumber2(int[] numbers) {
        String res = "";
        for (int number : numbers) {
            res += number + ",";
        }
        System.out.println(res);
        int i = 0;
        for (; i < numbers.length; i++) {
            if (!res.contains((i + 1) + ",")) {
                return i + 1;
            }
        }
        return i + 1;
    }





    public static int findMissingNumber(int[] numbers) {
        int[] numbersCopy = new int[numbers.length];
        System.arraycopy(numbers, 0, numbersCopy, 0, numbers.length);
        Arrays.sort(numbersCopy);
        System.out.println(Arrays.toString(numbers));
        int i = 0;
        for (; i < numbers.length; i++) {
            if (numbersCopy[i] != i + 1) {
                return i + 1;
            }
        }
        return i + 1;
    }

    private static List<Integer> getNumberList(int[] numbers) {
        List<Integer> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(number);
        }
        return numberList;
    }
}
