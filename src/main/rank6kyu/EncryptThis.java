package rank6kyu;

public class EncryptThis {


    public static void main(String[] args) {
        System.out.println(encryptThis("A\n \n  \nwise    old owl lived in an oak"));
    }





    public static String encryptThis(String text) {
        if (text.isEmpty()) {
            return "";
        }
        System.out.println(text);
        String[] words = text.split(" |\n");
        for (String word : words) {
            System.out.println("N)" + word);
        }
        String res = "";
        for (String word : words) {
            res += getEncryptedWord(word);
        }
        System.out.println(res);
        return res.substring(0, res.length() - 1);
    }

    private static String getEncryptedWord(String word) {
        if (word.equals(" ") || word.equals("\n")) {
            return "";
        }
        char[] chars = word.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            res += (i == 0) ? String.valueOf((int) chars[i]) : ((i == 1) ? (char) chars[chars.length - 1] : ((i == chars.length - 1) ? chars[1] : chars[i]));
        }
        return res + " ";
    }
}
