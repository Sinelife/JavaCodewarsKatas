package rank8kyu;

public class CorrectTheMistakesOfTheCharacterRecognitionSoftware {
    public static void main(String[] args) {
        System.out.println(correct("R0BERT MERLE - THE DAY 0F THE D0LPH1N"));
    }

    public static String correct(String string) {
        char[] chars = string.toCharArray();
        String res = "";
        for (char aChar : chars) {
            if (aChar == '5') {
                res += "S";
            } else if (aChar == '0') {
                res += "O";
            } else if (aChar == '1') {
                res += "I";
            } else {
                res += aChar;
            }
        }
        return res;
    }
}
