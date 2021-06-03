package rank6kyu;

public class PI_Approximation {

    public static void main(String[] args) {
        System.out.println(iterPi2String(0.001));
    }



    public static String iterPi2String(Double epsilon) {
        double sum = 1;
        int i = 1;
        int delta = 3;
        while (Math.abs(Math.PI - sum * 4) >= epsilon) {
            double a = (double) 1 / delta;
            sum += (i % 2 != 0) ? a * (-1) : a;
            delta += 2;
            i++;
        }
        long res = Math.round(Math.pow(10, 10) * 4 * sum);
        return "[" + i + ", " + String.valueOf(res / Math.pow(10, 10)) + "]";
    }
}
