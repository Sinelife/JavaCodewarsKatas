package rank7kyu.fun_with_lists;

public class FunWithLists__Length {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, new Node<>(5, null)))));
        System.out.println(length(node));
    }



    static int length(Node head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }
}
