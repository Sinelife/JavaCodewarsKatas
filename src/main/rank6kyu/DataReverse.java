package rank6kyu;

import java.util.Arrays;

public class DataReverse {

    public static void main(String[] args) {
        int[] data1= {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(DataReverse(data1)));
    }



    public static int[] DataReverse(int[] data) {
        int[] result = new int[data.length];
        int counter = data.length - 8;
        for (int i = 0; i < data.length; i++) {
            result[i] = data[counter];
            counter = (i + 1) % 8 == 0 ? counter - 15 : counter + 1;
        }
        return result;
    }
}
