package CTCI.lists;

import CTCI.dataStructures.ListNode;

public class LoopDetection {
    static class Result {
        ListNode metNode;
        boolean isLooped;

        public Result(ListNode metNode, boolean isLooped) {
            this.metNode = metNode;
            this.isLooped = isLooped;
        }
    }
    public static ListNode detectLoopStart(ListNode head) {
        Result res = detectLoop(head);
        if (!res.isLooped) return null;

        ListNode metNode = res.metNode;

        while (head != metNode) {
            head = head.next;
            metNode = metNode.next;
        }
        return head;
    }

    private static Result detectLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return new Result(slow, true);
            }
        }
        return new Result(null, false);
    }

    public static void main(String[] args) {
        // Step 1: Create nodes manually
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        // Step 2: Link them
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // Step 3: Create the loop — e → c
        e.next = c;

        // Step 4: Run loop detection
        ListNode loopStart = detectLoopStart(a);

        // Step 5: Print result
        if (loopStart != null) {
            System.out.println("Loop starts at node with value: " + loopStart.val);
        } else {
            System.out.println("No loop detected.");
        }
    }

}
