package rank6kyu;

public class FindTheParityOutlier {

    public static void main(String[] args) {
        System.out.println(find(new int[] {2, -6, 8, -10, -3}));
    }

    static int find(int[] integers) {
        boolean isEvenMoreInArray = isEvenMoreInArray(integers);
        System.out.println(isEvenMoreInArray);
        for (int number : integers) {
            if (isOther(number, isEvenMoreInArray)) {
                return number;
            }
        }
        return 0;
    }

    private static boolean isOther(int number, boolean isEvenMoreInArray) {
        return isEvenMoreInArray == (number % 2 != 0);
    }

    private static boolean isEvenMoreInArray(int[] array) {
        int evenCounter = 0;
        int oddCounter = 0;
        for (int i = 0; i < 3; i++) {
            if (array[i] % 2 == 0) {
                evenCounter++;
            } else {
                oddCounter++;
            }
        }
        return evenCounter > oddCounter;
    }
}
