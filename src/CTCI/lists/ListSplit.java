package CTCI.lists;

import CTCI.dataStructures.ListNode;

public class ListSplit {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[] {3, 5, 8, 5, 10, 2, 1});
        ListNode.printList(head);
        int num = 5;
        ListNode res = splitList(head, num);
        ListNode.printList(res);
    }

    private static ListNode splitList(ListNode node, int num) {
        ListNode head = node;
        ListNode tail = node;
        while (node != null) {
            ListNode next = node.getNext();
            if (node.getVal() < num) {
                node.setNext(head);
                head = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
            node = next;
        }
        tail.setNext(null);

        return head;
    }

}
