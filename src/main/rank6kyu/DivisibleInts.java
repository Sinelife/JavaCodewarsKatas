package rank6kyu;

public class DivisibleInts {

    public static void main(String[] args) {
        System.out.println(getCount(12));
    }


    public static int getCount(int num) {
        String textNum = String.valueOf(num);
        int counter = 0;
        for (int i = 0; i < textNum.length(); i++) {
            for (int j = i + 1; j <= textNum.length(); j++) {
                int divider = Integer.valueOf(textNum.substring(i, j));
                counter = (divider != 0 && num % divider == 0) ? ++counter : counter;
            }
        }
        return --counter;
    }
}
