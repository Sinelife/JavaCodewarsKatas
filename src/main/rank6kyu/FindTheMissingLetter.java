package rank6kyu;

import java.util.Arrays;

public class FindTheMissingLetter {

    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[]{'I', 'K'}));
        System.out.println((int) 'A');
    }



    public static char findMissingLetter(char[] array) {
        for (int i = getMinMax(array, "min"); i <= getMinMax(array, "max"); i++) {
            if (array[i - array[0]] != (char) i) {
                return (char) i;
            }
        }
        return ' ';
    }

    private static int getMinMax(char[] array, String str) {
        int x = 200;
        for (char symbol : array) {
            x = str.equals("max") ? ((x < symbol) ? symbol : x) : ((x > symbol) ? symbol : x);
        }
        return x;
    }

}
