package rank6kyu;

public class When_Sigma_1_FunctionHasEqualsValuesForAnIntegerandItsReversedOne {

    public static void main(String[] args) {
        System.out.println(equalSigma1(16000));
    }





    public static int equalSigma1(int number) {
        int sum = 0;
        int current = 528;
        while (current <= number) {
            sum += (getSumOfDividers(current) == getSumOfDividers(getReversedNum(current)) && current != getReversedNum(current)) ? current : 0;
            current++;
        }
        return sum;
    }


    private static int getReversedNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        String res = "";
        for (char symbol : chars) {
            res = symbol + res;
        }
        return Integer.valueOf(res);
    }

    private static int getSumOfDividers(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += (num % i == 0) ? i : 0;
        }
        return sum;
    }
}
