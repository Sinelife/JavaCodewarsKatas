package rank6kyu;

import java.lang.reflect.Array;
import java.util.*;

public class Top_N_ClosestPoints {


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getTopN(new int[][]{{1, 2}, {3, 5}, {0, 1}, {1, 0}, {1, 1}}, 3)));
    }


    public static int[][] getTopN(int[][] points, int n) {
        if (points.length < n) {
            return points;
        }
        Map<int[], Double> map = getPointDistanceMap(points);
        int[][] result = new int[n][2];
        int counter = 0;
        while (counter < n) {
            result[counter] = getClosestPoint(map);
            counter++;
        }
        System.out.println(Arrays.deepToString(result));
        return result;
    }

    private static Map<int[], Double> getPointDistanceMap(int[][] points) {
        Map<int[], Double> map = new HashMap<>();
        for (int[] point : points) {
            map.put(point, getDistance(point));
        }
        return map;
    }

    private static int[] getClosestPoint(Map<int[], Double> map) {
        double min = Double.MAX_VALUE;
        int[] closestPoint = new int[0];
        for (Map.Entry<int[], Double> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                closestPoint = entry.getKey();
                min = entry.getValue();
            }
        }
        map.keySet().remove(closestPoint);
        return closestPoint;
    }

    private static Double getDistance(int[] point) {
        return (double) (point[0] * point[0] + point[1] * point[1]);
    }
}
