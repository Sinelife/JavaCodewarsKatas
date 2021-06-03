package rank6kyu;

import java.util.*;

public class PascalsTriangle2 {

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.deepToString(pascal(i)));
        }
    }


    public static int[][] pascal(int depth) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            result.add(getNextLevelOfPascalTriangle(result));
        }
        return result.toArray(new int[0][]);
    }

    private static int[] getNextLevelOfPascalTriangle(List<int[]> result) {
        if (result.isEmpty()) {
            return new int[]{1};
        }
        int[] oldArray = result.get(result.size() - 1);
        int[] newArray = new int[oldArray.length + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = (i == 0 || i == newArray.length - 1) ? 1 : oldArray[i - 1] + oldArray[i];
        }
        return newArray;
    }
}
