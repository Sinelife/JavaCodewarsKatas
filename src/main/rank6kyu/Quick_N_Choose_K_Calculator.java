package rank6kyu;

import java.math.BigInteger;

public class Quick_N_Choose_K_Calculator {

    public static void main(String[] args) {
        System.out.println(choose(10, 20));
    }




    public static BigInteger choose(int n, int k) {
        return k > n ? new BigInteger("0") : new BigInteger(String.valueOf(factorial(n).divide(factorial(k).multiply(factorial(n - k)))));
    }

    private static BigInteger factorial(int n) {
        return (n == 0) ? new BigInteger("1") : new BigInteger(String.valueOf(n)).multiply(factorial(n - 1));
    }

}

