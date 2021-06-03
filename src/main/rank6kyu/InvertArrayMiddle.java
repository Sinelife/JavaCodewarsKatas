package rank6kyu;

import java.util.Arrays;

public class InvertArrayMiddle {
    public static void main(String[] args) {
        InvertArrayMiddle i = new InvertArrayMiddle();
        System.out.println(Arrays.deepToString(i.invertArrayMiddle(4)));
    }

    public int[][] invertArrayMiddle(int n) {
        int[][] array = new int[n][n];
        for (int i = 0, counter = 1; i < n; i++) {
            for (int j = 0; j < n; j++, counter++) {
                array[i][j] = counter;
            }
        }
        return getInvertedArray(array);
    }


    private int[][] getInvertedArray(int[][] array) {
        int[][] result = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                result[i][j] = isBorder(array, i, j) ? array[j][i] : array[i][j];
            }
        }
        return result;
    }

    private boolean isBorder(int[][] array, int i, int j) {
        return i == 0 || j == 0 || i == array.length - 1 || j == array.length - 1;
    }
}
