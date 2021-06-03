package rank6kyu;


import java.util.*;

public class FindTheOddInt {

    public static void main(String[] args) {

    }

    public static int findIt(int[] array) {
        Map<Integer, Integer> map = getInitializedHashMap(array);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private static Map<Integer, Integer> getInitializedHashMap(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                int newValue = map.get(i) + 1;
                map.put(i, newValue);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }
}
