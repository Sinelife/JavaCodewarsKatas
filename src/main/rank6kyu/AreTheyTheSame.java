package rank6kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AreTheyTheSame {
    public static void main(String[] args) {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(comp(a, b));
        System.out.println(comp(new int[]{}, new int[]{}));
    }

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length ) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.stream(a).forEach(elem -> list.add(elem * elem));
        Arrays.stream(b).forEach(elem -> list.remove(Integer.valueOf(elem)));
        return list.isEmpty();
    }
}
