package rank6kyu;

import java.util.*;

public class __MostFrequentWeekdays {

    private static final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int MAX_DAY_OF_WEEK_IN_YEAR = 53;

    public static void main(String[] args) {
        mostFrequentDays(1084);
    }




    public static String[] mostFrequentDays(int year) {
        System.out.println(year);
        Map<Integer, Integer> map = getInitializedMap();
        Calendar start = new GregorianCalendar();
        start.set(year - 1, Calendar.DECEMBER, 31);
        start.add(Calendar.DATE, 1);
//        System.out.println(start);
        Calendar end = new GregorianCalendar();
        end.set(year, Calendar.DECEMBER, 31);


//        System.out.println(end);
        int i = 1;
        for (; start.before(end); start.add(Calendar.DATE, 1)) {
            System.out.println(i + ") " + start);
            int key = start.get(Calendar.DAY_OF_WEEK);
//            System.out.println(key);
            int newValue = map.get(key) + 1;
            map.put(key, newValue);
            i++;
        }
        System.out.println(map);
        return getListOfMaxDayOfWeekNum(map);
    }

    private static Map<Integer, Integer> getInitializedMap() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 7; i++) {
            map.put(i, 0);
        }
        return map;
    }

    private static String[] getListOfMaxDayOfWeekNum(Map<Integer, Integer> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == MAX_DAY_OF_WEEK_IN_YEAR) {
                list.add(days[entry.getKey() - 1]);
            }
        }
        System.out.println(list.size());
        System.out.println(list);
        String[] strings = new String[list.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = list.get(i);
        }
        return strings;
    }

}
