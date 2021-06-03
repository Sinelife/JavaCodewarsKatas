package rank6kyu;

import java.util.*;

public class WhoWonTheElection {

    public static void main(String[] args) {
        System.out.println(getWinner(Arrays.asList("A", "A", "A", "B", "B", "B", "A")));
    }


    public static String getWinner(final List<String> listOfBallots) {
        Map<String, Integer> map = new HashMap<>();
        listOfBallots.forEach(elem -> map.put(elem, (map.containsKey(elem) ? map.get(elem) + 1 : 1)));
        Map.Entry<String, Integer> winner = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        return winner.getValue() > listOfBallots.size() / 2 ? winner.getKey() : null;
    }




}
