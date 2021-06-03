package rank6kyu.fun_with_lists;

import java.util.function.BiFunction;

public class FunWithLists__Reduce {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, new Node<>(5, null)))));
        BiFunction<Integer, Integer, Integer> function = (a, b) -> a + b;
        System.out.println(reduce(node, function, 0));
    }



    static <T> T reduce(Node<T> head, BiFunction<T, T, T> f, T res) {
        while (head != null) {
            res = f.apply(res, head.data);
            head = head.next;
        }
        return res;
    }
}
