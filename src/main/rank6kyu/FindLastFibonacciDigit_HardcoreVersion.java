package rank6kyu;

public class FindLastFibonacciDigit_HardcoreVersion {

    public static void main(String[] args) {
        System.out.println(lastFibDigit(1_000_000_009));
    }


    public static int lastFibDigit(int digit) {
        return getFibNumb(digit % 60);
    }

    public static int getFibNumb(int digit) {
        if (digit == 0) {
            return 0;
        }
        if (digit == 1) {
            return 1;
        }
        int a0 = 0;
        int a1 = 1;
        for (int i = 1; i < digit; i++) {
            String temp = String.valueOf(a1 + a0);
            int lastDigit = Integer.valueOf(String.valueOf(temp.charAt(temp.length() - 1)));
            a0 = a1;
            a1 = lastDigit;
        }
        return a1;
    }
}
