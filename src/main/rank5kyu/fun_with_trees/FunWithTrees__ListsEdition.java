package rank5kyu.fun_with_trees;

import java.util.*;

public class FunWithTrees__ListsEdition {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(17, new ListNode(1));
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(16);
        ListNode l6 = new ListNode(7, new ListNode(3));
        TreeNode root = new TreeNode(l1, new TreeNode(l2, new TreeNode(l4), null), new TreeNode(l3, new TreeNode(l5), new TreeNode(l6)));
        System.out.println(flatten(root));

    }



    static ListNode flatten(TreeNode root) {
        List<ListNode> listNodes = new ArrayList<>();
        addNodesFromTree(listNodes, root);
        listNodes.forEach(elem -> elem.next = null);
        listNodes.sort(Comparator.comparingInt(o -> o.data));
        return getResultNode(listNodes);
    }

    private static ListNode getResultNode(List<ListNode> listNodes) {
        ListNode resultNode = new ListNode(0, null);
        ListNode temp = resultNode;
        for (ListNode node : listNodes) {
            temp.next = node;
            temp = temp.next;
        }
        return resultNode.next;
    }


    private static void addNodesFromTree(List<ListNode> listNodes, TreeNode root) {
        if (root != null) {
            addNodesFromNode(listNodes, root.value);
            addNodesFromTree(listNodes, root.left);
            addNodesFromTree(listNodes, root.right);
        }
    }

    private static void addNodesFromNode(List<ListNode> listNodes, ListNode node) {
        while(node != null) {
            if (!contains(listNodes, node)) {
                listNodes.add(node);
            }
            node = node.next;
        }
    }

    private static boolean contains(List<ListNode> listNodes, ListNode node) {
        return listNodes.stream().anyMatch(elem -> elem.data == node.data);
    }






//
//
//    private static void outputList(List<ListNode> list) {
//        for (ListNode node : list) {
//            System.out.println(output(node));
//        }
//    }
//
//
//    private static String output(ListNode node) {
//        return "ListNode{" +
//                "data=" + node.data +
//                ", next=" + node.next +
//                '}';
//    }

}
