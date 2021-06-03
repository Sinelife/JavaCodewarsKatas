package rank6kyu;


public class RomanNumeralsEncoder {

    public static void main(String[] args) {
        RomanNumeralsEncoder r = new RomanNumeralsEncoder();
        System.out.println(r.solution(2494));
    }


    public String solution(int n) {
        String[] romans = {"M", "XM", "CM", "D", "XD", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabics = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String res = "";
        int i = 0;
        while (n > 0) {
            while (n - arabics[i] >= 0) {
                n -= arabics[i];
                res += romans[i];
            }
            i++;
        }
        return res;
    }
}
