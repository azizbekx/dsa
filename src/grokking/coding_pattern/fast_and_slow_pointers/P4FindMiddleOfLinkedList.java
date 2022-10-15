package grokking.coding_pattern.fast_and_slow_pointers;

import grokking.coding_pattern.ListNode;

public class P4FindMiddleOfLinkedList {
    /*
    Time  - O(n)
    Space - O(1)
     */
    public static ListNode findMiddle(ListNode head) {
        ListNode first = head, slow = head;
        while (first != null && first.next != null) {
            slow = slow.next;
            first = first.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " +findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + findMiddle(head).value);
    }
}
