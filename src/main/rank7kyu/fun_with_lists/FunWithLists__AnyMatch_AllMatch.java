package rank7kyu.fun_with_lists;

import java.util.function.Predicate;

public class FunWithLists__AnyMatch_AllMatch {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, new Node<>(5, null)))));
        Predicate<Integer> predicate = x -> x >= 2;
        System.out.println(allMatch(node, predicate));
        System.out.println(anyMatch(node, predicate));
    }



    static <T> boolean anyMatch(Node<T> head, Predicate<T> p) {
        while (head != null) {
            if (p.test(head.data)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    static <T> boolean allMatch(Node<T> head, Predicate<T> p) {
        while (head != null) {
            if (!p.test(head.data)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
