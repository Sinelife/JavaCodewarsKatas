package rank7kyu.fun_with_lists;

public class FunWithLists__LastIndexOf {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, new Node<>(5, null)))));
        System.out.println(lastIndexOf(node, 3));
    }


    static int lastIndexOf(Node head, Object value) {
        int index = -1;
        int counter = index;
        while (head != null) {
            counter++;
            if (head.data == value) {
                index = counter;
            }
            head = head.next;
        }
        return index;
    }


}
