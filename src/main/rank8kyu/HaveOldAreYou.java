package rank8kyu;

public class HaveOldAreYou {
    public static void main(String[] args) {

    }

    public static int howOld(final String herOld) {
        char[] chars = herOld.toCharArray();
        String res = "";
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                res += aChar;
            } else {
                break;
            }
        }
        return Integer.valueOf(res);
    }


}
