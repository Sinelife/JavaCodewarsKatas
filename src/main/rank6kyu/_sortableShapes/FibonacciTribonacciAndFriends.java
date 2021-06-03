package rank6kyu._sortableShapes;

import java.util.Arrays;

public class FibonacciTribonacciAndFriends {

    public static void main(String[] args) {
        FibonacciTribonacciAndFriends f = new FibonacciTribonacciAndFriends();

        System.out.println(Arrays.toString(f.xbonacci(new double[]{0, 1}, 10)));
    }


    public double[] xbonacci(double[] array, int n) {
        double[] result = new double[n];
        if (n > array.length) {
            System.arraycopy(array, 0, result, 0, array.length);
        } else {
            System.arraycopy(array, 0, result, 0, n);
        }
        for (int i = array.length; i < n; i++) {
            result[i] = 0;
            for (int j = i - 1; j >= i - array.length; j--) {
                result[i] += result[j];
            }
        }
        return result;
    }
}
