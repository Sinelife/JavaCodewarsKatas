package rank7kyu;

public class StringEndsWith {
    public static void main(String[] args) {

    }

    public static boolean solution(String str, String ending) {
        for (int i = 0; i <= str.length(); i++) {
            if (str.substring(i).equals(ending)) {
                return true;
            }
        }
        return false;
    }
}
