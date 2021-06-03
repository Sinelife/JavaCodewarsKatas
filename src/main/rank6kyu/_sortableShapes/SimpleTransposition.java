package rank6kyu._sortableShapes;

public class SimpleTransposition {
    public static void main(String[] args) {

    }

    public static String simpleTransposition(String text) {
        char[] chars = text.toCharArray();
        String part1 = "";
        String part2 = "";
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                part1 += chars[i];
            } else {
                part2 += chars[i];
            }
        }
        return part1 + part2;
    }
}
