package rank6kyu;

public class CircularlySortedArray {
    public static void main(String[] args) {
        CircularlySortedArray c = new CircularlySortedArray();
        System.out.println(c.isCircleSorted(new int[]{5, 7, 43, 987, -9, 0}));
    }


    public boolean isCircleSorted(int[] a) {
        for (int ignored : a) {
            if (isSorted(a)) {
                return true;
            }
            shift(a);
        }
        return false;
    }

    private boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void shift(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            swap(a, i, i + 1);
        }
        swap(a, a.length - 1, 0);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
