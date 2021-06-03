package rank4kyu;

import java.math.BigInteger;

public class LargeFactorials {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(i + "! = " + Factorial(i));
        }
    }


    public static String Factorial(int number) {
        if(number < 0) {
            return "";
        }
        if (number == 0) {
            return "1";
        }
        BigInteger sum = new BigInteger("1");
        for (int i = 1; i < number; i++) {
            sum = sum.multiply(new BigInteger((i + 1) + ""));
        }
        return sum.toString();
    }
}
