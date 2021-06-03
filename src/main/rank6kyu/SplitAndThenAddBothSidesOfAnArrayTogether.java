package rank6kyu;

import java.util.*;

public class SplitAndThenAddBothSidesOfAnArrayTogether {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(splitAndAdd(new int[]{1, 2, 3, 4, 5}, 2)));
    }



    public static int[] splitAndAdd(int[] numbers, int n) {
        for (int i = 0; i < n; i++) {
            int[] a = getFirstPartOfArray(numbers);
            int[] b = getSecondPartOfArray(numbers);
            numbers = getColumnSumOfArrays(a, b);
            System.out.println("a: " + Arrays.toString(a));
            System.out.println("b: " + Arrays.toString(b));
            System.out.println("R: " + Arrays.toString(numbers) + "\n\n");
        }
        return numbers;
    }

    private static int[] getFirstPartOfArray(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length / 2; i++) {
            list.add(numbers[i]);
        }
        return list.stream().mapToInt(elem -> elem).toArray();
    }

    private static int[] getSecondPartOfArray(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = numbers.length / 2; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        return list.stream().mapToInt(elem -> elem).toArray();
    }


    public static int[] getColumnSumOfArrays(int[] a, int[] b) {
        return a.length <= b.length ? columnSum(a, b) : columnSum(b, a);
    }

    private static int[] columnSum(int[] a, int[] b) {
        int[] result = new int[b.length];
        for (int i = 0; i < a.length; i++) {
            result[b.length - 1 - i] = a[a.length - 1 - i] + b[b.length - 1 - i];
        }
        if (a.length != b.length) {
            result[0] = b[0];
        }
        return result;
    }
}
