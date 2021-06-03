package rank6kyu;

public class SumOfDigits__DigitalRoot {
    public static void main(String[] args) {
        System.out.println(digital_root(12345));
    }


    public static int digital_root(int n) {
        String str = String.valueOf(n);
        if (str.length() == 1) {
            return n;
        }
        int res = 0;
        for (String digit : str.split("")) {
            res += Integer.valueOf(digit);
        }
        return digital_root(res);
    }

}
