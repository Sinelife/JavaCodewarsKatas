package rank8kyu;

public class CountOfPositives_SumOfNegatives {
    public static void main(String[] args) {

    }

    public static int[] countPositivesSumNegatives(int[] input) {
        if(input == null || input.length == 0) {
            return new int[]{};
        }
        for (int i : input) {
            System.out.println(i);
        }
        int positiveCount = 0;
        int negativeSum = 0;
        for (int i : input) {
            if (i > 0) {
                positiveCount++;
            }
            if(i < 0) {
                negativeSum += i;
            }
        }
        return new int[]{positiveCount, negativeSum};
    }

}
