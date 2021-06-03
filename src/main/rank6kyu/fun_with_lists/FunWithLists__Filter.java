package rank6kyu.fun_with_lists;

import java.util.function.Predicate;

public class FunWithLists__Filter {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1, new Node<>(2, new Node<>(0, new Node<>(4, new Node<>(5, null)))));
        Predicate<Integer> predicate = x -> x >= 2;
        System.out.println(filter(node, predicate));
    }


    static <T> Node<T> filter(Node<T> head, Predicate<T> p) {
        Node<T> newNode = new Node<>(null);
        Node<T> temp = newNode;
        while (head != null) {
            if (p.test(head.data)) {
                temp.next = new Node<>(head.data, null);
                temp = temp.next;
            }
            head = head.next;
        }
        return newNode.next;
    }




    //        if (head == null) {
//            return null;
//        }
//        Node<T> newNode = null;
//        Node<T> temp = null;
//        do {
//            if (p.test(head.data)) {
//                if (newNode == null) {
//                    newNode = new Node<>(head.data, null);
//                    temp = newNode;
//                    head = head.next;
//                } else {
//                    temp.next = new Node<>(head.data, null);
//                    head = head.next;
//                    temp = temp.next;
//                }
//            } else {
//                head = head.next;
//            }
//        } while (head != null);

}
