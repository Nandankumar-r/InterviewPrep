package CTCI.lists;

import CTCI.dataStructures.ListNode;

import static CTCI.dataStructures.ListNode.appendList;

public class FindIntersection {
    static class Result {
        ListNode tail;
        int length;

        Result(ListNode tail, int length) {
            this.tail = tail;
            this.length = length;
        }
    }


    public static ListNode findIntersection(ListNode headA, ListNode headB) {
        Result resultA = getTailAndLength(headA);
        Result resultB = getTailAndLength(headB);

        if (resultA.tail != resultB.tail) return null;

        int diff = Math.abs(resultA.length - resultB.length);
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        if (resultA.length > resultB.length) {
            pointerA = move(headA, diff);
        } else if (resultA.length < resultB.length) {
            pointerB = move(headB, diff);
        }


        while(pointerA != pointerB) {
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return pointerA;
    }

    private static ListNode move(ListNode tail, int diff) {
        while (tail != null && diff > 0) {
            tail = tail.next;
            diff--;
        }
        return tail;
    }

    private static Result getTailAndLength(ListNode node) {
        int length = 0;
        ListNode prev = null;
        while (node != null) {
            length++;
            prev = node;
            node = node.next;
        }
        return new Result(prev, length);
    }

    public static void main(String[] args) {
        ListNode common = ListNode.createList(new int[]{7, 8, 9});

        ListNode headA = ListNode.createList(new int[]{1, 2});
        appendList(headA, common);

        ListNode headB = ListNode.createList(new int[]{3});
        appendList(headB, common);

        ListNode result = findIntersection(headA, headB);
        System.out.println(result.val); // Should be 7
    }
}
