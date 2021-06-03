package rank6kyu.fun_with_lists;

import java.util.function.Function;



public class FunWithLists__Map {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, new Node<>(5, null)))));
        Function<Integer, Integer> function = x -> x * 2;
        System.out.println(map(node, function));
    }


    static <T, R> Node<R> map(Node<T> head, Function<T, R> f) {
        Node<R> newNode = new Node<>(null);
        Node<R> temp = newNode;
        while (head != null) {
            temp.next = new Node<>(f.apply(head.data), null);
            temp = temp.next;
            head = head.next;
        }
        return newNode.next;
    }



//        Node<R> temp = new Node<>(f.apply(head.data), null);
//        Node<R> newNode = temp;
//        while (head.next != null) {
//            head = head.next;
//            temp.next = new Node<>(f.apply(head.data), null);
//            temp = temp.next;
//        }
//        return newNode;
}
