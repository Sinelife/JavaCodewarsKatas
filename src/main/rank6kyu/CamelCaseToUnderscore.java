package rank6kyu;

public class CamelCaseToUnderscore {

    public static void main(String[] args) {
//        toUnderScore("ThisIsAUnitTest");
        toUnderScore("Calculate1_0_Plus1_Equals2");
    }


    public static String toUnderScore(String str){
        char[] chars = str.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            if (isBigLetter(chars[i])) {
                res += getBigLetter(chars, i);
            } else if (isNumber(chars[i])) {
                res += getNumber(chars, i);
            } else {
                res += chars[i];
            }
        }
        return res.charAt(0) == '_' ? res.substring(1) : res;
    }

    private static String getBigLetter(char[] chars, int i) {
        if (i > 0 && chars[i - 1] == '_') {
            return String.valueOf(chars[i]);
        } else {
            return "_" + chars[i];
        }
    }


    private static String getNumber(char[] chars, int i) {
        if (i > 0 && (isNumber(chars[i - 1]) || chars[i - 1] == '_')) {
            return String.valueOf(chars[i]);
        } else {
            return "_" + chars[i];
        }
    }

    private static boolean isBigLetter(char symbol) {
        return symbol >= 'A' && symbol <= 'Z';
    }

    private static boolean isNumber(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }
}
