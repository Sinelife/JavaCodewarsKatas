package rank8kyu;

public class NoSpaces {
    public static void main(String[] args) {

    }

    static String noSpace(final String x) {
        if (x == null) {
            return "";
        }
        String res = "";
        for (char c : x.toCharArray()) {
            if (c != ' ') {
                res += c;
            }
        }
        return res;
    }
}
