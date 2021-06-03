package rank6kyu;

import java.util.*;
import java.util.stream.IntStream;

public class MatrixAddition {

    public static void main(String[] args) {

    }

    public static int[][] matrixAddition(int[][] a, int[][] b) {
        IntStream.range(0, a.length)
                .forEach(i -> Arrays.
                        parallelSetAll(a[i], j -> a[i][j] + b[i][j]));
        return a;
    }
}
