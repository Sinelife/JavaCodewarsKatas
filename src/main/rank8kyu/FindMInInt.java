package rank8kyu;

public class FindMInInt {
    public static void main(String[] args) {

    }

    public static int findSmallestInt(int[] args) {
        int min = args[0];
        for (int i : args) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
