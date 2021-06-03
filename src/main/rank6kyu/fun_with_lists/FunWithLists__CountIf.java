package rank6kyu.fun_with_lists;

import java.util.function.Predicate;

public class FunWithLists__CountIf {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1, new Node<>(2, new Node<>(0, new Node<>(4, new Node<>(5, null)))));
        Predicate<Integer> predicate = x -> x >= 2;
        System.out.println(countIf(node, predicate));
    }


    static <T> int countIf(Node<T> head, Predicate<T> p) {
        int res = 0;
        while (head != null) {
            if (p.test(head.data)) {
                res++;
            }
            head = head.next;
        }
        return res;
    }
}
