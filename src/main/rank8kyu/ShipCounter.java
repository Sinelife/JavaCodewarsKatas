package rank8kyu;

public class ShipCounter {
    public static void main(String[] args) {
        Boolean[] array1 = {true,  true,  true,  false,
                true,  true,  true,  true ,
                true,  false, true,  false,
                true,  false, false, true ,
                true,  true,  true,  true ,
                false, false, true,  null };
        System.out.println(countSheeps(array1));
    }

    public static int countSheeps(Boolean[] arrayOfSheeps) {
        int res = 0;
        for (Boolean isPresent : arrayOfSheeps) {
            if (isPresent != null && isPresent) {
                res++;
            }
        }
        return res;
    }
}
