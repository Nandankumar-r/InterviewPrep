package CTCI.lists;

import CTCI.dataStructures.ListNode;

import static CTCI.dataStructures.ListNode.printList;

public class SumTwoLists {
    static class SumResult {
        ListNode node;
        int carry;
        SumResult(ListNode node, int carry) {
            this.node = node;
            this.carry = carry;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else if (len1 > len2) {
            l2 = padList(l2, len1 - len2);
        }

        SumResult res = addListHelper(l1, l2);

        if (res.carry > 0) {
            ListNode head = new ListNode(res.carry);
            head.next = res.node;
            return head;
        }
        return res.node;
    }

    private static SumResult addListHelper(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return new SumResult(null, 0);

        SumResult next = addListHelper(l1.next, l2.next);
        int sum = l1.val + l2.val + next.carry;
        ListNode current = new ListNode(sum % 10);
        current.next = next.node;
        return new SumResult(current, sum / 10);
    }

    private static ListNode padList(ListNode node, int padCount) {
        for (int i = 0; i < padCount; i++) {
            ListNode head = new ListNode(0);
            head.next = node;
            node = head;
        }
        return node;
    }

    public static int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static void main(String[] args) {
        // Input: (7 -> 1 -> 6) + (5 -> 9 -> 2) = 1 -> 3 -> 0 -> 8
        ListNode l1 = ListNode.createList(new int[]{6, 1, 7}); // Represents 617
        ListNode l2 = ListNode.createList(new int[]{2, 9, 5}); // Represents 295

        ListNode result = SumTwoLists.addTwoNumbers(l1, l2);

        printList(result); // Should print: 9 -> 1 -> 2 (617 + 295 = 912)
    }
}
