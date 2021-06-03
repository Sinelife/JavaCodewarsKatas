package rank8kyu;

import java.util.ArrayList;
import java.util.List;

public class EvenNumbers {
    public static void main(String[] args) {

    }


    public static int[] divisibleBy(int[] numbers, int divider) {

        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            if (number % divider == 0) {
                list.add(number);
            }
        }
        int[] result = new int[list.size()];
        int counter = 0;
        for (Integer number : list) {
            result[counter] = number;
            counter++;
        }
        return result;
    }
}
