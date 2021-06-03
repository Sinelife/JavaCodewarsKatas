package rank6kyu;

public class CreatePhoneNumber {
    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }


    public static String createPhoneNumber(int[] numbers) {
        return "(" + getCharsPart(numbers, 0, 2) + ") "
                + getCharsPart(numbers, 3, 5) + "-"
                + getCharsPart(numbers, 6, 9);
    }

    private static String getCharsPart(int[] numbers, int startIndex, int endIndex) {
        String res = "";
        for (int i = startIndex; i <= endIndex; i++) {
            res += numbers[i];
        }
        return res;
    }


}
