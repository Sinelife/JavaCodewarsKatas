package rank6kyu;


public class YourOrderPlease {
    public static void main(String[] args) {
        System.out.println(order("4of Fo1r pe6ople g3ood th5e the2"));
    }

    public static String order(String str) {
        if (str.isEmpty()) {
            return "";
        }
        String[] words = str.split(" ");
        int counter = 1;
        String res = "";
        while (res.split(" ").length < words.length) {
            for (String word : words) {
                if (word.contains(String.valueOf(counter))) {
                    counter++;
                    res += word + " ";
                }
            }
        }
        return res.substring(0, res.length() - 1);
    }
}
