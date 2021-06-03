package rank6kyu;

import java.util.Arrays;

public class SortingOnPlanetTwisted_3_7 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortTwisted37(new Integer[]{9, 2, 4, 7, 3})));
    }


    public static Integer[] sortTwisted37(Integer[] array) {
        Integer[] result = new Integer[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        changeArray(result);
        sort(result);
        changeArray(result);
        return result;
    }

    private static void sort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if(array[j] < array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static void changeArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = getChangedNumber(array[i]);
        }
    }

    private static Integer getChangedNumber(Integer number) {
        char[] chars = String.valueOf(number).toCharArray();
        String res = "";
        for (char symbol : chars) {
            res += symbol == '7' ? '3' : (symbol == '3' ? '7' : symbol);
        }
        return Integer.valueOf(res);
    }

}
