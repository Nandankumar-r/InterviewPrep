package CTCI.lists;

import CTCI.dataStructures.ListNode;

public class DeleteMid {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        ListNode nodeToDelete = head.getNext().getNext(); // Node with value 3
        ListNode.printList(head);
        deleteMiddle(nodeToDelete);
        ListNode.printList(head);
    }
    public static void deleteMiddle(ListNode node) {
        if (node == null || node.getNext() == null) {
            throw new IllegalArgumentException("Node must not be null or tail node.");
        }

        node.setVal(node.getNext().getVal());
        node.setNext(node.getNext().getNext());
    }
}
