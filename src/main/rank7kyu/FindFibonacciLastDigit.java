package rank7kyu;

public class FindFibonacciLastDigit {
    public static void main(String[] args) {
        for (int i = 0; i < 1200; i++) {
            System.out.println(getFibNumb(i));
        }
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
