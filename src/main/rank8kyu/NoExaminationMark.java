package rank8kyu;

public class NoExaminationMark {
    public static void main(String[] args) {

    }

    static String removeExclamationMarks(String s) {
        String res = "";
        for (char c : s.toCharArray()) {
            if (c != '!') {
                res += c;
            }
        }
        return res;
    }
}
