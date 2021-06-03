package rank8kyu;

public class TotalPoints {
    public static void main(String[] args) {
        System.out.println(points(new String[]{"1:0"}));
    }

    public static int points(String[] games) {
        int res = 0;
        for (String game : games) {
            String[] arr = game.split(":");
            int x = Integer.valueOf(arr[0]);
            int y = Integer.valueOf(arr[1]);
            if (x > y) {
                res += 3;
            } else if (x == y) {
                res += 1;
            }
        }
        return res;
    }
}