package rank6kyu;

import java.util.*;

public class DeleteOccurrencesOfAnElementIfItOccursMoreThanNTimes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[]{3, 3, 3, 1, 2, 2, 1, 1, 1, 1, 1, 3, 1, 2, 2, 2}, 0)));
    }


    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if(elements.length == 0 || maxOccurrences == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(elements).forEach(elem -> {
            if (map.containsKey(elem) && map.get(elem) < maxOccurrences) {
                map.put(elem, map.get(elem) + 1);
            } else if (map.containsKey(elem) && map.get(elem) == maxOccurrences) {

            } else {
                map.put(elem, 1);
            }
        });
        List<Integer> resultList = new ArrayList<>();
        Arrays.stream(elements).forEach(elem -> {
            if (map.containsKey(elem)) {
                resultList.add(elem);
                int newValue = map.get(elem) - 1;
                if (newValue > 0) {
                    map.put(elem, newValue);
                } else {
                    map.remove(elem);
                }
            }
        });
        return resultList
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
