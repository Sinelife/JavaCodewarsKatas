package rank7kyu.fun_with_lists;

public class FunWithLists__IndexOf {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, new Node<>(5, null)))));
        System.out.println(indexOf(node, 3));
    }



    static int indexOf(Node head, Object value) {
        int index = -1;
        while (head != null) {
            index++;
            if (head.data == value) {
                return index;
            }
            head = head.next;
        }
        return -1;
    }
}
