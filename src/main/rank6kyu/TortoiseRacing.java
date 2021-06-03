package rank6kyu;

import java.util.*;

public class TortoiseRacing {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(race(720, 850, 70)));
    }

    public static int[] race(int v1, int v2, int g) {
        if (v1 > v2) {
            return null;
        }
        return getTimeInCorrectFormat(g / (getSpeedPerSecond(v2) - getSpeedPerSecond(v1)));
    }

    private static int[] getTimeInCorrectFormat(double time) {
        int hours = (int) (time / 3600);
        time -= 3600 * hours;
        int minutes = (int) (time / 60);
        time -= 60 * minutes;
        int seconds = (int) time;
        System.out.println(Arrays.toString(new int[]{hours, minutes, seconds}));
        return new int[]{hours, minutes, seconds};
    }


    private static double getSpeedPerSecond(int v) {
        return (double) v / 3600;
    }
}
