package CTCI.lists;

import CTCI.dataStructures.ListNode;

public class FindKthLast {
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        int k = 2;
        ListNode result = kthToLast(head, k);

        if (result != null) {
            System.out.println("The " + k + "th to last element is: " + result.getVal());
        } else {
            System.out.println("Invalid k or empty list.");
        }
    }

    public static ListNode kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) return null; // k > length
            fast = fast.getNext();
        }

        // Move both pointers until fast reaches end
        while (fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow;
    }

}
