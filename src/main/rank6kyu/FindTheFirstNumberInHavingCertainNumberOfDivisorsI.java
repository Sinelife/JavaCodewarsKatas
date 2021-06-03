package rank6kyu;

public class FindTheFirstNumberInHavingCertainNumberOfDivisorsI {

    public static void main(String[] args) {
        System.out.println(getDivisorNum(100));
    }



    public static int findMinNum(int divisorNum) {
        int num = 1;
        while (divisorNum != getDivisorNum(num)) {
            num++;
        }
        return num;
    }

    private static int getDivisorNum(int num) {
        int counter = 2;
        for (int i = 2; i <= num / 2; i++) {
            counter = num % i == 0 ? counter + 1 : counter;
        }
        return num == 1 ? 1 : counter;
    }

}