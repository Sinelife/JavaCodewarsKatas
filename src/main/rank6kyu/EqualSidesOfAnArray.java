package rank6kyu;

public class EqualSidesOfAnArray {

    public static void main(String[] args) {
        System.out.println(findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));
    }


    public static int findEvenIndex(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (sumArray(arr, 0, i - 1) == sumArray(arr, i + 1, arr.length - 1)) {
                return i;
            }
        }
        return -1;
    }

    private static int sumArray(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
