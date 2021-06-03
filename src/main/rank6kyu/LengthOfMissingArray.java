package rank6kyu;


import java.util.*;

public class LengthOfMissingArray {
    public static void main(String[] args) {
//        System.out.println(getLengthOfMissingArray(new Integer[][]{{5, 2, 9}, {4, 5, 1, 1, 5, 6}, {1, 1}, {5, 6, 7, 8, 9}}));
        System.out.println(getLengthOfMissingArray(new Integer[][]{}));
    }


    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null) {
            return 0;
        }
        List<Integer> sizes = getSizes(arrayOfArrays);
        for (int i = getMinSize(sizes); i <= sizes.size() + getMinSize(sizes) - 1; i++) {
            if (!sizes.contains(i) && !sizes.contains(0)) {
                return i;
            }
        }
        return 0;
    }

    private static List<Integer> getSizes(Object[][] arrayOfArrays) {
        List<Integer> sizes = new ArrayList<>();
        for (Object[] array : arrayOfArrays) {
            sizes.add(array == null ? 0 : array.length);
        }
        return sizes.contains(0) ? new ArrayList<>() : sizes;
    }


    private static int getMinSize(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int size : list) {
            min = size < min ? size : min;
        }
        return min;
    }


}
