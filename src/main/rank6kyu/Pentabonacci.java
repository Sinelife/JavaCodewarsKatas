package rank6kyu;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Pentabonacci {

    public static void main(String[] args) {
        System.out.println(countOddPentaFib(68));
    }

//    public static long countOddPentaFib(long n) {
//        BigInteger[] numbers = getListOfPentaFibNumbers((int) n + 1);
//        List<BigInteger> list = new ArrayList<>();
//        list.add(new BigInteger("1"));
//        for (int i = 0; i < numbers.length; i++) {
//            BigInteger temp = numbers[i];
//            System.out.println(i + ") " + temp);
//            if (temp.remainder(new BigInteger("2")).intValue() != 0 && !list.contains(new BigInteger("1"))) {
//                System.out.println("ODD");
//                list.add(temp);
//            }
//        }
//        return list.size();
//    }
//
//    public static BigInteger[] getListOfPentaFibNumbers(int n) {
//        BigInteger[] result = new BigInteger[n];
//        result[0] = new BigInteger("0");
//        result[1] = new BigInteger("1");
//        result[2] = new BigInteger("1");
//        result[3] = new BigInteger("2");
//        result[4] = new BigInteger("4");
//        for (int i = 5; i < n; i++) {
//            result[i] = result[i - 1].add(result[i - 2]).add(result[i - 3]).add(result[i - 4]).add(result[i - 5]);
//        }
//        return result;
//    }





    public static long countOddPentaFib(long n) {
        System.out.println(n);
        int[] numbers = getArrayOfPentaFibNumbers((int) n + 1);
        int counter = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                counter++;
            }
        }
        return counter;
    }

    private static int[] getArrayOfPentaFibNumbers(int n) {
        int[] result = new int[n];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        result[3] = 2;
        result[4] = 4;
        for (int i = 5; i < n; i++) {
            result[i] = 0;
            for (int j = i - 5; j < i ; j++) {
                result[i] += getLastDigit(result[j]);
            }
        }
        return result;
    }

    private static int getLastDigit(int num) {
        String str = String.valueOf(num);
        return Integer.valueOf(str.substring(str.length() - 1));
    }


}
