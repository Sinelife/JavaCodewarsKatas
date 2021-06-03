package rank6kyu;

import java.util.Arrays;

public class MatrixStrings {

    private int[][] matrix;

    public MatrixStrings(String matrixAsString){
        initializeMatrix(matrixAsString);
    }


    private void initializeMatrix(String str) {
        if(str == null || str.isEmpty()) {
            matrix = new int[][]{{}};
        }
        String[] rows = str.split("\n");
        int rowNum = rows.length;
        int colNum = rows[0].split(" ").length;
        matrix = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            String[] elements = rows[i].split(" ");
            for (int j = 0; j < colNum; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }
    }


    public int[] getRow(int rowNumber){
        if (rowNumber >= matrix.length) {
            return new int[0];
        } else {
            return matrix[rowNumber];
        }
    }

    public int[] getColumn(int columnNumber){
        if(columnNumber >= matrix[0].length) {
            return new int[0];
        } else {
            return getCorrectColumn(columnNumber);
        }
    }

    private int[] getCorrectColumn(int columnNumber) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = matrix[i][columnNumber];
        }
        return result;
    }

    public int getRowsCount(){
        return matrix.length;
    }

    public int getColumnsCount(){
        return matrix[0].length;
    }


    public static void main(String[] args) {
        MatrixStrings matrix = new MatrixStrings("0 1");
        System.out.println(Arrays.deepToString(matrix.matrix));
        System.out.println(matrix.getRowsCount());

    }
}
