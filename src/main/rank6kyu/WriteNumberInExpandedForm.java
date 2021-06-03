package rank6kyu;

import java.util.*;

public class WriteNumberInExpandedForm {

    public static void main(String[] args) {
        System.out.println(expandedForm(123405));
    }



    public static String expandedForm(int num) {
        List<String> list = new ArrayList<>();
        int counter = 0;
        while(num > 0) {
            if (num % 10 != 0) {
                list.add(String.valueOf(num % 10) + addZeros(counter));
            }
            num /= 10;
            counter++;
        }
        return getResultString(list);
    }

    private static String getResultString(List<String> list) {
        String res = "";
        for (int i = list.size() - 1; i > 0; i--) {
            res += list.get(i) + " + ";
        }
        return res + list.get(0);
    }

    private static String addZeros(int counter) {
        String res = "";
        for (int i = 0; i < counter; i++) {
            res += "0";
        }
        return res;
    }
}
