package rank6kyu;

import java.util.Arrays;

public class SurroundingPrimesForValue {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(primeBefAft(80_000_000)));
    }


    public static long[] primeBefAft(long num) {
        return new long[]{getPrime(num, "less"), getPrime(num, "more")};
    }

    private static long getPrime(long num, String s) {
        while (true) {
            num = s.equals("less") ? num - 1 : num + 1;
            if (isPrime(num)) {
                return num;
            }
        }
    }

    private static boolean isPrime(long num) {
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; 2 * i < num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
