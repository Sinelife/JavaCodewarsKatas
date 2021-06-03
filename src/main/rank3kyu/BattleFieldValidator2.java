package rank3kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattleFieldValidator2 {

    private int[][] field;

    public BattleFieldValidator2(int[][] field) {
        this.field = field;
    }

    public boolean validate() {
        output(field);
        if (fieldValidator(field)) {
            return true;
        }
        if (incorrectNum()) {
            return false;
        }
        List<Integer> constants = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,2,3,3,4));
        List<Integer> fleet1 = new ArrayList<>();
        List<Integer> fleet2 = new ArrayList<>();
        addHorizontalShips(fleet1, field);
        clearField(field);
        addVerticalShips(fleet2, field);
        System.out.println(fleet1);
        System.out.println(fleet2);
        return fleetHasAllShips(fleet1, constants) || fleetHasAllShips(fleet2, constants);
    }

    private boolean incorrectNum() {
        int counter = 0;
        for (int[] aField : field) {
            for (int j = 0; j < field.length; j++) {
                if (aField[j] == 1) {
                    counter++;
                }
            }
        }
        return counter != 20;
    }


    private static boolean fleetHasAllShips(List<Integer> ships, List<Integer> constants) {
        List<Integer> defaultShips = new ArrayList<>(constants);
        for (Integer shipLength : constants) {
            if (ships.contains(shipLength)) {
                ships.remove(shipLength);
                defaultShips.remove(shipLength);
            }
        }
        int counter = 0;
        while(counter < 1) {
            System.out.println(ships);
            System.out.println(defaultShips);
            System.out.println();
            counter++;
            for (int i = 0; i < ships.size(); i++) {
                if (ships.get(i) > maxOfList(defaultShips)) {
                    int part1 = ships.get(i) - maxOfList(defaultShips);
                    int part2 = maxOfList(defaultShips);
                    ships.remove(ships.get(i));
                    ships.add(part1);
                    ships.add(part2);
                    return fleetHasAllShips(ships, defaultShips);
                }
            }
        }
        return ships.isEmpty();
    }


    private static int maxOfList(List<Integer> list) {
        int max = list.get(0);
        for (Integer num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }


    private static void addHorizontalShips(List<Integer> ships, int[][] field) {
        for (int i = 0; i < field.length; i++) {
            int counter = 0;
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 1) {
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

    private static void clearField(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 2) {
                    field[i][j] = 1;
                }
            }
        }
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
        int[][] field = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        BattleFieldValidator2 validator = new BattleFieldValidator2(field);
        System.out.println(validator.validate());
    }








    public static boolean fieldValidator(int[][] field) {
        output(field);
        if (!oldShipsNotTouched(field)) {
            return false;
        }
        List<Integer> constants = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,2,3,3,4));
        List<Integer> fleet = new ArrayList<>();
        addOldHorizontalShips(fleet, field);
        addOldVerticalShips(fleet, field);
        return oldFleetHasAllShips(fleet, constants);
    }

    private static boolean oldShipsNotTouched(int[][] field) {
        for (int i = 0; i < field.length - 1; i++) {
            for (int j = 0; j < field.length - 1; j++) {
                if (oldSquareOfCellsHasToMuchShips(field, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean oldSquareOfCellsHasToMuchShips(int[][] field, int i, int j) {
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


    private static boolean oldFleetHasAllShips(List<Integer> ships, List<Integer> constants) {
        for (Integer shipLength : constants) {
            if (ships.contains(shipLength)) {
                ships.remove(shipLength);
            } else {
                return false;
            }
        }
        return ships.isEmpty();
    }

    private static void addOldVerticalShips(List<Integer> ships, int[][] field) {
        addOldHorizontalShips(ships, getOldTurnedField(field));
    }

    private static int[][] getOldTurnedField(int[][] field) {
        int[][] turnedField = new int[field.length][field.length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                turnedField[i][j] = field[j][i];
            }
        }
        return turnedField;
    }

    private static void addOldHorizontalShips(List<Integer> ships, int[][] field) {
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

}
