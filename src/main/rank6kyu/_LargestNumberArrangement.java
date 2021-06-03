package rank6kyu;

import java.util.Arrays;

public class _LargestNumberArrangement {

    public static void main(String[] args) {
        System.out.println(largestArrangement(new int[]{4, 50, 8, 145}));
    }

    public static long largestArrangement(int[] arr) {
        sort(arr);
        System.out.println(Arrays.toString(arr));
        String res = "";
        for (int num : arr) {
            res += num;
        }
        return Long.valueOf(res);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (firstIsLess(arr[j], arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static boolean firstIsLess(int a, int b) {
        int num1 = Integer.valueOf(String.valueOf(a).substring(0, 1));
        int num2 = Integer.valueOf(String.valueOf(b).substring(0, 1));
        if (num1 == num2) {

        }
        return num1 < num2;
    }

}
