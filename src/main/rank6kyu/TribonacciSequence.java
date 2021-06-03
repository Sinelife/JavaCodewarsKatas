package rank6kyu;

import java.util.Arrays;

public class TribonacciSequence {

    public static void main(String[] args) {
        TribonacciSequence t = new TribonacciSequence();
        System.out.println(Arrays.toString(t.tribonacci(new double[]{1, 1, 1}, 10)));
        System.out.println(Arrays.toString(t.tribonacci(new double[]{0, 0, 1}, 10)));
        System.out.println(Arrays.toString(t.tribonacci(new double[]{0, 1, 1}, 10)));
    }


    public double[] tribonacci(double[] array, int n) {
        double[] result = new double[n];
        if (n > 3) {
            System.arraycopy(array, 0, result, 0, array.length);
        } else {
            System.arraycopy(array, 0, result, 0, n);
        }
        for (int i = array.length; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2] + result[i - 3];
        }
        return result;
    }
}
