package rank6kyu;

import java.util.*;
import java.util.stream.Collectors;

public class LOTTO_6_aus_49__6_of_49 {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(numberGenerator()));

        System.out.println(checkForWinningCategory(new int[]{1, 10, 11, 18, 29, 36, 6}, new int[]{1, 10, 11, 18, 29, 36, 0}));


    }



    public static int[] numberGenerator() {
        List<Integer> list = new ArrayList<>();
        while(list.size() < 6) {
            int num = new Random().nextInt(49) + 1;
            list.add(!list.contains(num) ? num : null);
            list.remove(null);
        }
        Collections.sort(list);
        list.add(new Random().nextInt(10));
        return list.stream().mapToInt(elem -> elem).toArray();
    }




    public static int checkForWinningCategory(int[] array, int[] winningArray) {
        if (array[array.length - 1] < 0 || array[array.length - 1] > 9) {
            return -1;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return -1;
            }
        }
        int counter = 0;
        List<Integer> winningList = Arrays.stream(winningArray).boxed().collect(Collectors.toList());
        for (int i = 0; i < array.length - 1; i++) {
            counter = winningList.contains(array[i]) ? ++counter : counter;
        }
        boolean hasSuperzahl = array[array.length - 1] == winningArray[array.length - 1];
        int result = counter == 6 ? 2 : (counter == 5 ? 4 : (counter == 4 ? 6 : (counter == 3 ? 8 : (counter == 2 && hasSuperzahl ? 9 : -1))));
        return hasSuperzahl ? --result : result;
    }
}
