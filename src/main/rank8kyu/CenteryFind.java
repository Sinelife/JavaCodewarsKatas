package rank8kyu;

public class CenteryFind {
    public static void main(String[] args) {

    }

    public static int century(int number) {
        if (number % 100 == 0) {
            return number / 100;
        }
        return (number / 100) + 1;
    }
}
