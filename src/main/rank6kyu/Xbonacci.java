package rank6kyu;

public class Xbonacci {



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
