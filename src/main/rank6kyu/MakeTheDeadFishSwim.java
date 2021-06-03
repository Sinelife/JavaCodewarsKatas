package rank6kyu;

import java.util.ArrayList;
import java.util.List;

public class MakeTheDeadFishSwim {

    public static int[] parse(String data) {
        char[] chars = data.toCharArray();
        List<Integer> resultList = new ArrayList<>();
        int number = 0;
        for (char symbol : chars) {
            if (symbol == 'i') {
                number++;
            } else if (symbol == 'd') {
                number--;
            } else if (symbol == 's') {
                number *= number;
            } else if (symbol == 'o') {
                resultList.add(number);
            }
        }
        return resultList
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
