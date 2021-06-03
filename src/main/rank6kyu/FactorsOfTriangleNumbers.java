package rank6kyu;


public class FactorsOfTriangleNumbers {

    public static void main(String[] args) {
        FactorsOfTriangleNumbers f = new FactorsOfTriangleNumbers();
        System.out.println(f.calculate(500));

    }


    public int calculate(int n) {
        int number = 1;
        int delta = 2;
        while (getNumOfDividers(number) <= n) {
            number += delta;
            delta++;
        }
        return number;
    }

    private int getNumOfDividers(int number) {
        int dividersNum = 1;
        for (int i = 2; i <= number; i++){
            int counter = 0;
            while (number % i == 0) {
                number /= i;
                counter++;
            }
            if(counter != 0) {
                dividersNum *= (counter + 1);
            }
        }
        return dividersNum;
    }

}
