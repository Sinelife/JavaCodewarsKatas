package rank6kyu;

import java.util.*;

public class SumConsecutives {

    public static void main(String[] args) {
        System.out.println(sumConsecutives(Arrays.asList(1, 4, 4, 4, 0, 4, 3, 3, 1)));
    }







    public static List<Integer> sumConsecutives(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        int sum = list.get(0);
        int i = 0;
        while (i < list.size()) {
            if (i == list.size() - 1) {
                result.add(sum);
            } else if (list.get(i).equals(list.get(i + 1))) {
                sum += list.get(i);
            } else {
                result.add(sum);
                sum = list.get(i + 1);
            }
            i++;
        }
        return result;
    }




//
//
//    public static List<Integer> sumConsecutives(List<Integer> list) {
//        Map<Integer, Integer> map = new HashMap<>();
//        list.forEach(elem -> map.put(elem, map.containsKey(elem) ? map.get(elem) + 1 : 1));
//        System.out.println(map);
//        return getResultList(map);
//    }
//
//    private static List<Integer> getResultList(Map<Integer, Integer> map) {
//        List<Integer> list = new ArrayList<>();
//        map.forEach((key, value) -> list.add(key * value));
//        return list;
//    }
}
