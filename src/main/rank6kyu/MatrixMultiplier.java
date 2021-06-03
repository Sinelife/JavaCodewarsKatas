package rank6kyu;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixMultiplier {

    public static double[][] getMatrixProduct(double[][] a, double[][] b) {
        return Arrays.stream(a)
                .map(r -> IntStream
                .range(0, b[0].length)
                        .mapToDouble(i -> IntStream.range(0, b.length)
                                .mapToDouble(j -> r[j] * b[j][i])
                                .sum())
                        .toArray())
                .toArray(double[][]::new);
    }

    public static double[][] getMatrixProduct2(double[][] a, double[][] b) {
        if (a == null || b == null || a[0].length != b.length) {
            return null;
        }
        double[][] resultMatrix = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    resultMatrix[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return resultMatrix;
    }


}
