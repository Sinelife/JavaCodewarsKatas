package rank6kyu;

public class PointsInTheCircle {


    public static void main(String[] args) {
        System.out.println(pointsNumber(2));
    }


    public static int pointsNumber(int radius) {
        int counter = 0;
        for (int i = (-1) * radius; i <= radius; i++) {
            for (int j = (-1) * radius; j <= radius; j++) {
                if (Math.sqrt(i * i + j * j) <= radius) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
