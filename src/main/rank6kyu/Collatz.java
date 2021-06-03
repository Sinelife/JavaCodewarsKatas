package rank6kyu;

public class Collatz {

    public static void main(String[] args) {
        System.out.println(collatz(3));
    }



    public static String collatz(int n) {
        String res = n + "->";
        while (n > 1) {
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
            res += n + "->";
        }
        return res.substring(0, res.length() - 2);
    }
}
