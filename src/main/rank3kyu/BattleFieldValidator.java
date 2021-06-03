package rank3kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattleFieldValidator {

    public static boolean fieldValidator(int[][] field) {
        output(field);
        if (!shipsNotTouched(field)) {
            return false;
        }
        List<Integer> constants = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,2,3,3,4));
        List<Integer> fleet = new ArrayList<>();
        addHorizontalShips(fleet, field);
        addVerticalShips(fleet, field);
        return fleetHasAllShips(fleet, constants);
    }

    private static boolean shipsNotTouched(int[][] field) {
        for (int i = 0; i < field.length - 1; i++) {
            for (int j = 0; j < field.length - 1; j++) {
                if (squareOfCellsHasToMuchShips(field, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean squareOfCellsHasToMuchShips(int[][] field, int i, int j) {
        List<Integer> list = new ArrayList<>(Arrays.asList(field[i][j], field[i + 1][j], field[i][j + 1], field[i + 1][j + 1]));
        int counter = 0;
        for (Integer integer : list) {
            if (integer != 0) {
                counter++;
            }
        }
        if (list.get(0).equals(1) && list.get(3).equals(1)
                || list.get(1).equals(1) && list.get(2).equals(1)) {
            return true;
        }
        return counter > 2;
    }


    private static boolean fleetHasAllShips(List<Integer> ships, List<Integer> constants) {
        for (Integer shipLength : constants) {
            if (ships.contains(shipLength)) {
                ships.remove(shipLength);
            } else {
                return false;
            }
        }
        return ships.isEmpty();
    }

    private static void addVerticalShips(List<Integer> ships, int[][] field) {
        addHorizontalShips(ships, getTurnedField(field));
    }

    private static int[][] getTurnedField(int[][] field) {
        int[][] turnedField = new int[field.length][field.length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                turnedField[i][j] = field[j][i];
            }
        }
        return turnedField;
    }

    private static void addHorizontalShips(List<Integer> ships, int[][] field) {
        for (int i = 0; i < field.length; i++) {
            int counter = 0;
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 1 && dontHaveVerticalNeighbours(field, i, j)) {
                    field[i][j] = 2;
                    counter++;
                }
                if(field[i][j] == 0  && counter > 0) {
                    ships.add(counter);
                    counter = 0;
                }
            }
            if (counter != 0) {
                ships.add(counter);
            }
        }
    }

    private static boolean dontHaveVerticalNeighbours(int[][] field, int i, int j) {
        if (i == 0) {
            return field[i + 1][j] == 0;
        }
        if (i == field.length - 1) {
            return field[i - 1][j] == 0;
        }
        return field[i + 1][j] == 0 && field[i - 1][j] == 0;
    }



    private static void output(int[][] field) {
        for (int[] aField : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(aField[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[][] battleField = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 1}};
        System.out.println(fieldValidator(battleField));
    }
}
