package CTCI.lists;

import CTCI.dataStructures.ListNode;

public class Palindrome {
    static class Result {
        ListNode node;
        boolean isPalindrome;

        Result(ListNode node, boolean isPalindrome) {
            this.node = node;
            this.isPalindrome = isPalindrome;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        int length = getLength(head);
        Result res = isPalindromeRecurse(head, length);
        return res.isPalindrome;
    }

    private static Result isPalindromeRecurse(ListNode head, int length) {
        if (head == null || length <= 0) {
            // Even number of nodes
            return new Result(head, true);
        } else if (length == 1) {
            // Odd number of nodes
            return new Result(head.next, true);
        }
        // Recurse into sublist
        Result res = isPalindromeRecurse(head.next, length - 2);
        // If child calls were not palindrome, bubble up false
        if (!res.isPalindrome || res.node == null) {
            return res;
        }
        // Check if current node matches mirrored node
        res.isPalindrome = (head.val == res.node.val);
        // Move to next node in mirror check
        res.node = res.node.next;
        return res;
    }

    private static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
