package rank6kyu;

import java.util.*;

public class CheckingGroups {

    public static void main(String[] args) {
        System.out.println(groupCheck("[])"));
    }


    public static boolean groupCheck(String s){
        List<Character> list = new LinkedList<>();
        for(char symbol : s.toCharArray()) {
            switch(symbol) {
                case '(':
                case '[':
                case '{': list.add(0, symbol); break;
                case ')': if(removeFirst(list) != '(') return false; break;
                case ']': if(removeFirst(list) != '[') return false; break;
                case '}': if(removeFirst(list) != '{') return false; break;
            }
        }
        return list.isEmpty();
    }


    private static Character removeFirst(List<Character> list) {
        return list.isEmpty() ? ' ' : list.remove(0);
    }
}
