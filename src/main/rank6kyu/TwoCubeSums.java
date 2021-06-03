package rank6kyu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoCubeSums {

    public static void main(String[] args) {
        System.out.println(hasTwoCubeSums(46_163));
    }


    public static boolean hasTwoCubeSums(int n) {
        int max = (int) Math.pow(n, (double) 1 / 3);
        int counter = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= max; j++) {
                counter = (Math.pow(i, 3) + Math.pow(j, 3) == n) ? counter + 1 : counter;
            }
        }
        return counter == 4;
    }

}
