package rank6kyu;

import java.util.List;

public class TheModulo_3_Sequence {

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(i + 1 + ")" + sequence(i));
        }
    }



    public static int sequence(int n) {
        int x1 = 0;
        int x2 = 1;

        for (int i = 0; i < (n - 2) % 8; i++) {
            int sum = (x1 + x2) % 3;
            x1 = x2;
            x2 = sum;
        }
//        System.out.println(n == 0 ? 0 : (n == 1 ? 1 : x2));
        return n == 0 ? 0 : (n == 1 ? 1 : x2);
    }
}
