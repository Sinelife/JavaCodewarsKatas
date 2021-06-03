package rank6kyu;

import java.util.Arrays;

public class ArrayCropper {

    public static void main(String[] args) {
        int[][] example = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0}};
        System.out.println(Arrays.deepToString(getCroppedFieldAsArray(example)));
    }



    public static int[][] getCroppedFieldAsArray(int[][] arrays) {
        System.out.println(Arrays.deepToString(arrays));
        int maxX = getMax(arrays, "X");
        int minX = getMin(arrays, "X");
        int maxY = getMax(arrays, "Y");
        int minY = getMin(arrays, "Y");
        System.out.println("MaxX: " + maxX + "  MinX: " + minX);
        System.out.println("MaxY: " + maxY + "  MinY: " + minY);

        int[][] result = new int[maxY - minY + 1][maxX - minX + 1];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = arrays[minY + i][minX + j];
            }
        }
        return result;
    }

    private static int getMax(int[][] arrays, String str) {
        int max = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                if (str.equals("X")) {
                     if (arrays[j][i] != 0) {
                        max = i;
                    }
                } else {
                    if (arrays[i][j] != 0) {
                        max = i;
                    }
                }
            }
        }
        return max;
    }


    private static int getMin(int[][] arrays, String str) {
        int min = 0;
        for (int i = arrays.length - 1; i >= 0; i--) {
            for (int j = arrays[0].length - 1; j >= 0; j--) {
                if (str.equals("X")) {
                    if (arrays[j][i] != 0) {
                        min = i;
                    }
                } else {
                    if (arrays[i][j] != 0) {
                        min = i;
                    }
                }
            }
        }
        return min;
    }

//    private static int getMaxY(int[][] arrays) {
//        int maxY = 0;
//        for (int i = 0; i < arrays.length; i++) {
//            for (int j = 0; j < arrays[0].length; j++) {
//                if (arrays[i][j] != 0) {
//                    maxY = i;
//                }
//            }
//        }
//        return maxY;
//    }

}
