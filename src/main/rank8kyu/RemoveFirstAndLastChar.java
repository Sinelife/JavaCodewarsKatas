package rank8kyu;

public class RemoveFirstAndLastChar {
    public static void main(String[] args) {

    }

    public static String remove(String str) {
        String res = "";
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            res += chars[i];
        }
        return res;
    }
}
