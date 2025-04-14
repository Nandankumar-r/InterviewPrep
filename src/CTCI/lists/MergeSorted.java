package CTCI.lists;

import CTCI.dataStructures.ListNode;

public class MergeSorted {
    public static void main(String[] args) {
        ListNode list1 = ListNode.createList(new int[] {1, 2, 4});
        ListNode list2 = ListNode.createList(new int[] {1, 3, 4});
        ListNode res = mergeTwoLists(list1, list2);
        ListNode.printList(res);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
}
