package rank6kyu;

public class FindTheUniqueNumber {
    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{1, 1, 1, 0.4, 1, 1}));
    }


    public static double findUniq(double arr[]) {
        if (arr[0] != arr[1] && arr[0] != arr[2]) {
            return arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[0]) {
                return arr[i];
            }
        }
        return 0;
    }
}
