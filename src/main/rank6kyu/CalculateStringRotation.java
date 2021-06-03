package rank6kyu;

public class CalculateStringRotation {

    public static void main(String[] args) {
        System.out.println(shiftedDiff("coffee", "eecoff"));
    }



    static int shiftedDiff(String first, String second){
        for (int i = 0; i <= first.length(); i++) {
            if (second.equals(first)) {
                return i;
            }
            first = shift(first);
        }
        return -1;
    }

    private static String shift(String word) {
        return word.substring(word.length() - 1) + word.substring(0, word.length() - 1);
    }
}
