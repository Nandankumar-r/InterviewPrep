package CTCI.dataStructures;

public class ListNode {
    public int val;
    public ListNode next;

    // Constructor
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Optional: Constructor to chain nodes quickly
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {}

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static ListNode getElement(ListNode list, int num) {
        while (list != null) {
            if (list.val == num) {
                return list;
            }
            list = list.next;
        }
        return null;
    }

    public static void appendList(ListNode head, ListNode tail) {
        if (head == null) return;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = tail;
    }

}
