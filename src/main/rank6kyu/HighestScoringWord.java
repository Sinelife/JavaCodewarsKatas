package rank6kyu;

public class HighestScoringWord {

    public static void main(String[] args) {
        System.out.println(high("man i need a taxi up to ubud"));
        System.out.println(high("what time are we climbing up to the volcano"));
        System.out.println(high("take me to semynak"));
    }


    public static String high(String str) {
        String[] words = str.split(" ");
        String max = words[0];
        for (String word : words) {
            if (getScore(word) > getScore(max)) {
                max = word;
            }
        }
        return max;
    }

    private static int getScore(String word) {
        char[] chars = word.toCharArray();
        int sum = 0;
        for (char symbol : chars) {
            sum += (int) symbol - 96;
        }
        return sum;
    }


}
